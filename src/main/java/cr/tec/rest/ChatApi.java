package cr.tec.rest;

import cr.tec.struct.Message;
import cr.tec.utils.FirebaseManager;
import cr.tec.utils.security.JWTPrincipal;
import cr.tec.utils.security.Secured;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

/**
 * Created by joseph on 11/4/16.
 */
@Path( "/chat" )
public class ChatApi {


	@Context
	protected SecurityContext securityContext;

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.TEXT_PLAIN})
	@Secured
	public Message postMessage(String msg) throws IOException {

		return FirebaseManager.postChat(msg, getUser().getUserData());

	}

	private JWTPrincipal getUser() {
		return (JWTPrincipal) securityContext.getUserPrincipal();
	}

}
