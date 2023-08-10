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
	
	private Attendance a01;
	private Attendance a02;
	private Attendance a03;
	
	private ArrayList<User> userList;
	private ArrayList<Attendance> attendanceList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		// Prepare test data
		u01 = new User("U01", "G V Timothy", "Administrator");
		u02 = new User("U02", "Toby Oh", "Administrator");
		u03 = new User("U03", "Ryan Loh", "Administrator");
		
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
	}

	@After
	public void tearDown() throws Exception {
	}

} // end of class
