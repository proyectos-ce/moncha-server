package cr.tec.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import cr.tec.struct.Role;
import cr.tec.struct.User;
import cr.tec.utils.security.TokenProvider;
import org.jose4j.lang.JoseException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by joseph on 10/30/16.
 */
@Path("/auth")
public class AuthApi {
	@POST
	@Path("/client")
	@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON})
	public String authClient(User meta) throws JoseException, JsonProcessingException {
		meta.setRole(Role.CLIENT);
		return TokenProvider.issueToken(meta);

	}
	@POST
	@Path("/chef")
	@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON})
	public String authChef(User meta) throws JoseException, JsonProcessingException {
		meta.setRole(Role.CHEF);
		return TokenProvider.issueToken(meta);

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
