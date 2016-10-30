package cr.tec.utils.security;

import cr.tec.struct.User;

import java.security.Principal;

/**
 * Created by joseph on 10/30/16.
 */
public class JWTPrincipal implements Principal {
	private String name;
	private User userData;
	private String[] roles;

	public JWTPrincipal(
			final String name,
			final User userData) {
		this.name = name;
		this.userData = userData;
	}

	public static JWTPrincipal buildPrincipal(final User userData) {
		JWTPrincipal principal = null;

		try {
			if (userData != null) {
				String name = null;

				// TODO: Extract custom attributes, e.g. roles, organization affiliation etc. and put into principal.

				principal = new JWTPrincipal(name, userData);
			}
		} catch (Exception ignored) {
		}
		return principal;
	}

	public User getUserData() {
		return userData;
	}

	/* (non-Javadoc)
	 * @see java.security.Principal#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public String[] getRoles() {
		return roles;
	}



}
