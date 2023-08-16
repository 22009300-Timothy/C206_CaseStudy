// 22009300 Timothy
public class User extends Institution {

	private String username;
	private String password;
	private String role;

	public User(String id, String name, String username, String password, String role) {
		super(id, name);
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		String output = super.toString();
		output = String.format("%-31s %-20s", output, role);
		return output;
	}
	
} // end of class