
public class Student extends Institution {

	private int age;

	public Student(String id, String name, int age) {
		super(id, name);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

} // end of class