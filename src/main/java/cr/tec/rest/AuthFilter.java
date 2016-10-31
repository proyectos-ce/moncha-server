package cr.tec.rest;

import cr.tec.struct.Message;
import cr.tec.struct.Role;
import cr.tec.struct.User;
import cr.tec.utils.security.Secured;
import cr.tec.utils.security.TokenProvider;
import cr.tec.utils.security.JWTPrincipal;
import cr.tec.utils.security.JWTSecurityContext;

import javax.annotation.Priority;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joseph on 10/30/16.
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// Get the resource class which matches with the requested URL
		// Extract the roles declared by it
		Class<?> resourceClass = resourceInfo.getResourceClass();
		List<Role> classRoles = extractRoles(resourceClass);

		// Get the resource method which matches with the requested URL
		// Extract the roles declared by it
		Method resourceMethod = resourceInfo.getResourceMethod();
		List<Role> methodRoles = extractRoles(resourceMethod);

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
				requestContext.abortWith(
						Response.status(Response.Status.UNAUTHORIZED).entity(new Message("error", "HARAMBE ERROR: An error occurred while decoding the token.")).type(MediaType.APPLICATION_JSON).build());
			return;
		}

		try {
			// Check if the user is allowed to execute the method
			// The method annotations override the class annotations
			if (methodRoles.isEmpty()) {
				checkPermissions(classRoles, userData);
			} else {
				checkPermissions(methodRoles, userData);
			}

		} catch (Exception e) {
			requestContext.abortWith(
					Response.status(Response.Status.FORBIDDEN).build());
		}


		JWTPrincipal principal = JWTPrincipal.buildPrincipal(userData);

		if (principal != null) {
			JWTSecurityContext ctx = new JWTSecurityContext(
					principal,
					requestContext.getSecurityContext().isSecure());
			requestContext.setSecurityContext(ctx);
		}

	}

	// Extract the roles from the annotated element
	private List<Role> extractRoles(AnnotatedElement annotatedElement) {
		if (annotatedElement == null) {
			return new ArrayList<Role>();
		} else {
			Secured secured = annotatedElement.getAnnotation(Secured.class);
			if (secured == null) {
				return new ArrayList<Role>();
			} else {
				Role[] allowedRoles = secured.value();
				return Arrays.asList(allowedRoles);
			}
		}
	}


	private void checkPermissions(List<Role> allowedRoles, User userData) throws Exception {
		// Check if the user contains one of the allowed roles
		// Throw an Exception if the user has not permission to execute the method

		if (allowedRoles.isEmpty()) {
			return;
		}

		if (!allowedRoles.contains(userData.getRole())) {
			throw new ForbiddenException();
		}

	}
}