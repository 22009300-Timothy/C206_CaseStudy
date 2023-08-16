import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	// Prepare test data
	
	private Student s01;
	private Student s02;
	private Student s03;
	
	private ArrayList<Student> studentList;

	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		// Prepare test data
		
		s01 = new Student("S01", "G V Timothy", 12, "Pass", "22009300@myrp.edu.sg");
		s02 = new Student("S02", "Toby Oh", 14, "Pass", "22012924@myrp.edu.sg");
		s03 = new Student("S03", "Ryan Loh", 17, "Fail", "22024777@myrp.edu.sg");
				
		studentList= new ArrayList<Student>();

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
		Student s_missing = new Student("S03", "", 17, "Fail", "22024777@myrp.edu.sg");
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

	@After
    public void tearDown() throws Exception {
        s01 = null;
        s02 = null;
        s03 = null;
        studentList = null;
    }
	

} // end of class