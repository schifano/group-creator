/*
 * Filename: GroupTest.java
 * Oct 6, 2013
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
 * This will test the Group class. 
 *
 */
public class GroupTest {
	private Group grp1;

	/**
	 * Test method for {@link edu.ilstu.temp.Group#addStudent(edu.edu.ilstu.edu.ilstu.Student)}.
	 */
	@Before
	public void setup() throws Exception
	{
		grp1 = new Group();
		Student stu1 = new Student();
		stu1.setFirstName("John");
		stu1.setLastName("Boomgarden");
		stu1.setGender("M");
		grp1.addStudent(stu1);
		
		Student stu2 = new Student();
		stu2.setFirstName("Corbin");
		stu2.setLastName("Sumner");
		stu2.setGender("M");
		grp1.addStudent(stu2);
		
		Student stu3 = new Student();
		stu3.setFirstName("Rachel");
		stu3.setLastName("Schifano");
		stu3.setGender("F");
		grp1.addStudent(stu3);
	}
	
	/**
	 * Test method for {@link edu.ilstu.temp.Group#getGroupSize()}.
	 */
	@Test
	public void testGetGroupSize() 
	{
		assertEquals("size of group of 3", 3, grp1.getGroupSize());
		Student stu4 = new Student();
		stu4.setFirstName("Jesse");
		stu4.setLastName("Pinkman");
		stu4.setGender("M");
		grp1.addStudent(stu4);
		assertEquals("size of group of 4", 4, grp1.getGroupSize());
		
		Student stu5 = new Student();
		stu5.setFirstName("Walter");
		stu5.setLastName("White");
		stu5.setGender("M");
		assertEquals("size of group of 4", 4, grp1.getGroupSize());
		assertEquals("Check for student that doesn't exist", false,grp1.removeStudent(stu5));
		grp1.addStudent(stu5);
		assertEquals("size of group of 5", 5, grp1.getGroupSize());
		assertEquals("Check for student that now exists", true,grp1.removeStudent(stu5));
		assertEquals("size of group of 4", 4, grp1.getGroupSize());
	}
	
	@Test
	public void testStudent() 
	{	
		assertEquals("check to see if we can get first name", "John", grp1.getStudent(0).getFirstName());
		assertEquals("check to see if we can get last name", "Sumner", grp1.getStudent(1).getLastName());
		assertEquals("check to see if we can get gender", "F", grp1.getStudent(2).getGender());

	}

	/**
	 * Test method for {@link edu.ilstu.temp.Group#containsStudent(edu.edu.ilstu.edu.ilstu.Student)}.
	 */
	@Test
	public void testContainsStudent() 
	{
		Student stu5 = new Student();
		stu5.setFirstName("Walter");
		stu5.setLastName("White");
		stu5.setGender("M");
		grp1.addStudent(stu5);
	 	assertEquals("Check to see if student exists 1 ", true,grp1.containsStudent(stu5));
		
		Student stu6 = new Student();
		stu6.setFirstName("Jim");
		stu6.setLastName("Smith");
		stu6.setGender("M");
		assertEquals("Check to see if student exists 2 ", false,grp1.containsStudent(stu6));
		grp1.addStudent(stu6);
			
		Student stu1 = new Student();
		stu1.setFirstName("John");
		stu1.setLastName("Boomgarden");
		stu1.setGender("M");
		assertEquals("Check to see if student exists", true,grp1.containsStudent(stu1));
		
		if (grp1.removeStudent(stu1))
		{
		assertEquals("Check to see if student exists after removal ", false,grp1.containsStudent(stu1));
		assertEquals("Check to see if another student exists after removal ", true,grp1.containsStudent(stu5));
		}
		else
		{
			assertEquals("This should not get hit 1 ", false,grp1.containsStudent(stu1));
			assertEquals("This should not get hit 2 ", true,grp1.containsStudent(stu5));	
		}
		if (grp1.removeStudent(stu5))
		{
			assertEquals("Try to remove after already removed ", false,grp1.containsStudent(stu5));
			assertEquals("Check to see if another student exists after removal 1 ", true,grp1.containsStudent(stu6));
		}
		else
		{
			assertEquals("This should not get hit 3 ", true,grp1.containsStudent(stu5));
		}
		if (grp1.removeStudent("Jim", "Smith"))
		{
			assertEquals("Check removal by name", false,grp1.containsStudent("Jim","Smith"));
			assertEquals("Check to see if another student exists after removal 2", true,grp1.containsStudent("Corbin","Sumner"));
		}
		else
		{
			assertEquals("This should not get hit 4 ", true,grp1.containsStudent(stu5));
		}
		 
	}

	/**
	 * Test method for {@link edu.ilstu.temp.Group#getNumberFemalesInGroup()}.
	 */
	@Test
	public void testGetNumberFemalesInGroup() {
		assertEquals("check female count", 1,grp1.getNumberFemalesInGroup());
		grp1.addStudent("Mr","Magoo","M");
		grp1.addStudent("Mrs","Magoo","F");
		assertEquals("check female count", 2,grp1.getNumberFemalesInGroup());
		}

	/**
	 * Test method for {@link edu.ilstu.temp.Group#getNumberMalesInGroup()}.
	 */
	@Test
	public void testGetNumberMalesInGroup() {
		assertEquals("check male count", 2,grp1.getNumberMalesInGroup());
		grp1.addStudent("Mr","Magoo","M");
		grp1.addStudent("Mrs","Magoo","F");
		assertEquals("check male count", 3,grp1.getNumberMalesInGroup());
		grp1.removeStudent("Mr","Magoo");
		assertEquals("check male count", 2,grp1.getNumberMalesInGroup());
	}

}
