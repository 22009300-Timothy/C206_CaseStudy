// 22012942 Xavier
public class Enrolment extends Institution{
	
	private String courseName;
	private String enrolmentDate;
	private String prerequisite;
	
	public Enrolment(String id, String name, String courseName,String prerequisite,String enrolmentDate) {
		super(id, name);
		this.courseName = courseName;
		this.prerequisite = prerequisite;
		this.enrolmentDate = enrolmentDate;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public String getEnrolmentDate() {
		return enrolmentDate;
	}

	public void setEnrolmentDate(String enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}
} // end of class