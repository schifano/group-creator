package edu.ilstu;

/*
 * Filename: GroupListApp.java
 * Oct 2, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author John Boomgarden, Rachel Schifano, Corbin Sumner
 * 
 *         This class will create a list of lab groups depending on the options
 *         the user specifies.
 * 
 */
public class GroupListApp
{
	private int numGroups;  // Total number of groups desired. 
	private int groupSize;  // Number of students allowed per group.
	private int numFemales; // Number of females allowed per group.
	private int numMales;   // Number of males allowed per group.
	private boolean genderBiased;  //True to indicate the user wants an even gender mix

	/**
	 * Constructor which initializes all variables
	 */
	public GroupListApp()
	{
		numGroups = 0;
		groupSize = 0;
		numFemales = 0;
		genderBiased = false;
	}

	/**
	 * This method will read in 2 files, one for the list of Student Objects,
	 * and one for the list of the last lab groups the Student was in.
	 * 
	 * @param studentListFile
	 *            File which includes all students in the class.
	 * @param lastGroupFile
	 *            File which lists lab groups and which students are in it.
	 * @return list of lab groups
	 */
	public GroupList CreateGroupList(File studentListFile, File lastGroupFile)
	{
		Scanner in = null;
		Group studentList = new Group();
		GroupList lastGroup = new GroupList();
		File studentFile = studentListFile;
		File groupFile = lastGroupFile;
		try
		{
			in = new Scanner(studentFile);

			while (in.hasNext())
			{
				Student tmpStudent = new Student();

				tmpStudent.setFirstName(in.next());
				tmpStudent.setLastName(in.next());
				tmpStudent.setGender(in.next());

				studentList.addStudent(tmpStudent);
			}
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		
		finally
		{
			if (in != null)
				in.close();
		}
		
		if (groupFile != null)
		{
			try
			{
				in = null;
				in = new Scanner(studentFile);
				// read next Line from file
				// load that into String, parse into first, last, and gender
				while (in.hasNextLine())
				{
					Group tempList = new Group();
					String str = in.nextLine();
					StringTokenizer st = new StringTokenizer(str);
					while (st.hasMoreElements())
					{
					Student tmpStudent = new Student();
					tmpStudent.setFirstName(st.nextToken());
					tmpStudent.setLastName(st.nextToken());
					tmpStudent.setGender(st.nextToken());

					tempList.addStudent(tmpStudent);
					}

					lastGroup.addGroup(tempList);
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if (in != null)
					in.close();
			}
		}

		GroupList newGroup = this.CreateGroupList(studentList, lastGroup);
		return newGroup;

	}

	/**
	 * This method will create the list of lab groups. It will determine the
	 * number of students in each group, the number of groups, the number of
	 * females per group, the number of males per group, and then will create
	 * the groups by checking the last lab group the student was in.
	 * 
	 * @param studentList  list of all students in class
	 * @param lastGroup   list of lab groups from last time
	 * @return   list of lab groups
	 */
	
	public GroupList CreateGroupList(Group studentList, GroupList lastGroup)
	{
		// initialize oldIndex to -1 since that is what is returned if the
		// student is not found
		int oldIndex = -1;
		// the numTries contains how many groups we have tried to add the
		// student to
		// once we have tried every group, we want to go ahead and add the group
		// to the last one where it will be below the limits

		int numTries = 0;
		boolean studentInGroup, studentAdded = false;
		GroupList groups = new GroupList();

		Random rand = new Random();
		/* ********************************************************************* */
		/* figure the total number of groups if the user selected the option to */
		/* specify the number in each group */
		/*                                                                       */
		/* ********************************************************************* */
		if (this.numGroups == 0 && this.groupSize != 0)
			this.calcNumGroups(this.groupSize, studentList.getGroupSize());

		/* ********************************************************************* */
		/* figure the total size of each group if the user specified the total */
		/* number of groups */
		/*                                                                       */
		/* ********************************************************************* */

		if (this.groupSize == 0 && this.numGroups != 0)
			this.calcGroupSize(this.numGroups, studentList.getGroupSize());

		/* ********************************************************************* */
		/* create a group for each bucket of the groupList ArrayList */
		/*                                                                       */
		/* ********************************************************************* */

		for (int j = 0; j < this.numGroups; j++)
		{
			Group tmpGroup = new Group();
			groups.addGroup(tmpGroup);
		}

		/* ********************************************************************* */
		/* now that we have group size figured out, set the limits based */
		/* on the gender mix of the main student list. These limits will be */
		/* rounded up any time the number of students is not evenly divisible */
		/* by the number of groups. */
		/* ********************************************************************* */

		this.setGenderLimits(studentList);

		// loop through all Student objects in the studentList
		// studentList contains all the students in the lab class

		for (int i = 0; i < studentList.getGroupSize(); i++)
		{
			// initialize student added for each student from the list
			studentAdded = false;

			/*
			 * loop through groups until we find one that we can add the student
			 * to if we try all groups, and still have not found one where the
			 * student has not existed with at least one other student, then we
			 * will just add them to the next group where they do not put the
			 * group over the individual limits.
			 */

			while (!studentAdded)
			{
				// generate random number for index of group to try adding
				// student
				int newIndex = rand.nextInt(numGroups);
				
				numTries++;
				
				// find which labGroup the student was in the last time
				if (lastGroup != null)
					oldIndex = lastGroup.findStudent(studentList.getStudent(i));

				studentInGroup = false;
				studentAdded = false;

				// if oldIndex is -1, that means the specified student was not
				// in any labGroup last time
				if (oldIndex == -1)
					studentInGroup = false;
				else
				{
					for (int j = 0; j < lastGroup.getGroup(oldIndex)
							.getGroupSize(); j++)
					{

						if (groups.getGroup(newIndex).containsStudent(
								lastGroup.getGroup(oldIndex).getStudent(j)))
							studentInGroup = true;
					}
				}
				if ((!studentInGroup | numTries >= this.numGroups)
						&& correctNumbers(groups.getGroup(newIndex),
								studentList.getStudent(i)))
				{
					studentAdded = true;
					numTries = 0;
					groups.getGroup(newIndex).addStudent(
							studentList.getStudent(i));
				}
			}

		}
		return groups;
	}
/**
 *  This method will set limits for how many students of each gender belong in each 
 *  group. If the groups do not require a mixture based on gender, then the limits 
 *  for each group will be set to the maximum number of students for that group.
 *  
 * @param studentList  list of all students
 */
	public void setGenderLimits(Group studentList)
	{
		if (genderBiased)
		{
			int totalFemales = 0;
			// loop through all Student objects in the studentList.
			// and count how many total females there are.
			for (int i = 0; i < studentList.getGroupSize(); i++)
			{
				if (studentList.getStudent(i).getGender() == "F")
					totalFemales++;
			}
			// once we know how many total females there are, then we will
			// divide that
			// number by the total number of groups.

			if (totalFemales % numGroups == 0)
			{
				this.numFemales = totalFemales / numGroups;
				this.numMales = groupSize - this.numFemales;
			} else
			{
				this.numFemales = (totalFemales / numGroups) + 1;
				this.numMales = groupSize - this.numFemales + 1;
			}
		} else
		{
			this.numFemales = this.groupSize;
			this.numMales = this.groupSize;
		}

	}

	/**
	 * This method will determine if it is OK to add a student to a group.
	 * 
	 * @param grp Group to which we would like to add student. 
	 * @param stu1 Student object which needs to be added. 
	 * 
	 * @return  true if adding the student will not break any of the
	 * allowed limits on the group. 
	 */
	public boolean correctNumbers(Group grp, Student stu1)
	{
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
	public void calcNumGroups(int groupSize, int fullGroupSize)
	{
		if (groupSize != 0)
		{
			if (fullGroupSize % groupSize == 0)
				this.numGroups = fullGroupSize / groupSize;
			else
			{
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
	public void setNumGroups(int numGroups)
	{
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
	public void setGroupSize(int groupSize)
	{
		this.numGroups = 0;
		this.groupSize = groupSize;
	}

	/**
	 * Getter for the number of females per group.
	 * 
	 * @return integer to indicate how many females belong in each group
	 */
	public int getNumFemales()
	{
		return this.numFemales;
	}

	/**
	 * Getter for the number of males per group.
	 * 
	 * @return integer to indicate how many males belong in each group
	 */
	public int getNumMales()
	{
		return this.numMales;
	}

	/**
	 * Getter for the number of students per group.
	 * 
	 * @return integer to indicate how many students belong in each group
	 */
	public int getGroupSize()
	{
		return this.groupSize;
	}

	/**
	 * Getter for the number of groups.
	 * 
	 * @return integer to indicate how many lab groups will be created.
	 */
	public int getNumGroups()
	{
		return this.numGroups;
	}

	/**
	 * Getter for indicator to make sure each group has an equal distribution of
	 * males and females.
	 * 
	 * @return
	 */
	public boolean getBiased()
	{
		return this.genderBiased;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setBiased(boolean gender)
	{
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
	public void calcGroupSize(int numGroups, int fullGroupSize)
	{
		if (numGroups != 0)
		{
			if (fullGroupSize % numGroups == 0)
			{
				this.groupSize = fullGroupSize / numGroups;
			} else
			{
				this.groupSize = (fullGroupSize / numGroups) + 1;
			}
		}
	}

}
