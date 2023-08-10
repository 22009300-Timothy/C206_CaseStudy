import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int QUIT_ATTENDANCE = 4;
	private static final int DELETE_ATTENDANCE = 3;
	private static final int VIEW_ATTENDANCE = 2;
	private static final int ADD_ATTENDANCE = 1;

	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
		
		userList.add(new User("U01", "G V Timothy", "Administrator"));
		userList.add(new User("U02", "Toby Oh", "Administrator"));
		
		attendanceList.add(new Attendance("A01", "Toby Oh", "Absent"));
		attendanceList.add(new Attendance("A02", "G V Timothy", "Present"));
		
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
					}  else if (detailType == 3) {
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
				// Ryan
			} else if (option == 5) {
				// Xavier
			} else if (option == 6) {
				
				int detailType = 0;

				while (detailType != 4) {

					C206_CaseStudy.setHeader("ATTENDANCE");			
					C206_CaseStudy.setHeader("DETAIL TYPES");
					System.out.println("1. Add a new attendance");
					System.out.println("2. View all attendance");
					System.out.println("3. Delete an attendance");
					System.out.println("4. Quit");

					detailType = Helper.readInt("\nEnter option to select detail type > ");

					if (detailType == ADD_ATTENDANCE) {
						// Add a new attendance
						Attendance a = inputAttendance();
						C206_CaseStudy.addAttendance(attendanceList, a);
					} else if (detailType == VIEW_ATTENDANCE) {
						// View all attendance
						C206_CaseStudy.viewAllAttendance(attendanceList);
					}  else if (detailType == DELETE_ATTENDANCE) {
						// Delete an attendance
						String id = Helper.readString("Enter user id > ");
						C206_CaseStudy.deleteAttendance(attendanceList, id);
					} else if (detailType == QUIT_ATTENDANCE) {
						System.out.println("Thank you!");
					} else {
						System.out.println("Invalid option");
					}	
				}
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
	
	//================================= Option 1 Manage users =================================
	
	public static User inputUser() {
		String id = Helper.readString("Enter user id > ");
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");

		User u= new User(id, name, role);
		return u;
		
	}
	
	public static void addUser(ArrayList<User> userList, User u) {
		User detail;
		for(int i = 0; i < userList.size(); i++) {
			detail = userList.get(i);
			if (detail.getId().equalsIgnoreCase(u.getId()) )
				return;
		}
		if ((u.getId().isEmpty()) || (u.getName().isEmpty()) ) {
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
			output += String.format("%-10s %-20s %-20s\n", userList.get(i).getId(), 
					userList.get(i).getName(), userList.get(i).getRole());
		}
		return output;
	}
	
	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-20s %-20s\n", "USER ID", "NAME",
				"ROLE");
		 output += retrieveAllUser(userList);	
		System.out.println(output);
	}
	
	public static void deleteUser(ArrayList<User> userList, String id) {
		for(int i = 0; i < userList.size(); i++) {
			User detail = userList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				userList.remove(i);
				System.out.println("User deleted");
				return;
			}
		}
		System.out.println("User not found");
	}
	
	
	
	
	//================================= Option 6 Manage Attendance =================================
	
	public static Attendance inputAttendance() {
		String id = Helper.readString("Enter user id > ");
		String name = Helper.readString("Enter name > ");
		String status = Helper.readString("Enter status > ");

		Attendance a = new Attendance(id, name, status);
		return a;
		
	}
	
	public static void addAttendance(ArrayList<Attendance> attendanceList, Attendance a) {
		Attendance detail;
		for(int i = 0; i < attendanceList.size(); i++) {
			detail = attendanceList.get(i);
			if (detail.getId().equalsIgnoreCase(a.getId()) )
				return;
		}
		if ((a.getId().isEmpty()) || (a.getName().isEmpty()) ) {
			System.out.println("User id or name cannot be empty");
			return;
		} else {
			attendanceList.add(a);
			System.out.println("Attendance added");
		}
	}
	//enhanced for loop idk work anot test only 
	//for (Attendance a : attendanceList) {
		//output += String.format("%-10s %-20s %-20s\n", a.getId(), a.getName(), a.getStatus());
	public static String retrieveAllAttendance(ArrayList<Attendance> attendanceList) {
		String output = "";

		for (int i = 0; i < attendanceList.size(); i++) {
			output += String.format("%-10s %-20s %-20s\n", attendanceList.get(i).getId(), 
					attendanceList.get(i).getName(), attendanceList.get(i).getStatus());
		}
		return output;
	}
	
	public static void viewAllAttendance(ArrayList<Attendance> attendanceList) {
		C206_CaseStudy.setHeader("ATTENDANCE LIST");
		String output = String.format("%-10s %-20s %-20s\n", "USER ID", "NAME",
				"ATTENDANCE");
		 output += retrieveAllAttendance(attendanceList);	
		System.out.println(output);
	}
	
	public static void deleteAttendance(ArrayList<Attendance> attendanceList, String id) {
		for(int i = 0; i < attendanceList.size(); i++) {
			Attendance detail = attendanceList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				attendanceList.remove(i);
				System.out.println("Attendance deleted");
				return;
			}
		}
		System.out.println("Attendance not found");
	}
	
} // end of class