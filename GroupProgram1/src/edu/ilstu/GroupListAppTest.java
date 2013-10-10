/*
 * Filename: GroupListAppTest.java
 * Oct 8, 2013
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
 * <insert description >
 *
 */
public class GroupListAppTest 
{
	private GroupListApp testApp;
	private Student stu1;
	private Student stu2;
	private Student stu3;
	private Student stu4;
	private Student stu5;
	private Student stu6;
	private Student stu7;
	private Student stu8;
	private Student stu9;
	private Student stuA;
	private Student stuB;
	private Student stuC;
	private Student stuD;
	private Student stuE;
	private Student stuF;
	private Student stuG;
	private Student stuH;
	private Student stuI;
	private Student stuJ;
	private Student stuK;
	private Student stuL;
	private Student stuM;
	private Student stuN;
	private Student stuO;
	private Student stuP;
	private Student stuQ;
	private Student stuR;
	private Student stuS;
	private Group grp1;
	private Group grp2;
	
	@Before
	public void setup() throws Exception
	{
	testApp = new GroupListApp();	
	
		GroupList grpList = new GroupList();
		grp1 = new Group();
		grp2 = new Group();
		stu1 = new Student();
		stu1.setFirstName("John");
		stu1.setLastName("Boomgarden");
		stu1.setGender("M");
		grp1.addStudent(stu1);
		grp2.addStudent(stu1);
		
		stu2 = new Student();
		stu2.setFirstName("Corbin");
		stu2.setLastName("Sumner");
		stu2.setGender("M");
		grp1.addStudent(stu2);
		grp2.addStudent(stu2);
		
		stu3 = new Student();
		stu3.setFirstName("Rachel");
		stu3.setLastName("Schifano");
		stu3.setGender("F");
		grp1.addStudent(stu3);
		grp2.addStudent(stu3);
		
		stu4 = new Student();
		stu4.setFirstName("Jim");
		stu4.setLastName("Smith");
		stu4.setGender("M");
		grp1.addStudent(stu4);
	
		
		stu5 = new Student();
		stu5.setFirstName("Jennifer");
		stu5.setLastName("Garner");
		stu5.setGender("F");
		grp1.addStudent(stu5);
		
		stu6 = new Student();
		stu6.setFirstName("Sarah");
		stu6.setLastName("Butler");
		stu6.setGender("F");
		grp1.addStudent(stu6);
		
		stu7 = new Student();
		stu7.setFirstName("Woody");
		stu7.setLastName("Woodpecker");
		stu7.setGender("F");
		grp1.addStudent(stu7);
		
		stu8 = new Student();
		stu8.setFirstName("Glenn");
		stu8.setLastName("Baker");
		stu8.setGender("M");
		grp1.addStudent(stu8);
		
		stu9 = new Student();
		stu9.setFirstName("Thomas");
		stu9.setLastName("Burrough");
		stu9.setGender("M");
		grp1.addStudent(stu9);
		
		stuA = new Student();
		stuA.setFirstName("Carlos");
		stuA.setLastName("Travis");
		stuA.setGender("M");
		grp1.addStudent(stuA);
		
		stuB = new Student();
		stuB.setFirstName("Larry");
		stuB.setLastName("Scheele");
		stuB.setGender("M");
		grp1.addStudent(stuB);
		
		stuC = new Student();
		stuC.setFirstName("Donna");
		stuC.setLastName("Fort");
		stuC.setGender("F");
		grp1.addStudent(stuC);
		
		stuD = new Student();
		stuD.setFirstName("Madelyn");
		stuD.setLastName("Johnson");
		stuD.setGender("F");
		grp1.addStudent(stuD);
		
		stuE = new Student();
		stuE.setFirstName("Mary");
		stuE.setLastName("Hernandez");
		stuE.setGender("F");
		grp1.addStudent(stuE);
		
		stuF = new Student();
		stuF.setFirstName("Felicia");
		stuF.setLastName("Loughran");
		stuF.setGender("F");
		grp1.addStudent(stuF);
		
		stuG = new Student();
		stuG.setFirstName("Thomas");
		stuG.setLastName("Johnson");
		stuG.setGender("M");
		grp1.addStudent(stuG);
		
		stuH = new Student();
		stuH.setFirstName("Emelia");
		stuH.setLastName("Hodges");
		stuH.setGender("F");
		grp1.addStudent(stuH);
		
		stuI = new Student();
		stuI.setFirstName("Dana");
		stuI.setLastName("Gonvales");
		stuI.setGender("F");
		grp1.addStudent(stuI);
		
		stuJ = new Student();
		stuJ.setFirstName("Christina");
		stuJ.setLastName("Menzies");
		stuJ.setGender("F");
		grp1.addStudent(stuJ);
		
		stuK = new Student();
		stuK.setFirstName("Jiminez");
		stuK.setLastName("Guitierez");
		stuK.setGender("M");
		grp1.addStudent(stuK);
		
		stuL = new Student();
		stuL.setFirstName("Mr.");
		stuL.setLastName("Magoo");
		stuL.setGender("M");
		grp1.addStudent(stuL);

		stuM = new Student();
		stuM.setFirstName("Mrs.");
		stuM.setLastName("Magoo");
		stuM.setGender("F");
		grp1.addStudent(stuM);
		
		stuN = new Student();
		stuN.setFirstName("Stephen");
		stuN.setLastName("Rice");
		stuN.setGender("M");
		grp1.addStudent(stuN);
		
		stuO = new Student();
		stuO.setFirstName("Linda");
		stuO.setLastName("Wille");
		stuO.setGender("F");
		grp1.addStudent(stuO);
		
		stuP = new Student();
		stuP.setFirstName("Mike");
		stuP.setLastName("Klachko");
		stuP.setGender("M");
		grp1.addStudent(stuP);
		
		stuQ = new Student();
		stuQ.setFirstName("Sheri");
		stuQ.setLastName("Smith");
		stuQ.setGender("F");
		grp1.addStudent(stuQ);
		
		stuR = new Student();
		stuR.setFirstName("Julie");
		stuR.setLastName("Thompson");
		stuR.setGender("F");
		grp1.addStudent(stuR);
		
		stuS = new Student();
		stuS.setFirstName("Tom");
		stuS.setLastName("Jones");
		stuS.setGender("M");
		grp1.addStudent(stuS);	
	}

	/**
	 * Test method for {@link edu.ilstu.GroupListApp#correctNumbers(edu.ilstu.Group, edu.ilstu.Student)}.
	 */
	@Test
	public void testCorrectNumbers() 
	{
		
		// From the setup above, we have a group with 28 Students, 15 of which are female
	testApp.setGroupSize(5);
	testApp.setBiased(false);
	testApp.setGenderLimits(grp1);
	testApp.setGenderLimits(grp1);
	assertEquals("Check gender biased",false,testApp.getBiased());
	assertEquals("check limits before running", 5, testApp.getNumFemales());
	assertEquals("check limits before running", 5, testApp.getNumMales());
	testApp.setBiased(true);
	assertEquals("Check gender biased",true,testApp.getBiased());
	testApp.calcNumGroups(5, 28);
	testApp.setGenderLimits(grp1);
	assertEquals("check limits before running", 3, testApp.getNumFemales());
	assertEquals("check limits before running", 3, testApp.getNumMales());
	Student stu1 = new Student();
	stu1.setFirstName("Jim");
	stu1.setLastName("Hovey");
	stu1.setGender("M");
	assertEquals("add student to already full group", false, testApp.correctNumbers(grp1, stu1));
	assertEquals("add student to group with 1 less than max males ", true, testApp.correctNumbers(grp2, stu1));
	grp2.addStudent(stu1);
	assertEquals("add F to group ", true, testApp.correctNumbers(grp2, stu5));
	grp2.addStudent(stu5);
	assertEquals("add student to group with too many males ", false, testApp.correctNumbers(grp2, stuN));
	assertEquals("over max size ", false, testApp.correctNumbers(grp2, stuR));
	
	}

	/**
	 * Test method for {@link edu.ilstu.GroupListApp#calcNumGroups(int, int)}.
	 */
	@Test
	public void testCalcNumGroups() 
	{
		testApp.setGroupSize(5);
		testApp.calcNumGroups(5, 28);
		assertEquals("Check calc num groups",6,testApp.getNumGroups());
	}

	/**
	 * Test method for {@link edu.ilstu.GroupListApp#setNumGroups(int)}.
	 */
	@Test
	public void testCalcGroupSize() 
	{
		testApp.setGroupSize(5);
		testApp.calcGroupSize(5, 28);
		assertEquals("Check calc num groups",6,testApp.getGroupSize());
		testApp.CreateGroupList(grp1,null);
	}




}
