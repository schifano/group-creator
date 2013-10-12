/*
 * Filename: GroupListAppTest.java
 * Oct 8, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
package edu.ilstu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author John Boomgarden
 *
 * Test class for GroupListApp
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
	private GroupList grpList;
	
	@Before
	public void setup() throws Exception
	{
	testApp = new GroupListApp();	
	
		grpList = new GroupList();
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
	
	// now that we have the numbers all set check them against what they should be
	assertEquals("Check gender biased",false,testApp.getBiased());
	assertEquals("check limits before running", 5, testApp.getNumFemales());
	assertEquals("check limits before running", 5, testApp.getNumMales());
	testApp.setBiased(true);
	assertEquals("Check gender biased",true,testApp.getBiased());
	
	// now we need to figure out how many groups we will be creating based on the having 5 Students per group
	testApp.calcNumGroups(5, 28);
	testApp.setGenderLimits(grp1);
	
	// now that gender biasing is on, we should have 3 males per group and 3 females per group
	assertEquals("check limits before running", 3, testApp.getNumFemales());
	assertEquals("check limits before running", 3, testApp.getNumMales());
	
	// create a new student, and add him to large group which is WAY over the limits, since it 
	// is actually the main student list
	Student stu1 = new Student();
	stu1.setFirstName("Jim");
	stu1.setLastName("Hovey");
	stu1.setGender("M");
	assertEquals("add student to already full group", false, testApp.correctNumbers(grp1, stu1));
	
	// try different students to test limits of group counters
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
		assertEquals("Check calc num groups",5,testApp.getGroupSize());
	}

	/**
	 * Test method for {@link edu.ilstu.GroupListApp#setNumGroups(int)}.
	 */
	@Test
	public void testCalcGroupSize() 
	{
		GroupList grpList2 = new GroupList();
		testApp.setBiased(false);
		testApp.setGroupSize(5);
		testApp.calcNumGroups(5, 28);
		assertEquals("Check calc num groups",6,testApp.getNumGroups());
		
		System.out.println("1st groupList");
		grpList = testApp.CreateGroupList(grp1,null);
		System.out.println(grpList.toString());
		
		System.out.println("2nd grouplist, uses first group as lastGroup");
		grpList2 = testApp.CreateGroupList(grp1,grpList);
		System.out.println(grpList2);
		
		System.out.println("3rd grouplist, uses first group as lastGroup again");		
		grpList2 = testApp.CreateGroupList(grp1,grpList);
		System.out.println(grpList2);
		
		System.out.println("4th grouplist, uses 2nd group as lastGroup");
		grpList = testApp.CreateGroupList(grp1,grpList2);
		System.out.println(grpList2);
		
		System.out.println("5th grouplist, uses 4th group as lastGroup");		
		grpList2 = testApp.CreateGroupList(grp1,grpList);
		System.out.println(grpList2);
		
		testApp.setBiased(true);
		testApp.setGenderLimits(grp1);
		System.out.println("6th grouplist, uses 5th group as lastGroup with gender biasing");		
		grpList = testApp.CreateGroupList(grp1,grpList2);
		System.out.println(grpList2);
		
	
		System.out.println("7th grouplist, uses 6th group as lastGroup with gender biasing");		
		grpList2 = testApp.CreateGroupList(grp1,grpList);
		System.out.println(grpList2);
		
		/* *********************************************************************************/
		/*       create a group with 28 students, 7 of which are female, then turn on      */
		/*       the option to have equal gender mixing, so each group in the final        */  
	    /*      group list will have one female                                            */
		/* *********************************************************************************/
		grp1 = this.createFemaleGroup();
		testApp.setBiased(true);
		testApp.setGroupSize(4);
		testApp.calcNumGroups(4, 28);
		testApp.setGenderLimits(grp1);
		assertEquals("Check calc num groups",7,testApp.getNumGroups());
		
		System.out.println("8th grouplist, uses new students, but lastGroup from step above");
		grpList = testApp.CreateGroupList(grp1,grpList2);
		System.out.println(grpList);
		
		testApp.setBiased(false);
		testApp.setGenderLimits(grp1);
		System.out.println("9th grouplist, uses lastGroup from step above with no gender mix");
		grpList = testApp.CreateGroupList(grp1,grpList2);
		System.out.println(grpList);
	}

	
public Group createFemaleGroup()
{
	// the first 7 students will be females, the rest will be males
	grp1 = new Group();
	stu1 = new Student();
	stu1.setFirstName("Stella");
	stu1.setLastName("Boomgarden");
	stu1.setGender("F");
	grp1.addStudent(stu1);
	
	stu2 = new Student();
	stu2.setFirstName("Shirley");
	stu2.setLastName("Sumner");
	stu2.setGender("F");
	grp1.addStudent(stu2);
	
	stu3 = new Student();
	stu3.setFirstName("Rachel");
	stu3.setLastName("Schifano");
	stu3.setGender("F");
	grp1.addStudent(stu3);
	
	stu4 = new Student();
	stu4.setFirstName("Kim");
	stu4.setLastName("Smith");
	stu4.setGender("F");
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
	stuC.setFirstName("John");
	stuC.setLastName("Fort");
	stuC.setGender("M");
	grp1.addStudent(stuC);
	
	stuD = new Student();
	stuD.setFirstName("Tim");
	stuD.setLastName("Johnson");
	stuD.setGender("M");
	grp1.addStudent(stuD);
	
	stuE = new Student();
	stuE.setFirstName("Corbin");
	stuE.setLastName("Hernandez");
	stuE.setGender("M");
	grp1.addStudent(stuE);
	
	stuF = new Student();
	stuF.setFirstName("Ken");
	stuF.setLastName("Loughran");
	stuF.setGender("M");
	grp1.addStudent(stuF);
	
	stuG = new Student();
	stuG.setFirstName("Thomas");
	stuG.setLastName("Johnson");
	stuG.setGender("M");
	grp1.addStudent(stuG);
	
	stuH = new Student();
	stuH.setFirstName("Stephen");
	stuH.setLastName("Hodges");
	stuH.setGender("M");
	grp1.addStudent(stuH);
	
	stuI = new Student();
	stuI.setFirstName("Dana");
	stuI.setLastName("Gonvales");
	stuI.setGender("M");
	grp1.addStudent(stuI);
	
	stuJ = new Student();
	stuJ.setFirstName("Chris");
	stuJ.setLastName("Menzies");
	stuJ.setGender("M");
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
	stuM.setFirstName("Junior");
	stuM.setLastName("Magoo");
	stuM.setGender("M");
	grp1.addStudent(stuM);
	
	stuN = new Student();
	stuN.setFirstName("Stephen");
	stuN.setLastName("Rice");
	stuN.setGender("M");
	grp1.addStudent(stuN);
	
	stuO = new Student();
	stuO.setFirstName("Lynne");
	stuO.setLastName("Wille");
	stuO.setGender("M");
	grp1.addStudent(stuO);
	
	stuP = new Student();
	stuP.setFirstName("Mike");
	stuP.setLastName("Klachko");
	stuP.setGender("M");
	grp1.addStudent(stuP);
	
	stuQ = new Student();
	stuQ.setFirstName("Stu");
	stuQ.setLastName("Smith");
	stuQ.setGender("M");
	grp1.addStudent(stuQ);
	
	stuR = new Student();
	stuR.setFirstName("Jared");
	stuR.setLastName("Thompson");
	stuR.setGender("M");
	grp1.addStudent(stuR);
	
	stuS = new Student();
	stuS.setFirstName("Tom");
	stuS.setLastName("Jones");
	stuS.setGender("M");
	grp1.addStudent(stuS);	
	
	return grp1;
}


}
