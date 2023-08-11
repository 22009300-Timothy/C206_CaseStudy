import java.util.ArrayList;
<<<<<<< HEAD
=======

	public class C206_CaseStudy {
		
	private static final int QUIT_ATTENDANCE = 4;
	private static final int DELETE_ATTENDANCE = 3;
	private static final int VIEW_ATTENDANCE = 2;
	private static final int ADD_ATTENDANCE = 1;
	private static final int DELETE_ENROLMENT = 3;
	private static final int VIEW_ENROLMENT = 2;
	private static final int ADD_ENROLMENT = 1;
	private static final int QUIT_ENROLMENT = 4;
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy

	public static void main(String[] args) {

<<<<<<< HEAD
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
=======
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Fees> feesList = new ArrayList<Fees>();
		ArrayList<Enrolment> enrolmentList = new ArrayList<Enrolment>();	
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();

		userList.add(new User("U01", "G V Timothy", "Administrator"));
		userList.add(new User("U02", "Toby Oh", "Administrator"));
		
		studentList.add(new Student("S01", "G V Timothy", 18));
		studentList.add(new Student("S02", "Toby Oh", 12));
		
		feesList.add(new Fees("F01", "G V Timothy", "Paid"));
		feesList.add(new Fees("F02", "Toby Oh", "Pending"));

		enrolmentList.add(new Enrolment("E01", "G V Timothy", "Science", "10/08/2023"));
		enrolmentList.add(new Enrolment("E02", "Toby Oh", "Mathematics", "04/06/2023"));
		
		attendanceList.add(new Attendance("E01", "G V Timothy", "Present"));
		attendanceList.add(new Attendance("E02", "Toby Oh", "Absent"));

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Timothy
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
				int detailType = 0;
		        
		        while (detailType != QUIT_ENROLMENT) {
		         
		         C206_CaseStudy.setHeader("ENROLMENTS");   
		         C206_CaseStudy.setHeader("DETAIL TYPES");
		         System.out.println("1. Add a new Enrolemnt");
		         System.out.println("2. View all Enrolments");
		         System.out.println("3. Delete an existing enrolment");
		         System.out.println("4. Quit");
		         
		         detailType = Helper.readInt("\nEnter option to select detail type > ");
		         
		         if (detailType == ADD_ENROLMENT) {
		          // Add a a new enrolment
		          Enrolment e = inputEnrolment();
		          C206_CaseStudy.addEnrolment(enrolmentList, e);
		         } else if (detailType == VIEW_ENROLMENT) {
		          // View all enrolments
		          C206_CaseStudy.viewAllEnrolment(enrolmentList);
		         }  else if (detailType == DELETE_ENROLMENT) {
		          // Delete an existing enrolment
		          String id = Helper.readString("Enter user id > ");
		          C206_CaseStudy.deleteEnrolment(enrolmentList, id);
		         } else if (detailType == QUIT_ENROLMENT) {
		          System.out.println("Thank you!");
		         } else {
		          System.out.println("Invalid option");
		         } 
		        }
			} else if (option == 6) {
				// Toby
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

	 // ================================= Option 1 Manage users =================================
	 
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

	 // ================================= Option 3 Manage students =================================

	public static Student inputStudent() {
		String id = Helper.readString("Enter student id > ");
		String name = Helper.readString("Enter name > ");
		int age = Helper.readInt("Enter age > ");

		Student s = new Student(id, name, age);
		return s;

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
		String id = Helper.readString("Enter user id > ");
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");

<<<<<<< HEAD
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

=======
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
	}
	
	 // ================================= Option 4 Manage fees =================================

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
		
		 // ================================= Option 5 Manage enrolments =================================
		 
		public static Enrolment inputEnrolment() {
			String id = Helper.readString("Enter Enrolment id > ");
			String name = Helper.readString("Enter name > ");
			String courseName = Helper.readString("Enter Course name > ");
			String enrolmentDate = Helper.readString("Enter Enrolment Date > ");

			Enrolment e= new Enrolment(id, name, courseName,enrolmentDate);
			return e;

		}

		public static void addEnrolment(ArrayList<Enrolment> enrolmentList, Enrolment e) {
			Enrolment detail;
			for(int i = 0; i < enrolmentList.size(); i++) {
				detail =enrolmentList.get(i);
				if (detail.getId().equalsIgnoreCase(e.getId()) )
					return;
			}
			if ((e.getId().isEmpty()) || (e.getName().isEmpty()) ) {
				System.out.println("User id or name cannot be empty");
				return;
			} else {
				enrolmentList.add(e);
				System.out.println("Enrolment added");
			}
		}

		public static String retrieveAllEnrolment(ArrayList<Enrolment> enrolmentList) {
			String output = "";

			for (int i = 0; i < enrolmentList.size(); i++) {
				output += String.format("%-20s %-20s %-20s %-20s\n", enrolmentList.get(i).getId(), 
						enrolmentList.get(i).getName(), enrolmentList.get(i).getCourseName(),enrolmentList.get(i).getEnrolmentDate());
			}
			return output;
		}

		public static void viewAllEnrolment(ArrayList<Enrolment> enrolmentList) {
			C206_CaseStudy.setHeader("ENROLMENT LIST");
			String output = String.format("%-20s %-20s %-20s %-20s\n", "ENROLMENT ID", "NAME",
					"COURSE NAME","ENROLMENT DATE");
			output += retrieveAllEnrolment(enrolmentList); 
			System.out.println(output);
		}

		public static void deleteEnrolment(ArrayList<Enrolment> enrolmentList, String id) {
			for(int i = 0; i < enrolmentList.size(); i++) {
				Enrolment detail = enrolmentList.get(i);
				if (detail.getId().equalsIgnoreCase(id)) {
					enrolmentList.remove(i);
					System.out.println("Enrolment deleted");
					return;
				}
			}
			System.out.println("Enrolment not found");
		}
	
		 // ================================= Option 6 Manage attendance =================================
	
	public static Attendance inputAttendance() {
		String id = Helper.readString("Enter user id > ");
		String name = Helper.readString("Enter name > ");
		String status = Helper.readString("Enter status > ");

		Attendance a = new Attendance(id, name, status);
		return a;
		
	}
	
	public static void addAttendance(ArrayList<Attendance> attendanceList, Attendance a) {
	    for (Attendance detail : attendanceList) {
	        if (detail.getId().equalsIgnoreCase(a.getId())) {
	            return;
	        }
	    }
	    if (a.getId().isEmpty() || a.getName().isEmpty()) {
	        System.out.println("User id or name cannot be empty");
	    } else {
	        attendanceList.add(a);
	        System.out.println("Attendance added");
	    }
	}

	
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
	    for (Attendance detail : attendanceList) {
	        if (detail.getId().equalsIgnoreCase(id)) {
	            attendanceList.remove(detail);
	            System.out.println("Attendance deleted");
	            return;
	        }
	    }
	    System.out.println("Attendance not found");
	}
	
} // end of class
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy
