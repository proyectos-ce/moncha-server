package cr.tec.rest;

import cr.tec.struct.Message;
import cr.tec.struct.User;
import cr.tec.utils.security.Secured;
import cr.tec.utils.security.TokenProvider;
import cr.tec.utils.security.JWTPrincipal;
import cr.tec.utils.security.JWTSecurityContext;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by joseph on 10/30/16.
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// Get the HTTP Authorization header from the request
		String authorizationHeader =
				requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// Check if the HTTP Authorization header is present and formatted correctly
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new NotAuthorizedException("Authorization header must be provided");
		}

		// Extract the token from the HTTP Authorization header
		String token = authorizationHeader.substring("Bearer".length()).trim();

		User userData;

		try {
			userData = TokenProvider.verifyToken(token);
			// Validate the token
			if (userData == null) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(new Message("error", "HARAMBE ERROR: The token is invalid.")).type(MediaType.APPLICATION_JSON).build());
			}
		} catch (Exception e) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(new Message("error", "HARAMBE ERROR: An error occured while decoding the token.")).type(MediaType.APPLICATION_JSON).build());
			return;
		}


		JWTPrincipal principal = JWTPrincipal.buildPrincipal(userData);

		if (principal != null) {
			JWTSecurityContext ctx = new JWTSecurityContext(
					principal,
					requestContext.getSecurityContext().isSecure());
			requestContext.setSecurityContext(ctx);
		}

	}

	private void validateToken(String token) throws Exception {
		// Check if it was issued by the server and if it's not expired
		// Throw an Exception if the token is invalid
	}
}