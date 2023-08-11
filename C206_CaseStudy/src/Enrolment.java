public class Enrolment extends Institution{

	private String courseName;
	private String enrolmentDate;



	public Enrolment(String id, String name, String courseName, String enrolmentDate) {
		super(id, name);
		this.courseName = courseName;
		this.enrolmentDate = enrolmentDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEnrolmentDate() {
		return enrolmentDate;
	}

	public void setEnrolmentDate(String enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}

} // end of class