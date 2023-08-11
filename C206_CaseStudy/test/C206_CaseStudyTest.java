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
	
	private Course c01;
	private Course c02;
	private Course c03;
	
	private ArrayList<User> userList;
	private ArrayList<Course> courseList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		// Prepare test data
		u01 = new User("U01", "G V Timothy", "Administrator");
		u02 = new User("U02", "Toby Oh", "Administrator");
		u03 = new User("U03", "Ryan Loh", "Administrator");
		
		c01 = new Course("C01", "G V Timothy", "Popular");
		c02 = new Course("C02", "Toby Oh", "Mid");
		c03 = new Course("C03", "Ryan Loh", "Not Popular");
		
		userList= new ArrayList<User>();
		courseList= new ArrayList<Course>();
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
		Course c_missing = new Course("C03", "", "Administrator");
		C206_CaseStudy.addCourse(courseList, c_missing);
		assertEquals("Test that the Course arraylist size is unchanged.", 2, courseList.size());
	}
	
	@Test
	public void testRetrieveAllCourse() {
		// Test Case 1
		// Test if Course list is not null and empty
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);
		assertEquals("Test that the Course arraylist is empty.", 0, courseList.size());
		// Attempt to retrieve the Users
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
		testOutput = String.format("%-10s %-20s %-20s\n","C01", "G V Timothy", "Popular");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCourse);

		//Test Case 3
		C206_CaseStudy.addCourse(courseList, c02);
		C206_CaseStudy.addCourse(courseList, c03);
		// Test that the list is not empty
		assertEquals("Test that Course arraylist size is 3.", 3, courseList.size());
		// Attempt to retrieve the Course
		allCourse= C206_CaseStudy.retrieveAllCourse(courseList);
		testOutput = String.format("%-10s %-20s %-20s\n","C01", "G V Timothy", "Popular");
		testOutput += String.format("%-10s %-20s %-20s\n","C02", "Toby Oh", "Mid");
		testOutput += String.format("%-10s %-20s %-20s\n","C03", "Ryan Loh", "Not Popular");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCourse);
	}
	
	@Test
	public void testDeleteCourse() {
		// Course list is not null and it is not empty
		C206_CaseStudy.addCourse(courseList, c01);
		C206_CaseStudy.addCourse(courseList, c02);
		C206_CaseStudy.addCourse(courseList, c03);
		assertNotNull("Test if there is a valid Course arraylist to delete", courseList);
		assertEquals("Test that the Course arraylist is not empty.", 3, courseList.size());

		// Delete a user
		C206_CaseStudy.deleteCourse(courseList, "C02");
		assertEquals("Test that the Course arraylist size is now 2.", 2, courseList.size());

		// Delete the last user in the list
		C206_CaseStudy.deleteCourse(courseList, "C03");
		assertEquals("Test that the Course arraylist size is now 1.", 1, courseList.size());

		// Delete a user that does not exist in the list
		C206_CaseStudy.deleteCourse(courseList, "C04");
		assertEquals("Test that the Course arraylist size is unchanged.", 1, courseList.size());
	}
	
	@After
    public void tearDown() throws Exception {
        c01 = null;
        c02 = null;
        c03 = null;
        courseList = null;
    }
} // end of class
