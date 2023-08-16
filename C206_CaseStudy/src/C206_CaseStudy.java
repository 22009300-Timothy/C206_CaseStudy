import java.util.ArrayList;

public class C206_CaseStudy {
	
	// 22009300 Timothy
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_ADD = 1;
	private static final int OPTION_QUIT = 7;
	private static final int MAX_NUM_TRIES = 3;
	
	// 22045451 Li Hua
	private static final int DELETE_COURSE = 3;
	private static final int VIEW_COURSE = 2;
	private static final int ADD_COURSE = 1;
	
	// 22031945 Jian Hong
	private static final int DELETE_STUDENT = 3;
	private static final int VIEW_STUDENT = 2;
	private static final int ADD_STUDENT = 1;
	
	// 22024777 Ryan
	private static final int QUIT_FEE = 4;
	private static final int DELETE_FEE = 3;
	private static final int VIEW_FEE = 2;
	private static final int ADD_FEE = 1;
	
	// 22012942 Xavier
	private static final int DELETE_ENROLMENT = 3;
	private static final int VIEW_ENROLMENT = 2;
	private static final int ADD_ENROLMENT = 1;
	private static final int QUIT_ENROLMENT = 4;
	
	// 22012924 Toby
	private static final int QUIT_ATTENDANCE = 4;
	private static final int DELETE_ATTENDANCE = 3;
	private static final int VIEW_ATTENDANCE = 2;
	private static final int ADD_ATTENDANCE = 1;

	public static void main(String[] args) {

		// 22009300 Timothy
		ArrayList<User> userList = new ArrayList<>();
		
		// 22045451 Li Hua
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		// 22031945 Jian Hong
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		// 22024777 Ryan
		ArrayList<Fees> feesList = new ArrayList<Fees>();
		
		// 22012942 Xavier
		ArrayList<Enrolment> enrolmentList = new ArrayList<Enrolment>();	
		
		// 22012924 Toby
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();

		// 22009300 Timothy
		userList.add(new User("U01", "G V Timothy", "gvtimothy", "tempPassword1", "Administrator"));
		userList.add(new User("U02", "Toby Oh", "tobyoh", "tempPassword2", "Administrator"));
		
		// 22045451 Li Hua
		courseList.add(new Course("C01", "Software Development", "Serene Yong", "Monday 4pm to 6pm"));
		courseList.add(new Course("C02", "Web App Development", "Hew Ka Kian", "Wednesday 3pm to 5pm"));

		// 22031945 Jian Hong
		studentList.add(new Student("S01", "G V Timothy", 12, "Pass", "22009300@myrp.edu.sg"));
		studentList.add(new Student("S02", "Toby Oh", 14, "Pass", "22012924@myrp.edu.sg"));
		
		// 22024777 Ryan
		feesList.add(new Fees("F01", "G V Timothy", "Tuition", "Paid"));
		feesList.add(new Fees("F02", "Toby Oh", "Exam", "Pending"));
		
		// 22012942 Xavier
		enrolmentList.add(new Enrolment("E01", "G V Timothy", "Science","GCE O-Level","11/04/2023"));
		enrolmentList.add(new Enrolment("E02", "Toby Oh", "Mathematics","GCE N-Level","11/08/2023"));
		
		// 22012924 Toby
		attendanceList.add(new Attendance("A01", "G V Timothy", "Present"));
		attendanceList.add(new Attendance("A02", "Toby Oh", "Absent"));

		// 22009300 Timothy
		C206_CaseStudy.setHeader("WELCOME TO TUITION MANAGEMENT APP");
		User loggedIn = C206_CaseStudy.loginAccount(userList);
		
		if (loggedIn != null) {
			
			System.out.println("\nWelcome, " + loggedIn.getUsername() + "!");
			
			int option = 0;

			while (option != OPTION_QUIT) {

				C206_CaseStudy.menu();
				option = Helper.readInt("Enter an option > ");

				if (option == 1) {
					// 22009300 Timothy
					int detailType = 0;

					while (detailType != 4) {

						C206_CaseStudy.setHeader("USERS");
						C206_CaseStudy.setHeader("DETAIL TYPES");
						System.out.println("1. Add a new user");
						System.out.println("2. View all users");
						System.out.println("3. Delete an existing user");
						System.out.println("4. Quit");

						detailType = Helper.readInt("\nEnter option to select detail type > ");

						if (detailType == OPTION_ADD) {
							// Add a a new user
							User u = inputUser();
							C206_CaseStudy.addUser(userList, u);
						} else if (detailType == OPTION_VIEW) {
							// View all users
							C206_CaseStudy.viewAllUser(userList);
						} else if (detailType == OPTION_DELETE) {
							// Delete an existing user
							String id = Helper.readString("\nEnter user id > ");
							C206_CaseStudy.deleteUser(userList, id);
						} else if (detailType == 4) {
							System.out.println("\nThank you!");
						} else {
							System.out.println("\nInvalid option");
						}
					}
				} else if (option == 2) {
					// 22045451 Li Hua
					int detailType = 0;

					while (detailType != 4) {

						C206_CaseStudy.setHeader("COURSES");      
						C206_CaseStudy.setHeader("DETAIL DESCRIPTION");
						System.out.println("1. Add a new course");
						System.out.println("2. View all courses");
						System.out.println("3. Delete an existing course");
						System.out.println("4. Quit");

						detailType = Helper.readInt("\nEnter option to select detail type > ");



						if (detailType == ADD_COURSE) {
							// Add a a new course
							Course c = inputCourse();
							C206_CaseStudy.addCourse(courseList, c);
						} else if (detailType == VIEW_COURSE) {
							// View all courses
							C206_CaseStudy.viewAllCourse(courseList);
						}  else if (detailType == DELETE_COURSE) {
							// Delete an existing course
							String id = Helper.readString("\nEnter course id > ");
							C206_CaseStudy.deleteCourse(courseList, id);
						} else if (detailType == 4) {
							System.out.println("\nThank you!");
						} else {
							System.out.println("\nInvalid option");
						}  
					}
				} else if (option == 3) {
					// 22031945 Jian Hong
					int detailType = 0;

					while (detailType != 4) {

						C206_CaseStudy.setHeader("STUDENT");
						C206_CaseStudy.setHeader("DETAIL TYPES");
						System.out.println("1. Add a new student");
						System.out.println("2. View all student");
						System.out.println("3. Delete an existing student");
						System.out.println("4. Quit");

						detailType = Helper.readInt("\nEnter option to select detail type > ");

						if (detailType == ADD_STUDENT) {
							// Add a a new user
							Student s = inputStudent();
							C206_CaseStudy.addStudent(studentList, s);
						} else if (detailType == VIEW_STUDENT) {
							// View all users
							C206_CaseStudy.viewAllStudent(studentList);
						} else if (detailType == DELETE_STUDENT) {
							// Delete an existing user
							String id = Helper.readString("\nEnter student id > ");
							C206_CaseStudy.deleteStudent(studentList, id);
						} else if (detailType == 4) {
							System.out.println("\nThank you!");
						} else {
							System.out.println("\nInvalid option");
						}
					}
				} else if (option == 4) {
					// 22024777 Ryan
					int detailType = 0;

					while (detailType != 4) {

						C206_CaseStudy.setHeader("FEES");
						C206_CaseStudy.setHeader("DETAIL TYPES");
						System.out.println("1. Add a new Fee");
						System.out.println("2. View all Fees");
						System.out.println("3. Delete an existing Fee");
						System.out.println("4. Quit");

						detailType = Helper.readInt("\nEnter option to select detail type > ");

						if (detailType == ADD_FEE) {
							// Add a a new Fee
							Fees f = inputFees();
							C206_CaseStudy.addFees(feesList, f);
						} else if (detailType == VIEW_FEE) {
							// View all Fees
							C206_CaseStudy.viewAllFees(feesList);
						} else if (detailType == DELETE_FEE) {
							// Delete an existing Fee
							String id = Helper.readString("\nEnter fee id > ");
							C206_CaseStudy.deleteFees(feesList, id);
						} else if (detailType == QUIT_FEE) {
							System.out.println("\nThank you!");
						} else {
							System.out.println("\nInvalid option");
						}
					}
				} else if (option == 5) {
					// 22012942 Xavier	
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
							String id = Helper.readString("\nEnter enrolment id > ");
							C206_CaseStudy.deleteEnrolment(enrolmentList, id);
						} else if (detailType == QUIT_ENROLMENT) {
							System.out.println("\nThank you!");
						} else {
							System.out.println("\nInvalid option");
						} 
					}
				} else if (option == 6) {
					// 22012924 Toby
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
							String id = Helper.readString("Enter attendance id > ");
							C206_CaseStudy.deleteAttendance(attendanceList, id);
						} else if (detailType == QUIT_ATTENDANCE) {
							System.out.println("\nThank you!");
						} else {
							System.out.println("\nInvalid option");
						}	
					}
				} else if (option == OPTION_QUIT) {
					System.out.println("\nBye!");
				} else {
					System.out.println("\nInvalid option");
				}
			}
		}	
	}
	
	// 22009300 Timothy
	public static void menu() {
		C206_CaseStudy.setHeader("TUITION MANAGEMENT APP");
		System.out.println("1. Manage Users");
		System.out.println("2. Manage Courses");
		System.out.println("3. Manage Students");
		System.out.println("4. Manage Fees");
		System.out.println("5. Manage Enrolments");
		System.out.println("6. Manage Attendance");
		System.out.println("7. Quit");
		Helper.line(100, "-");
	}

	// 22009300 Timothy
	public static void setHeader(String header) {
		Helper.line(100, "-");
		System.out.println(header);
		Helper.line(100, "-");
	}
	
	// 22009300 Timothy
	private static User loginAccount(ArrayList<User> userList) {
		User login = null;
		int numTries = 0;
		while (login == null && numTries < MAX_NUM_TRIES) {
			String username = Helper.readString("\nEnter username > ");
			String password = Helper.readString("Enter password > ");
			for (User user : userList) {
				if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase("Administrator")) {
					login = user;
					break;
				}
			}
			numTries ++;
			
				if (login == null && numTries < MAX_NUM_TRIES) {
				System.out.println("\nIncorrect username or password");
			}
		}

		if (login == null && numTries == MAX_NUM_TRIES) {
			System.out.println("\nYou have entered an incorrect username or password too many times!\n\nYour account has been temporarily locked.");
		}
		return login;
	}
	
	// ================================= Option 1 Manage users =================================
	
	// 22009300 Timothy
	public static User inputUser() {
		String id = Helper.readString("\nEnter user id > ");
		String name = Helper.readString("Enter name > ");
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		String role = Helper.readString("Enter role > ");

		User u = new User(id, name, username, password, role);
		return u;
	}
		
	// 22009300 Timothy
	public static void addUser(ArrayList<User> userList, User u) {
		for(int i = 0; i < userList.size(); i++) {
			String id = userList.get(i).getId();
			if (u.getId().equalsIgnoreCase(id)) {
				return;
			}
		}
			if ((u.getId().isEmpty()) || (u.getName().isEmpty())) {
				System.out.println("\nUser id or name cannot be empty");
				return;				
			} else {
				userList.add(u);
				System.out.println("\nUser added");
			}
	}
	
	// 22009300 Timothy
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";
		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-10s %-20s %-15s %-20s %-10s\n", userList.get(i).getId(), userList.get(i).getName(), userList.get(i).getUsername(), userList.get(i).getPassword(), userList.get(i).getRole());
		}
		return output;
	}
	
	// 22009300 Timothy
	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-20s %-15s %-20s %-10s\n", "USER ID", "NAME", "USERNAME", "PASSWORD", "ROLE");
		output += retrieveAllUser(userList); 
		System.out.println(output);
	}
	
	// 22009300 Timothy
	public static void deleteUser(ArrayList<User> userList, String id) {
		for(int i = 0; i < userList.size(); i++) {
			String id2 = userList.get(i).getId();
			if (id.equalsIgnoreCase(id2)) {
				userList.remove(i);
				System.out.println("\nUser deleted");
				return;
			}
		}
		System.out.println("\nUser not found");
	}
	
	// ================================= Option 2 Manage courses =================================
	
	// 22045451 Li Hua
	public static Course inputCourse() {
		String id = Helper.readString("\nEnter course id > ");
		String name = Helper.readString("Enter name > ");
		String instructor = Helper.readString("Enter instructor name > ");
		String schedule = Helper.readString("Enter schedule > ");

		Course c= new Course(id, name, instructor, schedule);
		return c;  
	}
	  
	// 22045451 Li Hua
	public static void addCourse(ArrayList<Course> courseList, Course c) {
		Course detail;
		for(int i = 0; i < courseList.size(); i++) {
			detail = courseList.get(i);
			if (detail.getId().equalsIgnoreCase(c.getId()) )
				return;
		}
		if ((c.getId().isEmpty()) || (c.getName().isEmpty()) ) {
			System.out.println("\nCourse details cannot be empty");
			return;
		} else {
			courseList.add(c);
			System.out.println("\nCourse added");
		}
	}

	// 22045451 Li Hua
	  public static String retrieveAllCourse(ArrayList<Course> courseList) {
	      String format = "%-12s %-25s %-20s %-20s\n";
	      String output = "";

	      for (Course course : courseList) {
	          String id = course.getId();
	          String name = course.getName();
	          String instructor = course.getInstructor();
	          String schedule = course.getSchedule();

	          output += String.format(format, id, name, instructor, schedule);
	      }

	      return output;
	  }
	  
	// 22045451 Li Hua
	public static void viewAllCourse(ArrayList<Course> courseList) {
		C206_CaseStudy.setHeader("COURSE LIST");
		String output = String.format("%-12s %-25s %-20s %-20s\n", "COURSE ID", "NAME",
				"INSTRUCTOR NAME", "SCHEDULE");
		output += retrieveAllCourse(courseList);  
		System.out.println(output);
	}
	  
	// 22045451 Li Hua
	public static void deleteCourse(ArrayList<Course> courseList, String id) {
		for(int i = 0; i < courseList.size(); i++) {
			Course detail = courseList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				courseList.remove(i);
				System.out.println("\nCourse deleted");
				return;
			}
		}
		System.out.println("\nCourse not found");
	}
	
	// ================================= Option 3 Manage students =================================
	
	// 22031945 Jian Hong
	public static Student inputStudent() {
		  String id = Helper.readString("\nEnter student id > ");
		  String name = Helper.readString("Enter name > ");
		  int age = Helper.readInt("Enter age > ");
		  String grade = Helper.readString("Enter grade > ");
		  String email = Helper.readString("Enter email address > ");

		  Student s = new Student(id, name, age, grade, email);
		  return s;
	}

	// 22031945 Jian Hong
	public static void addStudent(ArrayList<Student> studentList, Student s) {
		Student detail;
		for (int i = 0; i < studentList.size(); i++) {
			detail = studentList.get(i);
			if (detail.getId().equalsIgnoreCase(s.getId()))
				return;
		}
		if ((s.getId().isEmpty()) || (s.getName().isEmpty())) {
			System.out.println("\nStudent id or name cannot be empty");
			return;
		} else {
			studentList.add(s);
			System.out.println("\nStudent added");
		}
	}

	// 22031945 Jian Hong
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
	    String output = "";

	    for (int i = 0; i < studentList.size(); i++) {
	      String id = studentList.get(i).getId();
	      String name = studentList.get(i).getName();
	      int age = studentList.get(i).getAge();
	      String grade = studentList.get(i).getGrade();
	      String email = studentList.get(i).getEmail();
	      output += String.format("%-10s %-20s %-10d %-10s %-20s\n", id, name,
	          age, grade, email);
	    }
	    return output;
	  }

	// 22031945 Jian Hong
	public static void viewAllStudent(ArrayList<Student> studentList) {
	    C206_CaseStudy.setHeader("STUDENT LIST");
	    String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "STUDENT ID", "NAME", "AGE", "GRADE", "EMAIL");
	    output += retrieveAllStudent(studentList);
	    System.out.println(output);
	  }

	// 22031945 Jian Hong
	public static void deleteStudent(ArrayList<Student> studentList, String id) {
		for (int i = 0; i < studentList.size(); i++) {
			Student detail = studentList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				studentList.remove(i);
				System.out.println("\nStudent deleted");
				return;
			}
		}
		System.out.println("\nStudent not found");
	}
	
	// ================================= Option 4 Manage fees =================================
	
	// 22024777 Ryan
	public static Fees inputFees() {
		String id = Helper.readString("\nEnter fee id > ");
		String name = Helper.readString("Enter name > ");
		String FeeType = Helper.readString("Enter Fee Type > ");
		String status = Helper.readString("Enter status > ");

		Fees f = new Fees(id, name, FeeType, status);
		return f;
	}

	// 22024777 Ryan
	public static void addFees(ArrayList<Fees> feesList, Fees f) {
		for (Fees detail : feesList) {
			if (detail.getId().equalsIgnoreCase(f.getId())) {
				return;
			}
		}

		if (f.getId().isEmpty() || f.getName().isEmpty()) {
			System.out.println("\nFees id or FeeType cannot be empty");
		} else {
			feesList.add(f);
			System.out.println("\nFee added");
		}
	}

	// 22024777 Ryan
	public static String retrieveAllFees(ArrayList<Fees> feesList) {
		StringBuilder output = new StringBuilder();

		for (Fees fee : feesList) {
			output.append(String.format("%-10s %-20s %-20s %-20s\n", fee.getId(), fee.getName(), fee.getFeeType(),
					fee.getStatus()));
		}
		return output.toString();
	}

	// 22024777 Ryan
	public static void viewAllFees(ArrayList<Fees> feesList) {
		C206_CaseStudy.setHeader("FEES LIST");
		String output = String.format("%-10s %-20s %-20s %-20s\n", "FEES ID", "NAME", "FEE TYPE", "STATUS");
		output += retrieveAllFees(feesList);
		System.out.println(output);
	}

	// 22024777 Ryan
	public static void deleteFees(ArrayList<Fees> feesList, String id) {
		for (Fees detail : feesList) {
			if (detail.getId().equalsIgnoreCase(id)) {
				feesList.remove(detail);
				System.out.println("\nFee deleted");
				return;
			}
		}
		System.out.println("\nFee ID not found");
	}
	
	// ================================= Option 5 Manage enrolments =================================
	
	// 22012942 Xavier
	public static Enrolment inputEnrolment() {
		String id = Helper.readString("\nEnter enrolment id > ");
		String name = Helper.readString("Enter name > ");
		String courseName = Helper.readString("Enter Course name > ");    
		String prerequisite = Helper.readString("Enter your level of study > ");
		String enrolmentDate = Helper.readString("Enter Enrolment Date > ");

		Enrolment e= new Enrolment(id, name, courseName,prerequisite,enrolmentDate);
		return e;

	}

	// 22012942 Xavier
	public static void addEnrolment(ArrayList<Enrolment> enrolmentList, Enrolment e) {
		Enrolment detail;
		for(Enrolment e1: enrolmentList) {
			detail =e1;
			if (detail.getId().equalsIgnoreCase(e.getId()) )
				return;
		}
		if ((e.getId().isEmpty()) || (e.getName().isEmpty()) ) {
			System.out.println("\nEnrolment id or name cannot be empty");
			return;
		} else {
			enrolmentList.add(e);
			System.out.println("\nEnrolment added");
		}
	}

	// 22012942 Xavier
	public static String retrieveAllEnrolment(ArrayList<Enrolment> enrolmentList) {
		String output = "";

		for (Enrolment e2: enrolmentList) {
			String enrolment_id = e2.getId();
			String student_name = e2.getName();
			String course_name = e2.getCourseName();
			String prerequisite = e2.getPrerequisite();
			String enrolmentdate = e2.getEnrolmentDate();
			output += String.format("%-20s %-20s %-20s %-20s %-20s\n", enrolment_id, 
					student_name, course_name,prerequisite,enrolmentdate);
		}
		return output;
	}

	// 22012942 Xavier
	public static void viewAllEnrolment(ArrayList<Enrolment> enrolmentList) {
		C206_CaseStudy.setHeader("ENROLMENT LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "ID", "NAME",
				"COURSE NAME","PREREQUISITE","ENROLMENT DATE");
		output += retrieveAllEnrolment(enrolmentList);
		System.out.println(output);
	}

	// 22012942 Xavier
	public static void deleteEnrolment(ArrayList<Enrolment> enrolmentList, String id) {
		for(int i = 0; i < enrolmentList.size(); i++) {
			Enrolment detail = enrolmentList.get(i);
			if (detail.getId().equalsIgnoreCase(id)) {
				enrolmentList.remove(i);
				System.out.println("\nEnrolment deleted");
				return;
			}
		}
		System.out.println("\nEnrolment not found");
	}
	
	// ================================= Option 6 Manage attendance =================================
	
	// 22012924 Toby
	public static Attendance inputAttendance() {
		String id = Helper.readString("\nEnter attendance id > ");
		String name = Helper.readString("Enter name > ");
		String status = Helper.readString("Enter status > ");

		Attendance a = new Attendance(id, name, status);
		return a;
		
	}
	
	// 22012924 Toby
	public static void addAttendance(ArrayList<Attendance> attendanceList, Attendance a) {
	    for (Attendance detail : attendanceList) {
	        if (detail.getId().equalsIgnoreCase(a.getId())) {
	            return;
	        }
	    }
	    if (a.getId().isEmpty() || a.getName().isEmpty()) {
	        System.out.println("\nAttendance id or name cannot be empty");
	    } else {
	        attendanceList.add(a);
	        System.out.println("\nAttendance added");
	    }
	}

	// 22012924 Toby
	public static String retrieveAllAttendance(ArrayList<Attendance> attendanceList) {
		String output = "";

		for (int i = 0; i < attendanceList.size(); i++) {
			output += String.format("%-10s %-20s %-20s\n", attendanceList.get(i).getId(), 
					attendanceList.get(i).getName(), attendanceList.get(i).getStatus());
		}
		return output;
	}
	
	// 22012924 Toby
	public static void viewAllAttendance(ArrayList<Attendance> attendanceList) {
		C206_CaseStudy.setHeader("ATTENDANCE LIST");
		String output = String.format("%-10s %-20s %-20s\n", "ATTENDANCE ID", "NAME",
				"ATTENDANCE");
		 output += retrieveAllAttendance(attendanceList);	
		System.out.println(output);
	}
	
	// 22012924 Toby
	public static void deleteAttendance(ArrayList<Attendance> attendanceList, String id) {
	    for (Attendance detail : attendanceList) {
	        if (detail.getId().equalsIgnoreCase(id)) {
	            attendanceList.remove(detail);
	            System.out.println("\nAttendance deleted");
	            return;
	        }
	    }
	    System.out.println("\nAttendance not found");
	}	 
	
} // end of class