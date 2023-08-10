public class Institution {
<<<<<<< HEAD
 
 private String id;
 private String name;
 
 public Institution(String id, String name) {
  this.id = id;
  this.name = name;
 }

 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }
 

} // end of class\
=======

	private String id;
	private String name;

	public Institution(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void displayDetails() {
		System.out.println("Id   : " + id);
		System.out.println("Name : " + name);
	}

	public String toString() {
		String output = String.format("%-10s %-20s", id, name);
		return output;
	}

} // end of class
>>>>>>> branch 'master' of https://github.com/22009300-Timothy/C206_CaseStudy
