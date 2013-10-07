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
 * @author John Boomgarden
 * 
 *         This class contains an arrayList of Student Objects.
 * 
 */
public class Group extends ArrayList<Student> {

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
			System.out.println(studentList);
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
	public int getGroupSize() {
		int groupSize = 0;
		groupSize = studentList.size();
		return groupSize;
	}

	/**
	 * This method will call the Student method to see if the passed in Student
	 * matches any of the students already contained in the arrayList contained
	 * in this Group.
	 * 
	 * @return boolean indicator which is true if the student exists in the
	 *         Group
	 */
	public boolean containsStudent(Student stu1) {
		boolean inGroup;
		inGroup = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).checkStudent(stu1))
				inGroup = true;
		}

		return inGroup;

	}
	
	public String toString()
	{
		String str1 = "";
		
		for(int i = 0; i < this.getGroupSize(); i++)
		{
			str1 += studentList.get(i).toString() + "\n";
		}
				return str1;
	}

	public int getNumberFemalesInGroup() {
		int groupNumFemales = 0;
		for (int i = 0; i < this.getGroupSize(); i++) {
			if (this.get(i).getGender() == "F")
				groupNumFemales++;
		}
		return groupNumFemales;
	}

	public int getNumberMalesInGroup() {
		int groupNumMales = 0;
		for (int i = 0; i < this.getGroupSize(); i++) {
			if (this.get(i).getGender() == "M")
				groupNumMales++;
		}
		return groupNumMales;
	}
}
