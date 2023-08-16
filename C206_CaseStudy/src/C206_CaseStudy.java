import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("S01", "G V Timothy", 12, "Pass", "22009300@myrp.edu.sg"));
		studentList.add(new Student("S02", "Toby Oh", 14, "Pass", "22012924@myrp.edu.sg"));

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Timothy
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

	// ================================= Option 3 Manage students
	// =================================

	public static Student inputStudent() {
		String id = Helper.readString("Enter student id > ");
		String name = Helper.readString("Enter name > ");
		int age = Helper.readInt("Enter age > ");
		String grade = Helper.readString("Enter grade > ");
		String email = Helper.readString("Enter email address > ");

		Student s = new Student(id, name, age, grade, email);
		return s;

	}

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

	public static void viewAllStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("STUDENT LIST");
		String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "USER ID", "NAME", "AGE", "GRADE", "EMAIL");
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

} // end of class