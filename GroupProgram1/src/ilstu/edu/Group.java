package edu.ilstu;

/*
 * Filename: Group.java
 * Oct 3, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Mrs. Holbrook
 */
import java.util.ArrayList;

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

	/**
	 * Generic constructor which creates initialized array;
	 */
	public Group() {
		studentList = new ArrayList<Student>();

	}

	/**
	 * This method will add a Student object to the arrayList
	 */
	public void addStudent(Student stu1) {
		studentList.add(stu1);
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
	
	public boolean removeStudent(Student stu1) 
	{
		boolean removed;
		removed = false;
		System.out.println("in method");
		Student tempStudent;
		System.out.println(this.getGroupSize());
		for (int i = 0; i < this.getGroupSize() && ! removed; i++) 
		{
			System.out.println(i);
			System.out.println("In for loop");
			tempStudent = this.get(i);
			System.out.println(stu1);
			System.out.println(tempStudent);
			if (tempStudent.checkStudent(stu1))
			{
				removed = true;
				this.remove(i);
			}
		}

		return removed;
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
