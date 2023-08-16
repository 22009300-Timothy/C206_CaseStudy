import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	// Prepare test data
	
	// 22009300 Timothy
	private User u01;
	private User u02;
	private User u03;
	
	// 22045451 Li Hua
	private Course c01;
	private Course c02;
	private Course c03;
	
	// 22031945 Jian Hong
	private Student s01;
	private Student s02;
	private Student s03;

	// 22024777 Ryan
	private Fees f01;
	private Fees f02;
	private Fees f03;

	// 22012942 Xavier	
	private Enrolment e01;
	private Enrolment e02;
	private Enrolment e03;

	// 22012924 Toby
	private Attendance a01;
	private Attendance a02;
	private Attendance a03;
	
	// 22009300 Timothy
	private ArrayList<User> userList;
	
	// 22045451 Li Hua
	private ArrayList<Course> courseList;
	
	// 22031945 Jian Hong
	private ArrayList<Student> studentList;
	
	// 22024777 Ryan
	private ArrayList<Fees> feesList;
	
	// 22012942 Xavier	
	private ArrayList<Enrolment> enrolmentList;
	
	// 22012924 Toby
	private ArrayList<Attendance> attendanceList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// Prepare test data
		
		// 22009300 Timothy
		u01 = new User("U01", "G V Timothy", "gvtimothy", "password1", "Administrator");
		u02 = new User("U02", "Toby Oh", "tobyoh", "password2","Administrator");
		u03 = new User("U03", "Ryan Loh", "ryanloh", "password3", "Administrator");
		
		// 22045451 Li Hua
		c01 = new Course("C01", "Software Development", "Serene Yong", "Monday 4pm to 6pm");
		c02 = new Course("C02", "Web App Development", "Hew Ka Kian", "Wednesday 3pm to 5pm");
		c03 = new Course("C03", "Java", "Desmond Lee", "Friday 12pm to 2pm");
		
		// 22031945 Jian Hong
		s01 = new Student("S01", "G V Timothy", 12, "Pass", "22009300@myrp.edu.sg");
	    s02 = new Student("S02", "Toby Oh", 14, "Pass", "22012924@myrp.edu.sg");
	    s03 = new Student("S03", "Ryan Loh", 17, "Fail", "22024777@myrp.edu.sg");

	    // 22024777 Ryan
	    f01 = new Fees("F01", "G V Timothy", "Tuition", "Paid");
	    f02 = new Fees("F02", "Toby Oh", "Exam", "Pending");
	    f03 = new Fees("F03", "Ryan Loh", "Tuition", "Paid");

	    // 22012942 Xavier	
	    e01 = new Enrolment("E01", "G V Timothy","Science","GCE O-Level","11/04/2023");
	    e02 = new Enrolment("E02", "Toby Oh","Math","GCE N-Level","11/08/2023");
	    e03 = new Enrolment("E03", "Xavier","English","GCE O-Level","11/02/2023");

	    // 22012924 Toby
		a01 = new Attendance("A01", "Toby Oh", "Absent");
		a02 = new Attendance("A02", "G V Timothy", "Present");
		a03 = new Attendance("A03", "Xavier Quek", "Absent");

		// 22009300 Timothy
		userList= new ArrayList<User>();
		
		// 22045451 Li Hua
		courseList = new ArrayList<Course>();
		
		// 22031945 Jian Hong
		studentList = new ArrayList<Student>();
		
		// 22024777 Ryan
		feesList = new ArrayList<Fees>();
		
		// 22012942 Xavier	
		enrolmentList = new ArrayList<Enrolment>();
		
		// 22012924 Toby
		attendanceList = new ArrayList<Attendance>();	
	}
	
	// 22009300 Timothy
	@Test
	public void testAddUser() {
		// User list is not null and it is empty
		assertNotNull("Test if there is a valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		// Given an empty list, after adding 1 user, the size of the list is 1
		C206_CaseStudy.addUser(userList, u01);
		assertEquals("Test that the User arraylist size is 1.", 1, userList.size());

		// Add a user
		C206_CaseStudy.addUser(userList, u02);
		assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());
		//The user just added is as same as the last item in the list
		assertSame("Test that the User is added to the end of the list.", u02, userList.get(1));

		// Add a user that already exists in the list
		C206_CaseStudy.addUser(userList, u02);
		assertEquals("Test that the User arraylist size is unchanged.", 2, userList.size());

		// Add a user that has missing detail
		User u_missing = new User("U03", "", "ryanloh", "password3", "Administrator");
		C206_CaseStudy.addUser(userList, u_missing);
		assertEquals("Test that the User arraylist size is unchanged.", 2, userList.size());
	}
	
	// 22009300 Timothy
	@Test
	public void testRetrieveAllUser() {
		// Test Case 1
		// Test if User list is not null and empty
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		// Attempt to retrieve the Users
		String allUser= C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUser);

		//Test Case 2
		C206_CaseStudy.addUser(userList, u01);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 1.", 1, userList.size());
		// Attempt to retrieve the User
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-20s %-15s %-20s %-10s\n","U01", "G V Timothy", "gvtimothy", "password1", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);

		//Test Case 3
		C206_CaseStudy.addUser(userList, u02);
		C206_CaseStudy.addUser(userList, u03);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 3.", 3, userList.size());
		// Attempt to retrieve the User
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-20s %-15s %-20s %-10s\n","U01", "G V Timothy", "gvtimothy", "password1", "Administrator");
		testOutput += String.format("%-10s %-20s %-15s %-20s %-10s\n","U02", "Toby Oh", "tobyoh", "password2", "Administrator");
		testOutput += String.format("%-10s %-20s %-15s %-20s %-10s\n","U03", "Ryan Loh", "ryanloh", "password3", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);	
	}
	
	// 22009300 Timothy
	@Test
	public void testDeleteUser() {
		// User list is not null and it is not empty
		C206_CaseStudy.addUser(userList, u01);
		C206_CaseStudy.addUser(userList, u02);
		C206_CaseStudy.addUser(userList, u03);
		assertNotNull("Test if there is a valid User arraylist to delete", userList);
		assertEquals("Test that the User arraylist is not empty.", 3, userList.size());

		// Delete a user
		C206_CaseStudy.deleteUser(userList, "U02");
		assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());

		// Delete the last user in the list
		C206_CaseStudy.deleteUser(userList, "U03");
		assertEquals("Test that the User arraylist size is now 1.", 1, userList.size());

		// Delete a user that does not exist in the list
		C206_CaseStudy.deleteUser(userList, "U04");
		assertEquals("Test that the User arraylist size is unchanged.", 1, userList.size());
	}
	
	// 22045451 Li Hua
	@Test
	public void testAddCourse() {
		// Course list is not null and it is empty
		assertNotNull("Test if there is a valid Course arraylist to add to", courseList);
		assertEquals("Test that the Course arraylist is empty.", 0, courseList.size());
		// Given an empty list, after adding 1 course, the size of the list is 1
		C206_CaseStudy.addCourse(courseList, c01);
		assertEquals("Test that the Course arraylist size is 1.", 1, courseList.size());

		// Add a Course
		C206_CaseStudy.addCourse(courseList, c02);
		assertEquals("Test that the Course arraylist size is now 2.", 2, courseList.size());
		//The Course just added is as same as the last item in the list
		assertSame("Test that the Course is added to the end of the list.", c02, courseList.get(1));

		// Add a Course that already exists in the list
		C206_CaseStudy.addCourse(courseList, c02);
		assertEquals("Test that the Course arraylist size is unchanged.", 2, courseList.size());

		// Add a Course that has missing detail
		Course c_missing = new Course("C03", "", "Desmond Lee", "Friday 12pm to 2pm");
		C206_CaseStudy.addCourse(courseList, c_missing);
		assertEquals("Test that the Course arraylist size is unchanged.", 2, courseList.size());
	}

	// 22045451 Li Hua
	@Test
	public void testRetrieveAllCourse() {
		// Test Case 1
		// Test if Course list is not null and empty
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);
		assertEquals("Test that the Course arraylist is empty.", 0, courseList.size());
		// Attempt to retrieve the Courses
		String allCourse= C206_CaseStudy.retrieveAllCourse(courseList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allCourse);

		//Test Case 2
		C206_CaseStudy.addCourse(courseList, c01);
		// Test that the list is not empty
		assertEquals("Test that Course arraylist size is 1.", 1, courseList.size());
		// Attempt to retrieve the Course
		allCourse= C206_CaseStudy.retrieveAllCourse(courseList);
		testOutput = String.format("%-12s %-25s %-20s %-20s\n","C01", "Software Development", "Serene Yong", "Monday 4pm to 6pm");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCourse);

		//Test Case 3
		C206_CaseStudy.addCourse(courseList, c02);
		C206_CaseStudy.addCourse(courseList, c03);
		// Test that the list is not empty
		assertEquals("Test that Course arraylist size is 3.", 3, courseList.size());
		// Attempt to retrieve the Course
		allCourse= C206_CaseStudy.retrieveAllCourse(courseList);	    
		testOutput = String.format("%-12s %-25s %-20s %-20s\n","C01", "Software Development", "Serene Yong", "Monday 4pm to 6pm");
		testOutput += String.format("%-12s %-25s %-20s %-20s\n","C02", "Web App Development", "Hew Ka Kian", "Wednesday 3pm to 5pm");
		testOutput += String.format("%-12s %-25s %-20s %-20s\n","C03", "Java", "Desmond Lee", "Friday 12pm to 2pm");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCourse);
	}
	
	// 22045451 Li Hua
	@Test
	public void testDeleteCourse() {
		// Course list is not null and it is not empty
		C206_CaseStudy.addCourse(courseList, c01);
		C206_CaseStudy.addCourse(courseList, c02);
		C206_CaseStudy.addCourse(courseList, c03);
		assertNotNull("Test if there is a valid Course arraylist to delete", courseList);
		assertEquals("Test that the Course arraylist is not empty.", 3, courseList.size());

		// Delete a course
		C206_CaseStudy.deleteCourse(courseList, "C02");
		assertEquals("Test that the Course arraylist size is now 2.", 2, courseList.size());

		// Delete the last course in the list
		C206_CaseStudy.deleteCourse(courseList, "C03");
		assertEquals("Test that the Course arraylist size is now 1.", 1, courseList.size());

		// Delete a course that does not exist in the list
		C206_CaseStudy.deleteCourse(courseList, "C04");
		assertEquals("Test that the Course arraylist size is unchanged.", 1, courseList.size());
	}
	
	// 22031945 Jian Hong
	@Test
	public void testAddStudent() {
		// Student list is not null and it is empty
		assertNotNull("Test if there is a valid Student arraylist to add to", studentList);
		assertEquals("Test that the Student arraylist is empty.", 0, studentList.size());
		// Given an empty list, after adding 1 Student, the size of the list is 1
		C206_CaseStudy.addStudent(studentList, s01);
		assertEquals("Test that the Student arraylist size is 1.", 1, studentList.size());

		// Add a Student
		C206_CaseStudy.addStudent(studentList, s02);
		assertEquals("Test that the Student arraylist size is now 2.", 2, studentList.size());
		//The Student just added is as same as the last item in the list
		assertSame("Test that the Student is added to the end of the list.", s02, studentList.get(1));

		// Add a Student that already exists in the list
		C206_CaseStudy.addStudent(studentList, s02);
		assertEquals("Test that the Student arraylist size is unchanged.", 2, studentList.size());

		// Add a Student that has missing detail
		Student s_missing = new Student("S03", "", 17, "Fail", "22024777@myrp.edu.sg");
		C206_CaseStudy.addStudent(studentList, s_missing);
		assertEquals("Test that the Student arraylist size is unchanged.", 2, studentList.size());
	}
	
	// 22031945 Jian Hong
	public void testRetrieveAllStudent() {
		// Test Case 1
		// Test if Student list is not null and empty
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
		assertEquals("Test that the Student arraylist is empty.", 0, studentList.size());
		// Attempt to retrieve the Students
		String allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allStudent);

		//Test Case 2
		C206_CaseStudy.addStudent(studentList, s01);
		// Test that the list is not empty
		assertEquals("Test that Student arraylist size is 1.", 1, studentList.size());
		// Attempt to retrieve the Student
		allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-10s %-20s %-10d %-10s %-20s\n","S01", "G V Timothy", 12, "Pass", "22009300@myrp.edu.sg");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allStudent);

		//Test Case 3
		C206_CaseStudy.addStudent(studentList, s02);
		C206_CaseStudy.addStudent(studentList, s03);
		// Test that the list is not empty
		assertEquals("Test that Student arraylist size is 3.", 3, studentList.size());
		// Attempt to retrieve the Student
		allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-10s %-20s %-10d %-10s %-20s\n","S01", "G V Timothy", 12, "Pass", "22009300@myrp.edu.sg");
		testOutput += String.format("%-10s %-20s %-10d %-10s %-20s\n","S02", "Toby Oh", 14, "Pass", "22012924@myrp.edu.sg");
		testOutput += String.format("%-10s %-20s %-10d %-10s %-20s\n","S03", "Ryan Loh", 17, "Fail", "22024777@myrp.edu.sg");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allStudent);
	}
	
	// 22031945 Jian Hong
	@Test
	public void testDeleteStudent() {
		// Student list is not null and it is not empty
		C206_CaseStudy.addStudent(studentList, s01);
		C206_CaseStudy.addStudent(studentList, s02);
		C206_CaseStudy.addStudent(studentList, s03);
		assertNotNull("Test if there is a valid Student arraylist to delete", studentList);
		assertEquals("Test that the Student arraylist is not empty.", 3, studentList.size());

		// Delete a Student
		C206_CaseStudy.deleteStudent(studentList, "S02");
		assertEquals("Test that the Student arraylist size is now 2.", 2, studentList.size());

		// Delete the last Student in the list
		C206_CaseStudy.deleteStudent(studentList, "S03");
		assertEquals("Test that the Student arraylist size is now 1.", 1, studentList.size());

		// Delete a Student that does not exist in the list
		C206_CaseStudy.deleteStudent(studentList, "S04");
		assertEquals("Test that the Student arraylist size is unchanged.", 1, studentList.size());
	}
	
	// 22024777 Ryan
	@Test
	public void testAddFees() {
		// Fees list is not null and it is empty
		assertNotNull("Test if there is a valid Fee arraylist to add to", feesList);
		assertEquals("Test that the Fees arraylist is empty.", 0, feesList.size());
		// Given an empty list, after adding 1 fee, the size of the list is 1
		C206_CaseStudy.addFees(feesList, f01);
		assertEquals("Test that the Fees arraylist size is 1.", 1, feesList.size());

		// Add a Fee
		C206_CaseStudy.addFees(feesList, f02);
		assertEquals("Test that the Fees arraylist size is now 2.", 2, feesList.size());
		//The Fee just added is as same as the last item in the list
		assertSame("Test that the Fee is added to the end of the list.", f02, feesList.get(1));

		// Add a fee that already exists in the list
		C206_CaseStudy.addFees(feesList, f02);
		assertEquals("Test that the Fees arraylist size is unchanged.", 2, feesList.size());

		// Add a fee that has missing detail
		Fees f_missing = new Fees("F03", "", "Exam", "Paid");
		C206_CaseStudy.addFees(feesList, f_missing);
		assertEquals("Test that the Fees arraylist size is unchanged.", 2, feesList.size());
	}

	// 22024777 Ryan
	@Test
	public void testRetrieveAllFees() {
		// Test Case 1
		// Test if Fees list is not null and empty
		assertNotNull("Test if there is valid Fees arraylist to add to", feesList);
		assertEquals("Test that the Fees arraylist is empty.", 0, feesList.size());
		// Attempt to retrieve the Fees
		String allFees= C206_CaseStudy.retrieveAllFees(feesList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allFees);

		//Test Case 2
		C206_CaseStudy.addFees(feesList, f01);
		// Test that the list is not empty
		assertEquals("Test that Fees arraylist size is 1.", 1, feesList.size());
		// Attempt to retrieve the Fees
		allFees= C206_CaseStudy.retrieveAllFees(feesList);
		testOutput = String.format("%-10s %-20s %-20s %-20s\n","F01", "G V Timothy", "Tuition", "Paid");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allFees);

		//Test Case 3
		C206_CaseStudy.addFees(feesList, f02);
		C206_CaseStudy.addFees(feesList, f03);
		// Test that the list is not empty
		assertEquals("Test that Fees arraylist size is 3.", 3, feesList.size());
		// Attempt to retrieve the Fees
		allFees= C206_CaseStudy.retrieveAllFees(feesList);
		testOutput = String.format("%-10s %-20s %-20s %-20s\n","F01", "G V Timothy", "Tuition", "Paid");
		testOutput += String.format("%-10s %-20s %-20s %-20s\n","F02", "Toby Oh", "Exam", "Pending");
		testOutput += String.format("%-10s %-20s %-20s %-20s\n","F03", "Ryan Loh", "Tuition", "Paid");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allFees);
	}

	// 22024777 Ryan
	@Test
	public void testDeleteFees() {
		// Fees list is not null and it is not empty
		C206_CaseStudy.addFees(feesList, f01);
		C206_CaseStudy.addFees(feesList, f02);
		C206_CaseStudy.addFees(feesList, f03);
		assertNotNull("Test if there is a valid Fees arraylist to delete", feesList);
		assertEquals("Test that the Fees arraylist is not empty.", 3, feesList.size());

		// Delete a Fee
		C206_CaseStudy.deleteFees(feesList, "F02");
		assertEquals("Test that the Fees arraylist size is now 2.", 2, feesList.size());

		// Delete the last Fee in the list
		C206_CaseStudy.deleteFees(feesList, "F03");
		assertEquals("Test that the Fees arraylist size is now 1.", 1, feesList.size());

		// Delete a Fee that does not exist in the list
		C206_CaseStudy.deleteFees(feesList, "F04");
		assertEquals("Test that the Fees arraylist size is unchanged.", 1, feesList.size());
	}
	
	// 22012942 Xavier	
	@Test
	public void testAddEnrolment() {
		// Enrolment list is not null and it is empty
		assertNotNull("Test if there is a valid Enrolment arraylist to add to", enrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, enrolmentList.size());
		// Given an empty list, after adding 1 enrolment, the size of the list is 1
		C206_CaseStudy.addEnrolment(enrolmentList, e01);
		assertEquals("Test that the Enrolment arraylist size is 1.", 1, enrolmentList.size());

		// Add a enrolment
		C206_CaseStudy.addEnrolment(enrolmentList, e02);
		assertEquals("Test that the Enrolment arraylist size is now 2.", 2, enrolmentList.size());
		//The enrolment just added is as same as the last item in the list
		assertSame("Test that the Enrolment is added to the end of the list.", e02, enrolmentList.get(1));

		// Add an enrolment that already exists in the list
		C206_CaseStudy.addEnrolment(enrolmentList, e02);
		assertEquals("Test that the Enrolment arraylist size is unchanged.", 2, enrolmentList.size());

		// Add an enrolment that has missing detail
		Enrolment e_missing = new Enrolment("E03","", "English","GCE O-Level","11/02/2023");
		C206_CaseStudy.addEnrolment(enrolmentList, e_missing);
		assertEquals("Test that the Enrolment arraylist size is unchanged.", 2, enrolmentList.size());
	}

	// 22012942 Xavier	
	@Test
	public void testRetrieveAllEnrolment() {
		// Test Case 1
		// Test if Enrolment list is not null and empty
		assertNotNull("Test if there is valid Enrolment arraylist to add to", enrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, enrolmentList.size());
		// Attempt to retrieve the Enrolments
		String allEnrolment= C206_CaseStudy.retrieveAllEnrolment(enrolmentList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allEnrolment);

		//Test Case 2
		C206_CaseStudy.addEnrolment(enrolmentList, e01);
		// Test that the list is not empty
		assertEquals("Test that Enrolment arraylist size is 1.", 1, enrolmentList.size());
		// Attempt to retrieve the enrolment
		allEnrolment= C206_CaseStudy.retrieveAllEnrolment(enrolmentList);
		testOutput = String.format("%-20s %-20s %-20s %-20s %-20s\n","E01", "G V Timothy", "Science","GCE O-Level","11/04/2023");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allEnrolment);

		//Test Case 3
		C206_CaseStudy.addEnrolment(enrolmentList, e02);
		C206_CaseStudy.addEnrolment(enrolmentList, e03);
		// Test that the list is not empty
		assertEquals("Test that Enrolment arraylist size is 3.", 3, enrolmentList.size());
		// Attempt to retrieve the Enrolment
		allEnrolment= C206_CaseStudy.retrieveAllEnrolment(enrolmentList);
		testOutput = String.format("%-20s %-20s %-20s %-20s %-20s\n","E01", "G V Timothy", "Science","GCE O-Level","11/04/2023");
		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s\n","E02", "Toby Oh", "Math","GCE N-Level","11/08/2023");
		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s\n","E03", "Xavier", "English","GCE O-Level","11/02/2023");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allEnrolment);
	}
	
	// 22012942 Xavier	
	@Test
	  public void testDeleteEnrolment() {
	    // Enrolment list is not null and it is not empty
	    C206_CaseStudy.addEnrolment(enrolmentList, e01);
	    C206_CaseStudy.addEnrolment(enrolmentList, e02);
	    C206_CaseStudy.addEnrolment(enrolmentList, e03);
	    assertNotNull("Test if there is a valid Enrolment arraylist to delete", enrolmentList);
	    assertEquals("Test that the Enrolment arraylist is not empty.", 3, enrolmentList.size());

	    // Delete a enrolment
	    C206_CaseStudy.deleteEnrolment(enrolmentList, "E02");
	    assertEquals("Test that the Enrolment arraylist size is now 2.", 2, enrolmentList.size());

	    // Delete the last enrolment in the list
	    C206_CaseStudy.deleteEnrolment(enrolmentList, "E03");
	    assertEquals("Test that the Enrolment arraylist size is now 1.", 1, enrolmentList.size());

	    // Delete a enrolment that does not exist in the list
	    C206_CaseStudy.deleteEnrolment(enrolmentList, "E04");
	    assertEquals("Test that the Enrolment arraylist size is unchanged.", 1, enrolmentList.size());
	  }
	
	// 22012924 Toby
	@Test
	public void testAddAttendance() {
		// Attendance list is not null and it is empty
		assertNotNull("Test if there is a valid Attendance arraylist to add to", attendanceList);
		assertEquals("Test that the Attendance arraylist is empty.", 0, attendanceList.size());
		// Given an empty list, after adding 1 attendance, the size of the list is 1
		C206_CaseStudy.addAttendance(attendanceList, a01);
		assertEquals("Test that the Attendance arraylist size is 1.", 1, attendanceList.size());

		// Add a attendance
		C206_CaseStudy.addAttendance(attendanceList, a02);
		assertEquals("Test that the Attendance arraylist size is now 2.", 2, attendanceList.size());
		//The attendance just added is as same as the last item in the list
		assertSame("Test that the Attendance is added to the end of the list.", a02, attendanceList.get(1));

		// Add a attendance that already exists in the list
		C206_CaseStudy.addAttendance(attendanceList, a02);
		assertEquals("Test that the Attendance arraylist size is unchanged.", 2, attendanceList.size());

		// Add a attendance that has missing detail
		Attendance a_missing = new Attendance("A03", "", "Absent");
		C206_CaseStudy.addAttendance(attendanceList, a_missing);
		assertEquals("Test that the Attendance arraylist size is unchanged.", 2, attendanceList.size());
	}

	// 22012924 Toby
	@Test
	public void testRetrieveAllAttendance() {
		// Test Case 1
		// Test if Attendance list is not null and empty
		assertNotNull("Test if there is valid User arraylist to add to", attendanceList);
		assertEquals("Test that the Attendance arraylist is empty.", 0, attendanceList.size());
		// Attempt to retrieve the Attendance
		String allAttendance= C206_CaseStudy.retrieveAllAttendance(attendanceList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allAttendance);

		//Test Case 2
		C206_CaseStudy.addAttendance(attendanceList, a01);
		// Test that the list is not empty
		assertEquals("Test that Attendance arraylist size is 1.", 1, attendanceList.size());
		// Attempt to retrieve the Attendance
		allAttendance= C206_CaseStudy.retrieveAllAttendance(attendanceList);
		testOutput = String.format("%-10s %-20s %-20s\n","A01", "Toby Oh", "Absent");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allAttendance);

		//Test Case 3
		C206_CaseStudy.addAttendance(attendanceList, a02);
		C206_CaseStudy.addAttendance(attendanceList, a03);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 3.", 3, attendanceList.size());
		// Attempt to retrieve the Attendance
		allAttendance= C206_CaseStudy.retrieveAllAttendance(attendanceList);
		testOutput = String.format("%-10s %-20s %-20s\n","A01", "Toby Oh", "Absent");
		testOutput += String.format("%-10s %-20s %-20s\n","A02", "G V Timothy", "Present");
		testOutput += String.format("%-10s %-20s %-20s\n","A03", "Xavier Quek", "Absent");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allAttendance);
	}

	// 22012924 Toby
	@Test
	public void testDeleteAttendance() {
		// Attendance list is not null and it is not empty
		C206_CaseStudy.addAttendance(attendanceList, a01);
		C206_CaseStudy.addAttendance(attendanceList, a02);
		C206_CaseStudy.addAttendance(attendanceList, a03);
		assertNotNull("Test if there is a valid Attendance arraylist to delete", attendanceList);
		assertEquals("Test that the Attendance arraylist is not empty.", 3, attendanceList.size());

		// Delete a attendance
		C206_CaseStudy.deleteAttendance(attendanceList, "A02");
		assertEquals("Test that the Attendance arraylist size is now 2.", 2, attendanceList.size());

		// Delete the last attendance in the list
		C206_CaseStudy.deleteAttendance(attendanceList, "A03");
		assertEquals("Test that the Attendance arraylist size is now 1.", 1, attendanceList.size());

		// Delete a attendance that does not exist in the list
		C206_CaseStudy.deleteAttendance(attendanceList, "A04");
		assertEquals("Test that the Attendance arraylist size is unchanged.", 1, attendanceList.size());

	}
	
	
	@After
	public void tearDown() throws Exception {
		// 22009300 Timothy
		u01 = null;
		u02 = null;
		u03 = null;
		userList = null;
		
		// 22045451 Li Hua
		c01 = null;
		c02 = null;
		c03 = null;
		courseList = null;
		
		// 22031945 Jian Hong
		s01 = null;
		s02 = null;
		s03 = null;
		studentList = null;
		
		// 22024777 Ryan
		f01 = null;
		f02 = null;
		f03 = null;
		feesList = null;
		
		// 22012942 Xavier	
		e01 = null;
		e02 = null;
		e03 = null;
		enrolmentList = null;
		
		// 22012924 Toby
		a01 = null;
		a02 = null;
		a03 = null;
		attendanceList = null;
	}
	
} // end of class