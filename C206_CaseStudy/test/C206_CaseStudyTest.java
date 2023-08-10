import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	// Prepare test data
	private User u01;
	private User u02;
	private User u03;
	
<<<<<<< HEAD
	private Attendance a01;
	private Attendance a02;
	private Attendance a03;
	
	private ArrayList<User> userList;
	private ArrayList<Attendance> attendanceList;
=======
<<<<<<< HEAD
	private Student s01;
	private Student s02;
	private Student s03;
	
	private ArrayList<User> userList;
	private ArrayList<Student> studentList;

=======
	private ArrayList<User> userList;
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy.git
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		// Prepare test data
		u01 = new User("U01", "G V Timothy", "Administrator");
		u02 = new User("U02", "Toby Oh", "Administrator");
		u03 = new User("U03", "Ryan Loh", "Administrator");
		
<<<<<<< HEAD
		a01 = new Attendance("A01", "Toby Oh", "Absent");
		a02 = new Attendance("A02", "G V Timothy", "Present");
		a03 = new Attendance("A03", "Xavier Quek", "Absent");
		
		userList= new ArrayList<User>();
		attendanceList = new ArrayList<Attendance>();
	}
	
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
		User u_missing = new User("U03", "", "Administrator");
		C206_CaseStudy.addUser(userList, u_missing);
		assertEquals("Test that the User arraylist size is unchanged.", 2, userList.size());
	}
	
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
		testOutput = String.format("%-10s %-20s %-20s\n","U01", "G V Timothy", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);

		//Test Case 3
		C206_CaseStudy.addUser(userList, u02);
		C206_CaseStudy.addUser(userList, u03);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 3.", 3, userList.size());
		// Attempt to retrieve the User
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-20s %-20s\n","U01", "G V Timothy", "Administrator");
		testOutput += String.format("%-10s %-20s %-20s\n","U02", "Toby Oh", "Administrator");
		testOutput += String.format("%-10s %-20s %-20s\n","U03", "Ryan Loh", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);
	}
	
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
=======
<<<<<<< HEAD
		s01 = new Student("S01", "G V Timothy", 12);
		s02 = new Student("S02", "Toby Oh", 14);
		s03 = new Student("S03", "Ryan Loh", 17);
		
		userList= new ArrayList<User>();
		
		studentList= new ArrayList<Student>();

	}
	
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
		User u_missing = new User("U03", "", "Administrator");
		C206_CaseStudy.addUser(userList, u_missing);
		assertEquals("Test that the User arraylist size is unchanged.", 2, userList.size());
	}
	
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
		testOutput = String.format("%-10s %-20s %-20s\n","U01", "G V Timothy", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);

		//Test Case 3
		C206_CaseStudy.addUser(userList, u02);
		C206_CaseStudy.addUser(userList, u03);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 3.", 3, userList.size());
		// Attempt to retrieve the User
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-20s %-20s\n","U01", "G V Timothy", "Administrator");
		testOutput += String.format("%-10s %-20s %-20s\n","U02", "Toby Oh", "Administrator");
		testOutput += String.format("%-10s %-20s %-20s\n","U03", "Ryan Loh", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);
	}
	
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
		Student s_missing = new Student("S03", "", 17);
		C206_CaseStudy.addStudent(studentList, s_missing);
		assertEquals("Test that the Student arraylist size is unchanged.", 2, studentList.size());
	}
	
	@Test
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
		testOutput = String.format("%-10s %-20s %-20d\n","S01", "G V Timothy", 12);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allStudent);

		//Test Case 3
		C206_CaseStudy.addStudent(studentList, s02);
		C206_CaseStudy.addStudent(studentList, s03);
		// Test that the list is not empty
		assertEquals("Test that Student arraylist size is 3.", 3, studentList.size());
		// Attempt to retrieve the Student
		allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-10s %-20s %-20d\n","S01", "G V Timothy", 12);
		testOutput += String.format("%-10s %-20s %-20d\n","S02", "Toby Oh", 14);
		testOutput += String.format("%-10s %-20s %-20d\n","S03", "Ryan Loh", 17);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allStudent);
	}
	
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
=======
		userList= new ArrayList<User>();
	}
	
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
		User u_missing = new User("U03", "", "Administrator");
		C206_CaseStudy.addUser(userList, u_missing);
		assertEquals("Test that the User arraylist size is unchanged.", 2, userList.size());
	}
	
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
		testOutput = String.format("%-10s %-20s %-21s\n","U01", "G V Timothy", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);

		//Test Case 3
		C206_CaseStudy.addUser(userList, u02);
		C206_CaseStudy.addUser(userList, u03);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 3.", 3, userList.size());
		// Attempt to retrieve the User
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-20s %-21s\n","U01", "G V Timothy", "Administrator");
		testOutput += String.format("%-10s %-20s %-21s\n","U02", "Toby Oh", "Administrator");
		testOutput += String.format("%-10s %-20s %-21s\n","U03", "Ryan Loh", "Administrator");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);
	}
	
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
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy.git
	}

	@After
<<<<<<< HEAD
    public void tearDown() throws Exception {
        s01 = null;
        s02 = null;
        s03 = null;
        studentList = null;
    }
=======
	public void tearDown() throws Exception {
		u01 = null;
		u02 = null;
		u03 = null;
		userList = null;
	}
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy

<<<<<<< HEAD
} // end of class
=======
} // end of class
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy.git
