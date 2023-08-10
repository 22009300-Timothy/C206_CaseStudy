import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<User> userList = new ArrayList<User>();

		ArrayList<Fees> feesList = new ArrayList<Fees>();

		userList.add(new User("U01", "G V Timothy", "Administrator"));
		userList.add(new User("U02", "Toby Oh", "Administrator"));

		feesList.add(new Fees("F01", "G V Timothy", "Paid"));
		feesList.add(new Fees("F02", "Toby Oh", "Pending"));

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

				int detailType = 0;

				while (detailType != 4) {

					C206_CaseStudy.setHeader("USERS");
					C206_CaseStudy.setHeader("DETAIL TYPES");
					System.out.println("1. Add a new user");
					System.out.println("2. View all users");
					System.out.println("3. Delete an existing user");
					System.out.println("4. Quit");

					detailType = Helper.readInt("\nEnter option to select detail type > ");

					if (detailType == 1) {
						// Add a a new user
						User u = inputUser();
						C206_CaseStudy.addUser(userList, u);
					} else if (detailType == 2) {
						// View all users
						C206_CaseStudy.viewAllUser(userList);
					} else if (detailType == 3) {
						// Delete an existing user
						String id = Helper.readString("Enter user id > ");
						C206_CaseStudy.deleteUser(userList, id);
					} else if (detailType == 4) {
						System.out.println("Thank you!");
					} else {
						System.out.println("Invalid option");
					}
				}

			} else if (option == 2) {
				// Li Hua
			} else if (option == 3) {
				// Jian Hong
			} else if (option == 4) {
				int detailType = 0;

				while (detailType != 4) {

					C206_CaseStudy.setHeader("FEES");
					C206_CaseStudy.setHeader("DETAIL TYPES");
					System.out.println("1. Add a new Fee");
					System.out.println("2. View all Fees");
					System.out.println("3. Delete an existing Fee");
					System.out.println("4. Quit");

					detailType = Helper.readInt("\nEnter option to select detail type > ");

					if (detailType == 1) {
						// Add a a new user
						Fees f = inputFees();
						C206_CaseStudy.addFees(feesList, f);
					} else if (detailType == 2) {
						// View all users
						C206_CaseStudy.viewAllFees(feesList);
					} else if (detailType == 3) {
						// Delete an existing user
						String id = Helper.readString("Enter fee id > ");
						C206_CaseStudy.deleteFees(feesList, id);
					} else if (detailType == 4) {
						System.out.println("Thank you!");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 5) {
				// Xavier
			} else if (option == 6) {
				// Toby
			} else if (option == 7) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("TUITION MANAGEMENT APP");
		System.out.println("1. Manage Users");
		System.out.println("2. Manage Courses");
		System.out.println("3. Manage Students");
		System.out.println("4. Manage Fees");
		System.out.println("5. Manage Enrolments");
		System.out.println("6. Manage Attendance");
		System.out.println("7. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option 1 Manage users =================================

	public static User inputUser() {
		String id = Helper.readString("Enter user id > ");
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");

		User u = new User(id, name, role);
		return u;

	}

	public static void addUser(ArrayList<User> userList, User u) {
		User detail;
		for (int i = 0; i < userList.size(); i++) {
			detail = userList.get(i);
			if (detail.getId().equalsIgnoreCase(u.getId()))
				return;
		}
		if ((u.getId().isEmpty()) || (u.getName().isEmpty())) {
			System.out.println("User id or name cannot be empty");
			return;
		} else {
			userList.add(u);
			System.out.println("User added");
		}
	}

	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-10s %-20s %-20s\n", userList.get(i).getId(), userList.get(i).getName(),
					userList.get(i).getRole());
		}
		return output;
	}

	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-20s %-20s\n", "USER ID", "NAME", "ROLE");
		output += retrieveAllUser(userList);
		System.out.println(output);
	}

	public static void deleteUser(ArrayList<User> userList, String id) {
		for (int i = 0; i < userList.size(); i++) {
			User detail = userList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				userList.remove(i);
				System.out.println("User deleted");
				return;
			}
		}
		System.out.println("User not found");
	}
	
	// ================================= Option 4 Manage Fees =================================

	public static Fees inputFees() {
		String id = Helper.readString("Enter fee id > ");
		String name = Helper.readString("Enter name > ");
		String status = Helper.readString("Enter status > ");

		Fees f = new Fees(id, name, status);
		return f;

	}

	public static void addFees(ArrayList<Fees> feesList, Fees f) {
		Fees detail;
		for (int i = 0; i < feesList.size(); i++) {
			detail = feesList.get(i);
			if (detail.getId().equalsIgnoreCase(f.getId()))
				return;
		}
		if ((f.getId().isEmpty()) || (f.getName().isEmpty())) {
			System.out.println("Fees id or name cannot be empty");
			return;
		} else {
			feesList.add(f);
			System.out.println("Fee added");
		}
	}

	public static String retrieveAllFees(ArrayList<Fees> feesList) {
		String output = "";

		for (int i = 0; i < feesList.size(); i++) {
			output += String.format("%-10s %-20s %-20s\n", feesList.get(i).getId(), feesList.get(i).getName(),
					feesList.get(i).getStatus());
		}
		return output;
	}

	public static void viewAllFees(ArrayList<Fees> feesList) {
		C206_CaseStudy.setHeader("FEES LIST");
		String output = String.format("%-10s %-20s %-20s\n", "FEES ID", "NAME", "UPDATED PROGRESS");
		output += retrieveAllFees(feesList);
		System.out.println(output);
	}

	public static void deleteFees(ArrayList<Fees> feesList, String id) {
		for (int i = 0; i < feesList.size(); i++) {
			Fees detail = feesList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				feesList.remove(i);
				System.out.println("Fee deleted");
				return;
			}
		}
		System.out.println("Fee ID not found");
	}

} // end of class