package app_config;

public class User {
	private String username;
	private boolean employee_version;
	private static User usuario;
	
	
	public User(String username, boolean employee_version) {
		this.username = username;
		this.employee_version = employee_version;
	}
	
	public boolean getEmployee_version() {
		return employee_version;
	}

	public static User getUsuario() {
		return usuario;
	}

	public static void setUsuario(User usuario) {
		User.usuario = usuario;
	}
	
}
