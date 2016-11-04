package cr.tec.rest;

import cr.tec.struct.Message;
import cr.tec.struct.Order;
import cr.tec.struct.Suborder;
import cr.tec.struct.TableList;
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
		return TableList.placeOrder(getUser().getUserData().getTable(), getUser().getUserData().getType(), suborders);
	}

	@GET
	@Secured
	@Produces({MediaType.APPLICATION_JSON})
	public LinkedList<Order> getAllOrders() {
		return TableList.getAllOrders();
	}

	private JWTPrincipal getUser() {
		return (JWTPrincipal) securityContext.getUserPrincipal();
	}

}
