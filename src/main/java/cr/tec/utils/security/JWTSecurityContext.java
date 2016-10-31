package cr.tec.utils.security;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by joseph on 10/30/16.
 */
public class JWTSecurityContext implements SecurityContext {
	private JWTPrincipal principal;
	private boolean isSecure;
	private Set<String> roles = new HashSet<>();

	public JWTSecurityContext(final JWTPrincipal principal, final boolean isSecure) {
		this.principal = principal;
		this.isSecure = isSecure;
		String[] names = principal.getRoles();
		for (int iIndex = 0; names != null && iIndex < names.length; ++iIndex) {
			roles.add(names[iIndex]);
		}
	}

	@Override
	public String getAuthenticationScheme() {
		return "JWT"; // informational
	}

	@Override
	public Principal getUserPrincipal() {
		return principal;
	}

	@Override
	public boolean isSecure() {
		return isSecure;
	}

	@Override
	public boolean isUserInRole(final String role) {
		return roles.contains(role);
	}
}