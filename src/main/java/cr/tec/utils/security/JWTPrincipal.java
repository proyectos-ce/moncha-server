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

	private JWTPrincipal(
			final String name,
			final User userData, final String[] roles) {
		this.name = name;
		this.userData = userData;
		this.roles = roles;
	}

	public static JWTPrincipal buildPrincipal(final User userData) {
		JWTPrincipal principal = null;

		try {
			if (userData != null) {
				principal = new JWTPrincipal(null, userData, new String[] {userData.getRole().toString()});
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

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String[] roles) {
		this.roles = roles;
	}




}
