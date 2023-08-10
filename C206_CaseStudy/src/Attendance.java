
public class Attendance extends Institution{
	
	private String status;

	public Attendance(String id, String name, String status) {
		super(id, name);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
