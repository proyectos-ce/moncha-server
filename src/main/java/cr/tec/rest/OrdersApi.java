package cr.tec.rest;

import cr.tec.utils.security.Secured;
import cr.tec.utils.security.JWTPrincipal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * Created by joseph on 10/30/16.
 */
@Path( "/orders" )
public class OrdersApi {
	@Context
	protected SecurityContext securityContext;

	@GET
	@Secured
	@Produces({MediaType.APPLICATION_JSON})
	public Response test() {
		return Response.ok(getUser().getUserData()).build();
	}

	private JWTPrincipal getUser() {
		return (JWTPrincipal) securityContext.getUserPrincipal();
	}

}
