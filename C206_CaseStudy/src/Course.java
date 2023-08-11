public class Course extends Institution{

	    private String details;

	    public Course(String id, String name, String details) {
	        super(id, name);
	        this.details = details;
	    }

	    public String getDetails() {
	        return details;
	    }

	    public void setRole(String role) {
	        this.details = details;
	    }
} // end of class
