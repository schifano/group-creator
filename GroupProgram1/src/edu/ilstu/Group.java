package edu.ilstu;

/*
 * Filename: Group.java
 * Oct 3, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Mrs. Holbrook
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author John Boomgarden, Rachel Schifano, Corbin Sumner
 * 
 *         This class contains an arrayList of Student Objects.
 * 
 */
public class Group extends ArrayList<Student>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Student> studentList;
	private Scanner in;
	
	
	/**
	 * Generic constructor which creates initialized array;
	 */
	public Group() 
	{
		studentList = new ArrayList<Student>();	
	}
	
	/**
	 * This constructor will create a Group object when a file is fed into the constructor. 
	 * @param studentOptionsFile File which contains the list of names in the format
	 * First Name    Last Name    Gender (M or F)
	 */
	
	public Group(File studentOptionsFile)
	{
		File groupFile = studentOptionsFile;
		studentList = new ArrayList<Student>();
		
		try {
			in = new Scanner(groupFile);
			
			while(in.hasNext())
			{
				Student tmpStudent = new Student();
				
				tmpStudent.setFirstName(in.next());
				tmpStudent.setLastName(in.next());
				tmpStudent.setGender(in.next());
				
				studentList.add(tmpStudent);
			}
			}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * This method will add a Student object to the arrayList
	 */
	public void addStudent(Student stu1) {
		studentList.add(stu1);
	}
	
	/**
	 * This method will add a Student object to the arrayList
	 * by passing in only the name and gender Strings
	 */
	public void addStudent(String firstName, String lastName, String gender) 
	{
		Student stu1 = new Student();
		stu1.setFirstName(firstName);
		stu1.setLastName(lastName);
		stu1.setGender(gender);
		this.addStudent(stu1);
	}

	/**
	 * This method will return the number of Students contained in the group
	 * 
	 * @return number of Students in the Group
	 */
	public int getGroupSize()
	{
		int groupSize = 0;
		groupSize = studentList.size();
		return groupSize;
	}

	/**
	 * This method will look in the Group to find if a Student exists in the Group
	 * It is not necessary to create a Student object before calling this method. This method will take 
	 * the passed in Strings, and create a Student object, and then call the containsStudent method passing
	 * in that student. 
	 * @param firstName 
	 * @param lastName
	 * @return  indicator which tells if the Student exists
	 */
	public boolean containsStudent(String firstName, String lastName) 
	{
		Student stu1 = new Student();
		stu1.setFirstName(firstName);
		stu1.setLastName(lastName);
		return this.containsStudent(stu1);
	}
	
	/**
	 * This method will call the checkStudent method to see if the passed in Student
	 * matches any of the students already contained in the arrayList contained
	 * in this Group.
	 * 
	 * @return boolean indicator which is true if the student exists in the
	 *         Group
	 */
	public boolean containsStudent(Student stu1) 
	{
		boolean inGroup;
		inGroup = false;
		for (int i = 0; i < studentList.size(); i++) 
		{
			if (studentList.get(i).checkStudent(stu1))
				inGroup = true;
		}

		return inGroup;

	}
	
	/**
	 * This method will remove the specified student from the Group. 
	 * It is not necessary to create a Student object before calling this method. This method will take 
	 * the passed in Strings, and create a Student object, and then call the removeStudent method passing
	 * in that student. 
	 * 
	 * @param firstName
	 * @param lastName
	 * @return  boolean indicating that the Student was found and then removed
	 */
	public boolean removeStudent(String firstName, String lastName) 
	{
		Student stu1 = new Student();
		stu1.setFirstName(firstName);
		stu1.setLastName(lastName);
		return this.removeStudent(stu1);
	}
	
	/**
	 * 
	 * This method will take the passed in Student object and search through the 
	 * ArrayList until it is found. If it is in the ArrayList, it will be removed 
	 * from that position. 
	 * @param stu1 Student object to be removed from ArrayList
	 * @return true if the Student exists in the ArrayList before the call. 
	 */
	public boolean removeStudent(Student stu1) {
		boolean inGroup;
		inGroup = false;
		for (int i = 0; i < studentList.size(); i++) 
		{
			if (studentList.get(i).checkStudent(stu1))
			{
				studentList.remove(i);
				inGroup = true;
			}
		}
		return inGroup;

	}
	
	/**
	 * This method will return a Student object located at the index location of the ArrayList.
	 * 
	 * @param index The ArrayList location which is desired. 
	 * @return  Student object at that location in the ArrayList
	 */
	public Student getStudent(int index)
	{
		return studentList.get(index);
	}
	

/**
 * This method will loop through all Students in the ArrayList. and count 
 * the number of them where the gender is F. 
 * @return  The number of female Student objects in a Group. 
 */
	public int getNumberFemalesInGroup() {
		int groupNumFemales = 0;
		for (int i = 0; i < this.getGroupSize(); i++) {
			if (studentList.get(i).getGender() == "F")
				groupNumFemales++;
		}
		return groupNumFemales;
	}
	
	/**
	 * This method will loop through all Students in the ArrayList. and count 
	 * the number of them where the gender is M. 
	 * @return  The number of male Student objects in a Group. 
	 */
	public int getNumberMalesInGroup() {
		int groupNumMales = 0;
		for (int i = 0; i < this.getGroupSize(); i++) {
			if (studentList.get(i).getGender() == "M")
				groupNumMales++;
		}
		return groupNumMales;
	}
	
	public String toString()
	{
		String str1 = "";
		
		for(int i = 0; i < studentList.size(); i++)
		{
			str1 += studentList.get(i) + "\n";
		}
		return str1;
	}
}
