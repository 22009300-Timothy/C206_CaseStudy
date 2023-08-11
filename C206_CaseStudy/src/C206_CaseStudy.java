import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		userList.add(new User("U01", "G V Timothy", "Administrator"));
		userList.add(new User("U02", "Toby Oh", "Administrator"));
		
		courseList.add(new Course("C01", "G V Timothy", "Popular"));
		courseList.add(new Course("C02", "Toby Oh", "Not Popular"));
		
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
				int detailType = 0;
				
				while (detailType != 4) {
					
					C206_CaseStudy.setHeader("COURSES");			
					C206_CaseStudy.setHeader("DETAIL DESCRIPTION");
					System.out.println("1. Add a new course");
					System.out.println("2. View all courses");
					System.out.println("3. Delete an existing course");
					System.out.println("4. Quit");
					
					detailType = Helper.readInt("\nEnter option to select course description > ");
					
					if (detailType == 1) {
						// Add a a new course
						Course c = inputCourse();
						C206_CaseStudy.addCourse(courseList, c);
					} else if (detailType == 2) {
						// View all courses
						C206_CaseStudy.viewAllCourse(courseList);
					}  else if (detailType == 3) {
						// Delete an existing course
						String id = Helper.readString("Enter user id > ");
						C206_CaseStudy.deleteCourse(courseList, id);
					} else if (detailType == 4) {
						System.out.println("Thank you!");
					} else {
						System.out.println("Invalid option");
					}	
				}
			} else if (option == 3) {
				// Jian Hong	
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
	}// end of class


//================================= Option 2 Manage courses =================================

	public static Course inputCourse() {
		String id = Helper.readString("Enter user id > ");
		String name = Helper.readString("Enter name > ");
		String details = Helper.readString("Enter Course Details > ");

		Course c= new Course(id, name, details);
		return c;	
	}
	
	public static void addCourse(ArrayList<Course> courseList, Course c) {
		Course detail;
		for(int i = 0; i < courseList.size(); i++) {
			detail = courseList.get(i);
			if (detail.getId().equalsIgnoreCase(c.getId()) )
				return;
		}
		if ((c.getId().isEmpty()) || (c.getName().isEmpty()) ) {
			System.out.println("Course details cannot be empty");
			return;
		} else {
			courseList.add(c);
			System.out.println("Course added");
		}
	}
	
	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String output = "";

		for (int i = 0; i < courseList.size(); i++) {
			output += String.format("%-10s %-20s %-20s\n", courseList.get(i).getId(), 
					courseList.get(i).getName(), courseList.get(i).getDetails());
		}
		return output;
	}
	
	public static void viewAllCourse(ArrayList<Course> courseList) {
		C206_CaseStudy.setHeader("COURSE LIST");
		String output = String.format("%-10s %-20s %-20s\n", "USER ID", "NAME",
				"DETAILS");
		 output += retrieveAllCourse(courseList);	
		System.out.println(output);
	}
	
	public static void deleteCourse(ArrayList<Course> courseList, String id) {
		for(int i = 0; i < courseList.size(); i++) {
			Course detail = courseList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				courseList.remove(i);
				System.out.println("Course deleted");
				return;
			}
		}
		System.out.println("Course not found");
	}
} // end of class

