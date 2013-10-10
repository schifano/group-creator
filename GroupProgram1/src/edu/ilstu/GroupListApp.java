package edu.ilstu;

/*
 * Filename: GroupListApp.java
 * Oct 2, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author John Boomgarden
 * 
 *         <insert description
 * 
 */
public class GroupListApp {
	private int numGroups;
	private int groupSize;
	private int numFemales; // Number of females per group
	private int numMales; // Number of males allowed per group
	private boolean genderBiased;
	private Scanner in;

	public GroupListApp() {
		numGroups = 0;
		groupSize = 0;
		numFemales = 0;
		genderBiased = false;
	}

	public GroupList CreateGroupList(File studentListFile, File lastGroupFile) {
		Group studentList = new Group();
		GroupList lastGroup = new GroupList();
		File studentFile = studentListFile;
		File groupFile = lastGroupFile;
		try {
			in = new Scanner(studentFile);

			while (in.hasNext()) {
				Student tmpStudent = new Student();

				tmpStudent.setFirstName(in.next());
				tmpStudent.setLastName(in.next());
				tmpStudent.setGender(in.next());

				studentList.addStudent(tmpStudent);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (groupFile != null) {
			try {
				in = new Scanner(studentFile);
				// read next Line from file
				// load that into String, parse into first last gender
				while (in.hasNext()) {
					Group tempList = new Group();
					while (in.next() != "") {
						Student tmpStudent = new Student();

						tmpStudent.setFirstName(in.next());
						tmpStudent.setLastName(in.next());
						tmpStudent.setGender(in.next());

						tempList.addStudent(tmpStudent);
					}
					lastGroup.addGroup(tempList);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		GroupList newGroup = this.CreateGroupList(studentList, lastGroup);
		return newGroup;

	}

	public GroupList CreateGroupList(Group studentList, GroupList lastGroup) 
	{
		int oldIndex = -1;
		boolean studentInGroup, studentAdded = false;
		GroupList groups = new GroupList();
		Random rand = new Random();

		// figure the total number of groups if the user selected the option to
		// specify the number in each group
		if (this.numGroups == 0 && this.groupSize != 0)
			this.calcNumGroups(this.groupSize, studentList.getGroupSize());

		// figure the total size of each group if the user specified the total
		// number of groups
		if (this.groupSize == 0 && this.numGroups != 0)
			this.calcGroupSize(this.numGroups, studentList.getGroupSize());

		this.setGenderLimits(studentList);

		// loop through all Student objects in the studentList
		// studentList contains all the students in the lab class
		System.out.println("before for loop");
		for (int i = 0; i < studentList.getGroupSize(); i++) {
			System.out.println("in for loop");
			while (!studentAdded) {
				System.out.println("in not student added");
				// generate random number for index of group to try adding
				// student to
				int newIndex = rand.nextInt(numGroups) - 1;
				System.out.println(newIndex);
				// find which labGroup the student was in the last time
				if (lastGroup != null)
					oldIndex = lastGroup.findStudent(studentList.getStudent(i));
				System.out.println(oldIndex);
				studentInGroup = false;
				studentAdded = false;
				// if oldIndex is -1, that means the specified student was not
				// in any labGroup last time
				if (oldIndex == -1)
					studentInGroup = false;
				else {
					for (int j = 0; j < lastGroup.getGroup(oldIndex)
							.getGroupSize(); j++) {
						if (lastGroup.getGroup(oldIndex).containsStudent(
								groups.getGroup(newIndex).getStudent(j)))
							studentInGroup = true;
					}
				}
				if (groups.getGroup(newIndex)== null)
				{
				    Group tmpGroup = new Group(); 
				    groups.addGroup(tmpGroup);
				}
				
				if (!studentInGroup
						&& correctNumbers(groups.getGroup(newIndex),
								studentList.getStudent(i))) {
					studentAdded = true;
					groups.getGroup(newIndex).addStudent(
							studentList.getStudent(i));
				}

			}
		}
return groups;
	}

	public void setGenderLimits(Group studentList) {
		if (genderBiased) {
			int totalFemales = 0;
			// loop through all Student objects in the studentList.
			// and count how many total females there are.
			for (int i = 0; i < studentList.getGroupSize(); i++) {
				if (studentList.getStudent(i).getGender() == "F")
					totalFemales++;
			}
			// once we know how many total females there are, then we will
			// divide that
			// number by the total number of groups.

			if (totalFemales % numGroups == 0) {
				this.numFemales = totalFemales / numGroups;
				this.numMales = groupSize - this.numFemales;
			} else {
				this.numFemales = (totalFemales / numGroups) + 1;
				this.numMales = groupSize - this.numFemales + 1;
			}
		} else {
			this.numFemales = this.groupSize;
			this.numMales = this.groupSize;
		}

	}

	public boolean correctNumbers(Group grp, Student stu1) {
		boolean OKToAddToGroup = true;

		// if we are equal to or greater than the maximum number in the group,
		// we can't add the student

		if (grp.getGroupSize() >= this.groupSize)
			OKToAddToGroup = false;

		// if the student being added is female, and that student will cause
		// there to be too many females in the group, we can't add that student.
		// Likewise for males.
		if (stu1.getGender() == "F"
				&& grp.getNumberFemalesInGroup() >= this.numFemales)
			OKToAddToGroup = false;
		else if (stu1.getGender() == "M"
				&& grp.getNumberMalesInGroup() >= this.numMales)
			OKToAddToGroup = false;
		return OKToAddToGroup;
	}

	/**
	 * This method is called if the user specified the total number of groups
	 * desired. Then, the size of each group will be figured based on that and
	 * the total number of students.
	 * 
	 * @param numGroups
	 *            total number of labGroups desired
	 */
	public void calcNumGroups(int groupSize, int fullGroupSize) {
		if (groupSize != 0) {
			if (fullGroupSize % groupSize == 0)
				this.numGroups = fullGroupSize / groupSize;
			else {
				this.numGroups = (fullGroupSize / groupSize) + 1;
			}
		}
	}

	/**
	 * This method is called if the user specified the total number of groups
	 * desired. Then, the size of each group will be figured based on that and
	 * the total number of students.
	 * 
	 * @param numGroups
	 *            total number of labGroups desired
	 */
	public void setNumGroups(int numGroups) {
		this.numGroups = numGroups;
		this.groupSize = 0;
	}

	/**
	 * This method is called if the user specified the size of each group. Then,
	 * the number of groups will be determined by dividing the total number of
	 * students by the size of each group.
	 * 
	 * @param groupSize
	 *            The maximum number of students in each group.
	 */
	public void setGroupSize(int groupSize) {
		this.numGroups = 0;
		this.groupSize = groupSize;
	}

	public int getNumFemales() {
		return this.numFemales;
	}

	public int getNumMales() {
		return this.numMales;
	}

	public int getGroupSize() {
		return this.groupSize;
	}

	public int getNumGroups() {
		return this.numGroups;
	}

	public boolean getBiased() {
		return this.genderBiased;
	}

	public void setBiased(boolean gender) {
		this.genderBiased = gender;
	}

	/**
	 * This method is called if the user specified the size of each group. Then,
	 * the number of groups will be determined by dividing the total number of
	 * students by the size of each group.
	 * 
	 * @param groupSize
	 *            The maximum number of students in each group.
	 * @param fullGroupSize
	 *            The total number of students in the class.
	 */
	public void calcGroupSize(int numGroups, int fullGroupSize) {
		if (numGroups != 0) {
			if (fullGroupSize % numGroups == 0) {
				this.groupSize = fullGroupSize / numGroups;
			} else {
				this.groupSize = (fullGroupSize / numGroups) + 1;
			}
		}
	}

}
