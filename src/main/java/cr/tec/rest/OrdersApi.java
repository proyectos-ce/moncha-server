package cr.tec.rest;

import cr.tec.struct.*;
import cr.tec.utils.Database;
import cr.tec.utils.FirebaseManager;
import cr.tec.utils.security.Secured;
import cr.tec.utils.security.JWTPrincipal;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by joseph on 10/30/16.
 */
@Path( "/orders" )
public class OrdersApi {
	@Context
	protected SecurityContext securityContext;

	@POST
	@Secured
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Message placeOrder(LinkedList<Suborder> suborders) {
		return OrderManager.placeOrder(getUser().getUserData(), suborders);
	}

	@GET
	@Secured
	@Produces({MediaType.APPLICATION_JSON})
	public LinkedList<Order> getAllOrders() {
		return OrderManager.getAllOrders();
	}

	@GET
	@Path("my")
	@Secured
	@Produces({MediaType.APPLICATION_JSON})
	public Order getMyOrder() {
		LinkedList<Order> orders = OrderManager.getAllOrders();
		for (Order order:orders    ) {
			if (order.getUser() == getUser().getUserData().getId()) {
				return order;
			}
		}

		return null;
	}

	@GET
	@Path("mine")
	@Secured
	@Produces({MediaType.APPLICATION_JSON})
	public LinkedList<Work> getMyOrders() {
		return UserList.get(getUser().getUserData().getId()).getCurrentWorks();
	}


	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Order getOrder(@PathParam("id") int id) {
		return OrderManager.getOrder(id);
	}

	@GET
	@Path("{id}/suborders/{sub}")
	@Produces({MediaType.APPLICATION_JSON})
	public Suborder getSuborder(@PathParam("id") int id, @PathParam("sub") int sub) {
		return OrderManager.getOrder(id).getSuborders().get(sub - 1);
	}

	@POST
	@Path("{id}/suborders/{sub}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Message completeSuborder(@PathParam("id") int id, @PathParam("sub") int sub, StepStatus stepData) throws IOException {
		Order order = OrderManager.getOrder(id);
		LinkedList<Suborder> suborders = order.getSuborders();
		suborders.get(sub - 1).setCompleted(stepData.isCompleted());
		User user = UserList.get(order.getUser());
		FirebaseManager.postNotification("Order updated", "Your order of '" + Database.getDish(suborders.get(sub - 1).getDishId()).getName() + "' step is on the way.", user);

		Boolean orderCompleted = true;
		for (Suborder suborder : suborders) {
			if (!suborder.isCompleted()) {
				orderCompleted = false;
			}
		}

		for (Work work : getUser().getUserData().getCurrentWorks() ) {
			if (work.getOrder() == id && work.getSuborder() == sub) {
				getUser().getUserData().getCurrentWorks().remove(work);
			}

		}

		if (orderCompleted) {
			OrderManager.getOrder(id).setCompleted(true);
		}

		return new Message("ok", "Order updated");
	}

	@GET
	@Path("{id}/suborders/{sub}/steps/{step}")
	@Produces({MediaType.APPLICATION_JSON})
	public StepStatus getOrderSteps(@PathParam("id") int id, @PathParam("sub") int sub, @PathParam("step") int step) {
		return OrderManager.getOrder(id).getSuborders().get(sub - 1).getSteps().get(step - 1);
	}

	@POST
	@Path("{id}/suborders/{sub}/steps/{step}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Message setStepStatus(@PathParam("id") int id, @PathParam("sub") int sub, @PathParam("step") int step, StepStatus stepData) throws IOException {
		Order order = OrderManager.getOrder(id);
		LinkedList<Suborder> suborders = order.getSuborders();
		LinkedList<StepStatus> steps = suborders.get(sub - 1).getSteps();
		steps.get(step - 1).setCompleted(stepData.isCompleted());
		User user = UserList.get(order.getUser());
		FirebaseManager.postNotification("Order updated", "Your order of '" + Database.getDish(suborders.get(sub - 1).getDishId()).getName() + "' step '" + suborders.get(sub - 1).getSteps().get(step - 1) + "' is now done.", user);

		Boolean suborderCompleted = true;
		for (StepStatus stp : steps) {
			if (!stp.isCompleted()) {
				suborderCompleted = false;
			}
		}

		if (suborderCompleted) {
			suborders.get(sub - 1).setCompleted(true);
		}

		return new Message("ok", "Order updated");
	}


	private JWTPrincipal getUser() {
		return (JWTPrincipal) securityContext.getUserPrincipal();
	}

}
