// 22045451 Li Hua
public class Course extends Institution {
	
	private String instructor;
	private String schedule;

	public Course(String id, String name,String instructor, String schedule) {
		super(id, name);
		this.instructor = instructor;
		this.schedule = schedule;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
} // end of class