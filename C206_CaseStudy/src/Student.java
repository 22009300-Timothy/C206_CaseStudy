// 22031945 Jian Hong
public class Student extends Institution {

      private int age;
      private String grade;
      private String email;

      public Student(String id, String name, int age, String grade, String email) {
          super(id, name);
          this.age = age;
          this.grade = grade;
          this.email = email;
      }

      public int getAge() {
          return age;
      }

      public void setAge(int age) {
          this.age = age;
      }
      
      public String getGrade() {
        return grade;
      }

    public void setGrade(String grade) {
      this.grade = grade;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
  } // end of class