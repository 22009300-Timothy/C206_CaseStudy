
public class User extends Institution{
	
	private String role;
	
	public User(String id, String name, String role) {
		super(id, name);
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void displayDetails() {
		 super.displayDetails();
		 System.out.println("Role : " + role);
	}
	
	public String toString() {
		String output = super.toString();
		output = String.format("%-31s %-20s", output, role);
		return output;
	}
	
} // end of class