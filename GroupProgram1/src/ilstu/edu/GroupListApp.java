/*
 * Filename: GroupListApp.java
 * Oct 2, 2013
 * 
 * ULID: jdboomg
 * Course: IT168
 * Section: 4
 * Instructor: Dr. Califf
 */
import java.util.Random;
/**
 * @author John Boomgarden
 *
 * <insert description >
 *
 */
public class GroupListApp 
{
	private int numGroups;
	private Group[] groups;
	/**
	 * 
	 */
	public GroupListApp() 
	{
		// 
	}
	public void CreateGroupList()
	 {
		int oldIndex = 0;
		int tempIndex = 0;
		boolean matching = false;
		groups[] = new Group[numGroups];
		
		Random rand = new Random();
	// begin by loopinig through all Student objects
		for (int i = 0; i < studentList.size(); i ++)
		{
			//generate random number to try that group
			int newIndex = rand.nextInt(numGroups);
			tempStudent[] = groups[newIndex].getCurrentStudent(); 
			if(tempStudent[] == null)
				groups[newIndex].addstudent(studentList[i]);
			else
			{
				oldIndex = lastGroup.searchForStudent(studentList[i]);
				matching = false;
				for(int j=0; j<tempStudent.size();j++)
				{
					tempIndex = lastGroup.searchForStudent(tempStudent[j]);
					if (tempIndex = oldIndex)
						matching = true;
				}
				if(! matching)
					groups[newIndex].addStudent(studentList[i]);
					
			}
				
		}
	}

}
