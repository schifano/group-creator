package ilstu.edu;

/**
 * Description: Student class used to create new student objects.
 * @author Rachel A Schifano
 *
 */

public class Student {

	// instance variables
	private String firstName;
	private String lastName;
	private String gender;
	
	/**
	 * Constructor
	 */
	public Student() {
		
		firstName=" ";
		lastName=" ";
		gender=" ";
	}
	
	/**
	 * Method that returns the first name of a student.
	 * @return firstName First name of the student
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Method that sets the first name of a student.
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	/**
	 * Method that returns the last name of a student.
	 * @return lastName Last name of the student
	 */
	public String getLastName() {
		return lastName; 
	}
	
	/**
	 * Method that sets the last name of a student.
	 */
	public void setLastName(String name) {
		this.firstName = name;
	}
	
	/**
	 * Method that returns the gender of the student
	 * @return gender The gender of the student
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Method that sets the gender of the student
	 */
	public void setGender(String studentGender) {
		this.gender = studentGender;
	}

	
	/**
	 * Method that checks if two students are identical or not
	 * @param student1 The first student object
	 * @param student2 The second student object
	 * @return true The two students are identical
	 * @return false The two students are not identical
	 */
	public boolean checkStudent(Student student1, Student student2) {
		
		// get student names and convert to lower case for easy comparison
		String firstName1 = student1.getFirstName().toLowerCase();
		String lastName1 = student1.getLastName().toLowerCase();
		
		String firstName2 = student2.getFirstName().toLowerCase();
		String lastName2 = student2.getFirstName().toLowerCase();		
		
		// compare first names
		if (firstName1.equals(firstName2)) {
			if(lastName1.equals(lastName2)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
