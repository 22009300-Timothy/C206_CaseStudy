
	import java.util.ArrayList;

	public class C206_CaseStudy {

	 public static void main(String[] args) {
	  
	  ArrayList<User> userList = new ArrayList<User>();
	  ArrayList<Enrolment> enrolmentList = new ArrayList<Enrolment>();
	  
	  
	  userList.add(new User("U01", "G V Timothy", "Administrator"));
	  userList.add(new User("U02", "Toby Oh", "Administrator"));
	  
	  enrolmentList.add(new Enrolment("E01", "G V Timothy","Science","11/04/2023"));
	  enrolmentList.add(new Enrolment("E02", "Toby Oh","Math","11/08/2023"));
	  
	  int option = 0;
	  
	  while (option != 7) {
	   
	   C206_CaseStudy.menu();
	   option = Helper.readInt("Enter an option > ");
	   
	   if (option == 1) {
	    
	    int detailType = 0;
	    
	    while (detailType != 4) {
	     
	     C206_CaseStudy.setHeader("USERS");   
	     C206_CaseStudy.setHeader("DETAIL TYPES");
	     System.out.println("1. Add a new user");
	     System.out.println("2. View all users");
	     System.out.println("3. Delete an existing user");
	     System.out.println("4. Quit");
	     
	     detailType = Helper.readInt("\nEnter option to select detail type > ");
	     
	     if (detailType == 1) {
	      // Add a a new user
	      User u = inputUser();
	      C206_CaseStudy.addUser(userList, u);
	     } else if (detailType == 2) {
	      // View all users
	      C206_CaseStudy.viewAllUser(userList);
	     }  else if (detailType == 3) {
	      // Delete an existing user
	      String id = Helper.readString("Enter user id > ");
	      C206_CaseStudy.deleteUser(userList, id);
	     } else if (detailType == 4) {
	      System.out.println("Thank you!");
	     } else {
	      System.out.println("Invalid option");
	     } 
	    }
	    
	   } else if (option == 2) {
	    // Li Hua
	   } else if (option == 3) {
	    // Jian Hong 
	   } else if (option == 4) {
	    // Ryan
	   } else if (option == 5) {
		   int detailType = 0;
		    
		    while (detailType != 4) {
		     
		     C206_CaseStudy.setHeader("ENROLMENTS");   
		     C206_CaseStudy.setHeader("DETAIL TYPES");
		     System.out.println("1. Add a new Enrolemnt");
		     System.out.println("2. View all Enrolments");
		     System.out.println("3. Delete an existing enrolment");
		     System.out.println("4. Quit");
		     
		     detailType = Helper.readInt("\nEnter option to select detail type > ");
		     
		     if (detailType == 1) {
		      // Add a a new user
		      Enrolment e = inputEnrolment();
		      C206_CaseStudy.addEnrolment(enrolmentList, e);
		     } else if (detailType == 2) {
		      // View all users
		      C206_CaseStudy.viewAllEnrolment(enrolmentList);
		     }  else if (detailType == 3) {
		      // Delete an existing user
		      String id = Helper.readString("Enter user id > ");
		      C206_CaseStudy.deleteEnrolment(enrolmentList, id);
		     } else if (detailType == 4) {
		      System.out.println("Thank you!");
		     } else {
		      System.out.println("Invalid option");
		     } 
		    }
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
	 
	 //================================= Option 1 Manage users =================================
	 
	 public static User inputUser() {
	  String id = Helper.readString("Enter user id > ");
	  String name = Helper.readString("Enter name > ");
	  String role = Helper.readString("Enter role > ");

	  User u= new User(id, name, role);
	  return u;
	  
	 }
	 
	 public static void addUser(ArrayList<User> userList, User u) {
	  User detail;
	  for(int i = 0; i < userList.size(); i++) {
	   detail = userList.get(i);
	   if (detail.getId().equalsIgnoreCase(u.getId()) )
	    return;
	  }
	  if ((u.getId().isEmpty()) || (u.getName().isEmpty()) ) {
	   System.out.println("User id or name cannot be empty");
	   return;
	  } else {
	   userList.add(u);
	   System.out.println("User added");
	  }
	 }
	 
	 public static String retrieveAllUser(ArrayList<User> userList) {
	  String output = "";

	  for (int i = 0; i < userList.size(); i++) {
	   output += String.format("%-10s %-20s %-20s\n", userList.get(i).getId(), 
	     userList.get(i).getName(), userList.get(i).getRole());
	  }
	  return output;
	 }
	 
	 public static void viewAllUser(ArrayList<User> userList) {
	  C206_CaseStudy.setHeader("USER LIST");
	  String output = String.format("%-10s %-20s %-20s\n", "USER ID", "NAME",
	    "ROLE");
	   output += retrieveAllUser(userList); 
	  System.out.println(output);
	 }
	 
	 public static void deleteUser(ArrayList<User> userList, String id) {
	  for(int i = 0; i < userList.size(); i++) {
	   User detail = userList.get(i);
	   if (detail.getId().equalsIgnoreCase(id)) {
	    userList.remove(i);
	    System.out.println("User deleted");
	    return;
	   }
	  }
	  System.out.println("User not found");
	 }
	 
	 //================================= Option 5 Manage enrolment =================================
	 
	 public static Enrolment inputEnrolment() {
		  String id = Helper.readString("Enter Enrolment id > ");
		  String name = Helper.readString("Enter name > ");
		  String courseName = Helper.readString("Enter Course name > ");
		  String enrolmentDate = Helper.readString("Enter Enrolment Date > ");

		  Enrolment e= new Enrolment(id, name, courseName,enrolmentDate);
		  return e;
		  
		 }
		 
		 public static void addEnrolment(ArrayList<Enrolment> enrolmentList, Enrolment e) {
		  Enrolment detail;
		  for(int i = 0; i < enrolmentList.size(); i++) {
		   detail =enrolmentList.get(i);
		   if (detail.getId().equalsIgnoreCase(e.getId()) )
		    return;
		  }
		  if ((e.getId().isEmpty()) || (e.getName().isEmpty()) ) {
		   System.out.println("User id or name cannot be empty");
		   return;
		  } else {
		   enrolmentList.add(e);
		   System.out.println("Enrolment added");
		  }
		 }
		 
		 public static String retrieveAllEnrolment(ArrayList<Enrolment> enrolmentList) {
		  String output = "";

		  for (int i = 0; i < enrolmentList.size(); i++) {
		   output += String.format("%-20s %-20s %-20s %-20s\n", enrolmentList.get(i).getId(), 
		     enrolmentList.get(i).getName(), enrolmentList.get(i).getCourseName(),enrolmentList.get(i).getEnrolmentDate());
		  }
		  return output;
		 }
		 
		 public static void viewAllEnrolment(ArrayList<Enrolment> enrolmentList) {
		  C206_CaseStudy.setHeader("ENROLMENT LIST");
		  String output = String.format("%-20s %-20s %-20s %-20s\n", "ENROLMENT ID", "NAME",
		    "COURSE NAME","ENROLMENT DATE");
		   output += retrieveAllEnrolment(enrolmentList); 
		  System.out.println(output);
		 }
		 
		 public static void deleteEnrolment(ArrayList<Enrolment> enrolmentList, String id) {
		  for(int i = 0; i < enrolmentList.size(); i++) {
		   Enrolment detail = enrolmentList.get(i);
		   if (detail.getId().equalsIgnoreCase(id)) {
		    enrolmentList.remove(i);
		    System.out.println("Enrolment deleted");
		    return;
		   }
		  }
		  System.out.println("Enrolment not found");
		 }
	 
}
