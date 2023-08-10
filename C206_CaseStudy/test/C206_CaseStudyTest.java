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
	
	private Enrolment e01;
	private Enrolment e02;
	private Enrolment e03;
	
	private ArrayList<User> userList;
	private ArrayList<Enrolment> enrolmentList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		// Prepare test data
		u01 = new User("U01", "G V Timothy", "Administrator");
		u02 = new User("U02", "Toby Oh", "Administrator");
		u03 = new User("U03", "Ryan Loh", "Administrator");
		
		e01 = new Enrolment("E01", "G V Timothy","Science","11/04/2023");
		e02 = new Enrolment("E02", "Toby Oh","Math","11/08/2023");
		e03 = new Enrolment("E03", "Xavier","English","11/02/2023");
		
		userList= new ArrayList<User>();
		enrolmentList = new ArrayList<Enrolment>();
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

		// Add a user that has missing detail
		Enrolment e_missing = new Enrolment("E03", "", "English", "11/02/2023");
		C206_CaseStudy.addEnrolment(enrolmentList, e_missing);
		assertEquals("Test that the Enrolment arraylist size is unchanged.", 2, enrolmentList.size());
	}
	
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
		testOutput = String.format("%-20s %-20s %-20s %-20s\n","E01", "G V Timothy", "Science","11/04/2023");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allEnrolment);

		//Test Case 3
		C206_CaseStudy.addEnrolment(enrolmentList, e02);
		C206_CaseStudy.addEnrolment(enrolmentList, e03);
		// Test that the list is not empty
		assertEquals("Test that Enrolment arraylist size is 3.", 3, enrolmentList.size());
		// Attempt to retrieve the User
		allEnrolment= C206_CaseStudy.retrieveAllEnrolment(enrolmentList);
		testOutput = String.format("%-20s %-20s %-20s %-20s\n","E01", "G V Timothy", "Science","11/04/2023");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n","E02", "Toby Oh", "Math","11/08/2023");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n","E03", "Xavier", "English","11/02/2023");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allEnrolment);
	}
	
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
	
	@After
	public void tearDown() throws Exception {
	}

} // end of class
