package edu.ilstu;

/*
 * Filename: Group.java
 * Oct 3, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.util.ArrayList;

/**
 * @author John Boomgarden, Rachel Schifano, Corbin Sumner
 * 
 *         This class contains an arrayList of Group Objects.
 * 
 */
public class GroupList
{
	private ArrayList<Group> groupList;

	/**
	 * Generic constructor which creates initialized array;
	 */
	public GroupList()
	{
		groupList = new ArrayList<Group>();

	}

	/**
	 * This method will add a Group object to the arrayList
	 */
	public void addGroup(Group grp1)
	{
		if (grp1 != null)
			groupList.add(grp1);
	}

	/**
	 * This method will return a Group at the specified index.
	 */
	public Group getGroup(int i)
	{
		if (i > -1 && i < groupList.size())
			return groupList.get(i);
		else
			return null;
	}

	/**
	 * This method will return the number of Groups contained in the ArrayList
	 * 
	 * @return number of Groups in the ArrayList
	 */
	public int getNumGroups()
	{
		int numGroups = 0;
		numGroups = groupList.size();
		return numGroups;
	}

	/**
	 * This method will return the index of the Group where a Student exists
	 * 
	 * @return index of Group where Student exists
	 */
	public int findStudent(Student stu1)
	{
		int numGroups, groupIndex = 0;
		int foundIndex = -1;
		numGroups = groupList.size();
		while (groupIndex < numGroups && foundIndex == -1)
		{
			if (groupList.get(groupIndex).containsStudent(stu1))
			{
				foundIndex = groupIndex;
			}
			groupIndex++;
		}
		return foundIndex;

	}

	/**
	 * This method will return the index of the Group where a Student exists
	 * without having to create a Student object first.
	 * 
	 * @return index of Group where Student exists
	 */
	public int findStudent(String firstName, String lastName)
	{
		Student tempStu = new Student();
		tempStu.setFirstName(firstName);
		tempStu.setLastName(lastName);
		return this.findStudent(tempStu);

	}

	public String toString()
	{
		String str1 = "";

		for (int i = 0; i < groupList.size(); i++)
		{
			str1 += "Group " + (i + 1) + "\n";
			str1 += groupList.get(i) + "\n";
		}
		return str1;
	}

}
