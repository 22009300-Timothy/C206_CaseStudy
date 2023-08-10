import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int DETAIL_QUIT = 4;
	private static final int OPTION_QUIT = 7;

	public static void main(String[] args) {
<<<<<<< HEAD

		ArrayList<User> userList = new ArrayList<User>();

		ArrayList<Student> studentList = new ArrayList<Student>();

		userList.add(new User("U01", "G V Timothy", "Administrator"));
		userList.add(new User("U02", "Toby Oh", "Administrator"));

		studentList.add(new Student("S01", "G V Timothy", 12));
		studentList.add(new Student("S02", "Toby Oh", 14));

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
				int detailType = 0;

				while (detailType != 4) {

					C206_CaseStudy.setHeader("STUDENT");
					C206_CaseStudy.setHeader("DETAIL TYPES");
					System.out.println("1. Add a new student");
					System.out.println("2. View all student");
					System.out.println("3. Delete an existing student");
					System.out.println("4. Quit");

					detailType = Helper.readInt("\nEnter option to select detail type > ");

					if (detailType == 1) {
						// Add a a new user
						Student s = inputStudent();
						C206_CaseStudy.addStudent(studentList, s);
					} else if (detailType == 2) {
						// View all users
						C206_CaseStudy.viewAllStudent(studentList);
					} else if (detailType == 3) {
						// Delete an existing user
						String id = Helper.readString("Enter student id > ");
						C206_CaseStudy.deleteStudent(studentList, id);
					} else if (detailType == 4) {
						System.out.println("Thank you!");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 4) {
				// Ryan
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

	// ================================= Option 1 Manage users
	// =================================

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

	// ================================= Option 3 Manage students
	// =================================

	public static Student inputStudent() {
		String id = Helper.readString("Enter student id > ");
		String name = Helper.readString("Enter name > ");
		int age = Helper.readInt("Enter age > ");

		Student s = new Student(id, name, age);
		return s;

	}

	public static void addStudent(ArrayList<Student> studentList, Student s) {
		Student detail;
		for (int i = 0; i < studentList.size(); i++) {
			detail = studentList.get(i);
			if (detail.getId().equalsIgnoreCase(s.getId()))
				return;
		}
		if ((s.getId().isEmpty()) || (s.getName().isEmpty())) {
			System.out.println("Student id or name cannot be empty");
			return;
		} else {
			studentList.add(s);
			System.out.println("Student added");
		}
	}

	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";

		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10s %-20s %-20d\n", studentList.get(i).getId(), studentList.get(i).getName(),
					studentList.get(i).getAge());
		}
		return output;
	}

	public static void viewAllStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("STUDENT LIST");
		String output = String.format("%-10s %-20s %-20s\n", "USER ID", "NAME", "AGE");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}

	public static void deleteStudent(ArrayList<Student> studentList, String id) {
		for (int i = 0; i < studentList.size(); i++) {
			Student detail = studentList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				studentList.remove(i);
				System.out.println("Student deleted");
				return;
			}
		}
		System.out.println("Student not found");
=======
		
		ArrayList<User> userList = new ArrayList<User>();
		
		userList.add(new User("U01", "G V Timothy", "Administrator"));
		userList.add(new User("U02", "Toby Oh", "Administrator"));
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				// Timothy
				int detailType = 0;
				
				while (detailType != DETAIL_QUIT) {
					
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
						String id = Helper.readString("\nEnter user id > ");
						C206_CaseStudy.deleteUser(userList, id);
					} else if (detailType == DETAIL_QUIT) {
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
				// Toby
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy
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
		String id = Helper.readString("\nEnter user id > ");
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");

		User u= new User(id, name, role);
		return u;
		
	}
	
	public static void addUser(ArrayList<User> userList, User u) {
	    for (User detail : userList) {
	        String id = detail.getId();
			if (u.getId().equalsIgnoreCase(id)) {
	            System.out.println("\nUser id has already been added");
	            return;
	        }
	    }
	    
	    if (u.getId().isEmpty() || u.getName().isEmpty()) {
	        System.out.println("\nUser id or name cannot be empty");
	    } else {
	        userList.add(u);
	        System.out.println("\nUser added");
	    }
	}
	
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-52s \n", userList.get(i).toString());
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
			if (id.equalsIgnoreCase(detail.getId())) {
				userList.remove(i);
				System.out.println("\nUser deleted");
				return;
			}
		}
		System.out.println("\nUser not found");
	}
	
} // end of class