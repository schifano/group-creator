/*
 * Filename: GroupListTest.java
 * Oct 7, 2013
 * 
 * ULID: jdboomg
 * Course: IT168
 * Section: 4
 * Instructor: Dr. Califf
 */
package edu.ilstu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author John Boomgarden
 *
 * This class will test the GroupList class
 *
 */
public class GroupListTest {

	private GroupList grpList; 
	private Group grp1;
	private Group grp2;
	private Group grp3;
	
	private Student stu1;
	private Student stu2;
	private Student stu3;
	private Student stu4;
	private Student stu5;
	private Student stu6;
	private Student stu7;
	private Student stu8;
	private Student stu9;
	
	@Before
	public void setup() throws Exception
	{
		grpList = new GroupList();
		grp1 = new Group();
		stu1 = new Student();
		stu1.setFirstName("John");
		stu1.setLastName("Boomgarden");
		stu1.setGender("M");
		grp1.addStudent(stu1);
		
		stu2 = new Student();
		stu2.setFirstName("Corbin");
		stu2.setLastName("Sumner");
		stu2.setGender("M");
		grp1.addStudent(stu2);
		
		stu3 = new Student();
		stu3.setFirstName("Rachel");
		stu3.setLastName("Schifano");
		stu3.setGender("F");
		grp1.addStudent(stu3);
		
		grp2 = new Group();
		stu4 = new Student();
		stu4.setFirstName("Jim");
		stu4.setLastName("Smith");
		stu4.setGender("M");
		grp2.addStudent(stu4);
		
		stu5 = new Student();
		stu5.setFirstName("Jennifer");
		stu5.setLastName("Garner");
		stu5.setGender("F");
		grp2.addStudent(stu5);
		
		stu6 = new Student();
		stu6.setFirstName("Sarah");
		stu6.setLastName("Butler");
		stu6.setGender("F");
		grp2.addStudent(stu6);
		
		grp3 = new Group();
		stu7 = new Student();
		stu7.setFirstName("Woody");
		stu7.setLastName("Woodpecker");
		stu7.setGender("F");
		grp3.addStudent(stu7);
		
		stu8 = new Student();
		stu8.setFirstName("Spider");
		stu8.setLastName("Man");
		stu8.setGender("M");
		grp3.addStudent(stu8);
		
		stu9 = new Student();
		stu9.setFirstName("Dora");
		stu9.setLastName("The Explorer");
		stu9.setGender("F");
		grp3.addStudent(stu9);
		
		
	}
	/**
	 * Test method for {@link edu.ilstu.GroupList#addGroup(edu.ilstu.Group)}.
	 */
	@Test
	public void testAddGroup() 
	{
		grpList.addGroup(grp1);
		assertEquals("size of groupList of 1", 1, grpList.getNumGroups());
		grpList.addGroup(grp2);
		assertEquals("size of groupList of 2", 2, grpList.getNumGroups());
		grpList.addGroup(grp3);
		assertEquals("size of groupList of 3", 3, grpList.getNumGroups());
	}


	/**
	 * Test method for {@link edu.ilstu.GroupList#findStudent(edu.ilstu.Student)}.
	 */
	@Test
	public void testFindStudent() 
	{
		grpList.addGroup(grp1);
		grpList.addGroup(grp2);
		grpList.addGroup(grp3);
		assertEquals("find student in first group", 0, grpList.findStudent(stu1));
		assertEquals("find student in second group", 1, grpList.findStudent(stu4));
		assertEquals("find student in third group", 2, grpList.findStudent(stu7));
		assertEquals("find student in first group", 0, grpList.findStudent(stu2));
		assertEquals("find student in second group", 1, grpList.findStudent(stu5));
		assertEquals("find student in third group", 2, grpList.findStudent(stu8));
		assertEquals("find student in first group", 0, grpList.findStudent(stu1));
		assertEquals("find student in second group", 1, grpList.findStudent(stu4));
		assertEquals("find student in third group", 2, grpList.findStudent(stu7));
		assertEquals("find student in first group", 0, grpList.findStudent(stu3));
		assertEquals("find student in second group", 1, grpList.findStudent(stu6));
		assertEquals("find student in third group", 2, grpList.findStudent(stu9));
		assertEquals("find student in first group", 0, grpList.findStudent("John","Boomgarden"));
		assertEquals("can't find student any group", -1, grpList.findStudent("Jim","Boomgarden"));
	}

}
