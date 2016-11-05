package cr.tec.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import cr.tec.struct.Role;
import cr.tec.struct.User;
import cr.tec.struct.UserList;
import cr.tec.utils.security.TokenProvider;
import org.jose4j.lang.JoseException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by joseph on 10/30/16.
 */
@Path("/auth")
public class AuthApi {
	@POST
	@Path("/client")
	@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response authClient(User meta) throws JoseException, JsonProcessingException {
		meta.setRole(Role.CLIENT);
		UserList.add(meta);
		return Response.ok(TokenProvider.issueToken(meta)).header("Access-Control-Allow-Origin", "*").build();


	}

	@POST
	@Path("/client")
	public Response authClientCORS() {
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}


	@POST
	@Path("/chef")
	@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response authChef(User meta) throws JoseException, JsonProcessingException {
		meta.setRole(Role.CHEF);
		return Response.ok(TokenProvider.issueToken(meta)).header("Access-Control-Allow-Origin", "*").build();

	}

	@POST
	@Path("/chef")
	public Response authChefCORS() {
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	@POST
	@Path("/verify")
	@Produces({MediaType.APPLICATION_JSON})
	public User verifyToken(@FormParam("data") String data) {
		User verified = TokenProvider.verifyToken(data);
		if (verified==null) {
			System.out.println("Falló la autenticación");
			return null;
		} else {
			return verified;
		}
	}

}
