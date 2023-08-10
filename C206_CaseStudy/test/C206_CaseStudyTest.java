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
	
	private Fees f01;
	private Fees f02;
	private Fees f03;

	
	private ArrayList<User> userList;
	private ArrayList<Fees> feesList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		// Prepare test data
		u01 = new User("U01", "G V Timothy", "Administrator");
		u02 = new User("U02", "Toby Oh", "Administrator");
		u03 = new User("U03", "Ryan Loh", "Administrator");
		
		f01 = new Fees("F01", "G V Timothy", "Paid");
		f02 = new Fees("F02", "Toby Oh", "Pending");
		f03 = new Fees("F03", "Ryan Loh", "Paid");
		
		userList= new ArrayList<User>();
		
		feesList= new ArrayList<Fees>();
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
		Fees f_missing = new Fees("F03", "", "Paid");
		C206_CaseStudy.addFees(feesList, f_missing);
		assertEquals("Test that the Fees arraylist size is unchanged.", 2, feesList.size());
	}
	
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
		testOutput = String.format("%-10s %-20s %-20s\n","F01", "G V Timothy", "Paid");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allFees);

		//Test Case 3
		C206_CaseStudy.addFees(feesList, f02);
		C206_CaseStudy.addFees(feesList, f03);
		// Test that the list is not empty
		assertEquals("Test that Fees arraylist size is 3.", 3, feesList.size());
		// Attempt to retrieve the Fees
		allFees= C206_CaseStudy.retrieveAllFees(feesList);
		testOutput = String.format("%-10s %-20s %-20s\n","F01", "G V Timothy", "Paid");
		testOutput += String.format("%-10s %-20s %-20s\n","F02", "Toby Oh", "Pending");
		testOutput += String.format("%-10s %-20s %-20s\n","F03", "Ryan Loh", "Paid");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allFees);
	}
	
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
	
	@After
	public void tearDown() throws Exception {
	}

} // end of class