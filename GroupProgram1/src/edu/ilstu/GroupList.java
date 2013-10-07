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
 * This class contains an arrayList of Group Objects.
 *
 */
public class GroupList extends ArrayList <Group> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Group> groupList;
	/**
	 *   Generic constructor which creates initialized array;
	 */
	public GroupList() 
	{
		groupList = new ArrayList<Group>();
	
	}
	/**
	 *   This method will add a Group object to the arrayList
	 */
	public void addGroup(Group grp1)
	{
		groupList.add(grp1);
	}
	
	/**
	 *   This method will return the number of Groups contained in the ArrayList
	 *   @return number of Groups in the ArrayList
	 */
	public int numGroups()
	{
	 	int numGroups = 0;
	 	numGroups = groupList.size();
	 	return numGroups;
	}	
	
	/**
	 *   This method will return the index of the Group where a Student exists
	 *   @return index of Group where Student exists
	 */
	public int findStudent(Student stu1)
	{
	 	int numGroups = 0;
	 	numGroups = this.size();
	 	int groupIndex = 0;
	 	boolean found = false;
	 	while(groupIndex < numGroups && !found)
	 	{
	 		if (this.get(groupIndex).containsStudent(stu1))
	 			found = true;
	 	}
	 	if (found)
	 		return groupIndex;
	 	else
	 		return -1;
	}	
	

}
