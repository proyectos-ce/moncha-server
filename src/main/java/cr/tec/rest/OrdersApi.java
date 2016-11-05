package cr.tec.rest;

import cr.tec.struct.*;
import cr.tec.utils.Database;
import cr.tec.utils.security.Secured;
import cr.tec.utils.security.JWTPrincipal;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
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
	@Path("{id}")
	@Produces("application/json")
	public Order getOrder(@PathParam("id") int id) {
		return OrderManager.getOrder(id);
	}

	@GET
	@Path("{id}/suborders/{sub}")
	@Produces("application/json")
	public Suborder getOrderSteps(@PathParam("id") int id, @PathParam("sub") int sub) {
		return OrderManager.getOrder(id).getSuborders().get(sub - 1);
	}


	private JWTPrincipal getUser() {
		return (JWTPrincipal) securityContext.getUserPrincipal();
	}

}
