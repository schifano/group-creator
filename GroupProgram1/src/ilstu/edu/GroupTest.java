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
	 * Test method for {@link edu.ilstu.Group#addStudent(edu.ilstu.Student)}.
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
		stu2.setLastName("Summer");
		stu2.setGender("M");
		grp1.addStudent(stu2);
		
		Student stu3 = new Student();
		stu3.setFirstName("Rachel");
		stu3.setLastName("Schifano");
		stu3.setGender("F");
		grp1.addStudent(stu3);
	}
	
	/**
	 * Test method for {@link edu.ilstu.Group#getGroupSize()}.
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
		System.out.println("about to call remove student");
		assertEquals("Check for student that now exists", true,grp1.removeStudent(stu5));
		assertEquals("size of group of 4", 4, grp1.getGroupSize());
	}

	/**
	 * Test method for {@link edu.ilstu.Group#containsStudent(edu.ilstu.Student)}.
	 */
	@Test
	public void testContainsStudent() 
	{
	/*	Student stu5 = new Student();
		stu5.setFirstName("Walter");
		stu5.setLastName("White");
		stu5.setGender("M");
		assertEquals("Check to see if student exists", true,grp1.containsStudent(stu5));
		
		Student stu6 = new Student();
		stu5.setFirstName("Jim");
		stu5.setLastName("Smith");
		stu5.setGender("M");
		assertEquals("Check to see if student exists", false,grp1.containsStudent(stu6));
		
		Student stu1 = new Student();
		stu1.setFirstName("John");
		stu1.setLastName("Boomgarden");
		stu1.setGender("M");
		assertEquals("Check to see if student exists", true,grp1.containsStudent(stu1));
		
		if (grp1.removeStudent(stu1))
		{
		assertEquals("Check to see if student exists after removal", false,grp1.containsStudent(stu1));
		assertEquals("Check to see if another student exists after removal", true,grp1.containsStudent(stu5));
		}
		if (grp1.removeStudent(stu5))
		{
			assertEquals("Check to ensure no iterator exception", false,grp1.containsStudent(stu5));
			assertEquals("Check to see if another student exists after removal", false,grp1.containsStudent(stu6));
		}*/
	}

	/**
	 * Test method for {@link edu.ilstu.Group#getNumberFemalesInGroup()}.
	 */
	@Test
	public void testGetNumberFemalesInGroup() {/*
		assertEquals("check female count", 1,grp1.getNumberFemalesInGroup());
		Student stu1 = new Student();
		stu1.setFirstName("Tonya");
		stu1.setLastName("Boomgarden");
		stu1.setGender("F");*/
		}

	/**
	 * Test method for {@link edu.ilstu.Group#getNumberMalesInGroup()}.
	 */
	@Test
	public void testGetNumberMalesInGroup() {
		;
	}

}
