/*
 * Filename: CreditCardListTest.java
 * Sep 24, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
package edu.ilstu;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author John Boomgarden
 * 
 *         This will test the CreditCardList validations.
 * 
 */
public class CreditCardListTest {
	CreditCardList cclist;

	@Before
	public void setup() throws Exception {
		cclist = new CreditCardList();
	}

	/**
	 * Test method for
	 * {@link edu.ilstu.CreditCardList#validMasterCard(java.lang.String)}.
	 */
	@Test
 	public void testValidVisa() {

		// no entry should return invalid
		assertEquals("no entry should return invalid", false, cclist.validVisa(null));
		
		// 13 digits should return valid
		assertEquals("13 digits should return valid", true, cclist.validVisa("4154154151519"));
		
		// 16 digits should return valid
		assertEquals("16 digits should return valid", true, cclist.validVisa("4054854154151515"));		
		
		// 14 digits should return invalid
		assertEquals("14 digits should return invalid", false, cclist.validVisa("41541544151515"));		
		
		// 15 digits should return invalid
		assertEquals("15 digits should return invalid", false, cclist.validVisa("415411544151515"));			

		// 12 digits should return invalid
		assertEquals("12 digits should return invalid", false, cclist.validVisa("415411544151"));		

		// 17 digits should return invalid
		assertEquals("17 digits should return invalid", false, cclist.validVisa("41541154415115415"));	

		// 1st digit of 5 should be invalid
		assertEquals("1st digit of 5 should be invalid", false, cclist.validVisa("5154854154151515"));		
	
		// 1st digit of 2 should be invalid
		assertEquals("1st digit of 2 should be invalid", false, cclist.validVisa("2154854154151515"));	
		
		// Alphabetic should return invalid
		assertEquals("Alphabetic should return invalid", false, cclist.validVisa("41548541541A1515"));
		
		// blank should return invalid
		assertEquals("Blank should return invalid", false, cclist.validVisa("415 8541541A1515"));
	}
 
	/**
	 * Test method for
	 * {@link edu.ilstu.CreditCardList#validMasterCard(java.lang.String)}.
	 */
	@Test
 	public void testValidMasterCard() {

		// no entry should return invalid
		assertEquals("Does not pass test", false, cclist.validMasterCard(null));

		// 16 digits should return valid
		assertEquals("16 digits should return true", true,
				cclist.validMasterCard("5111571576571575"));

		// 2nd digit of 2 should return valid
		assertEquals("2nd digit of 2 should return valid", true,
				cclist.validMasterCard("5211571571571575"));

		// 2nd digit of 3 should return valid
		assertEquals("Does not pass test", true,
				cclist.validMasterCard("5311571571571575"));

		// 2nd digit of 4 should return valid
		assertEquals("Does not pass test", true,
				cclist.validMasterCard("5411571571571575"));

		// 2nd digit of 2 should return valid
		assertEquals("Does not pass test", true,
				cclist.validMasterCard("5511571571571575"));

		// 2nd digit of 6 should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("5611571571571575"));

		// 2nd digit of 7 should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("5711571571571575"));

		// 2nd digit of 8 should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("5811571571571575"));

		// 2nd digit of 9 should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("5915177571571457"));

		// 15 digits should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("521515715715751"));

		// 17 digits should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("52151571571575115"));

		// 6 digits should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("521575"));

		// 20 digits should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("51151775715715754455"));

		// 1st digit of 4 should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("4115177571571575"));

		// alphabetic character should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("51715A1571571575"));

		// blank space should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("5215 1571571575"));

		// alphabetic character at the beginning should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("A115115715715758"));

		// alphabetic character at the end should return invalid
		assertEquals("Does not pass test", false,
				cclist.validMasterCard("511511571571547A"));
	}
 
	/**
	 * Test method for
	 * {@link edu.ilstu.CreditCardList#validAmericanExpress(java.lang.String)}.
	 */
	@Test
 	public void testValidAmericanExpress() {
		// no entry should return invalid
		assertEquals("no entry should return invalid", false,
				cclist.validAmericanExpress(null));

		// 15 digits should return valid
		assertEquals("15 digits should return valid ", true,
				cclist.validAmericanExpress("371571571571575"));

		// 14 digits should return invalid
		assertEquals("14 digits should return invalid ", false,
				cclist.validAmericanExpress("37151571571575"));

		// 16 digits should return invalid
		assertEquals("16 digits should return invalid ", false,
				cclist.validAmericanExpress("3715177571571575"));

		// 6 digits should return invalid
		assertEquals("6 digits should return invalid ", false,
				cclist.validAmericanExpress("371575"));

		// 20 digits should return invalid
		assertEquals("20 digits should return invalid ", false,
				cclist.validAmericanExpress("37151775715715754455"));

		// 1st digit of 2 should return invalid
		assertEquals("1st digit of 2 should return invalid ", false,
				cclist.validAmericanExpress("271517757157157"));

		// 2nd digit of 9 should return invalid
		assertEquals("2nd digit of 9 should return invalid ", false,
				cclist.validAmericanExpress("391517757157157"));

		// alphabetic character should return invalid
		assertEquals("Alphabetic character should return invalid", false,
				cclist.validAmericanExpress("3715A1571571575"));

		// blank space should return invalid
		assertEquals("blank space should return invalid ", false,
				cclist.validAmericanExpress("3715 1571571575"));

		// alphabetic character at the beginning should return invalid
		assertEquals("alphabetic character at the beginning should return invalid ", false,
				cclist.validAmericanExpress("A71511571571575"));

		// alphabetic character at the end should return invalid
		assertEquals("alphabetic character at the end should return invalid", false,
				cclist.validAmericanExpress("37151157157157A"));

	}
	@Test
	public void testValidCheckSum() {
		// no string should return false
	 	assertEquals("No string", false,
						cclist.validCheckSum(null, 10));
		
		// checksum of 0 should return false
		assertEquals("Checksum of 0 ", false,
						cclist.validCheckSum("484", 0));
		
 		// valid number should return true
		assertEquals("valid number ", true,
						cclist.validCheckSum("4512113014643252", 10));
		
	    // invalid number should return false
		assertEquals("Invalid Number ", false,
						cclist.validCheckSum("4512113014843252", 10));
		
		// change 1st digit should return false
		assertEquals("Changing 1st digit ", false,
						cclist.validCheckSum("5512113014643252", 10));
		
	 	// change 2nd digit should return false
		assertEquals("Changing 2nd digit ", false,
						cclist.validCheckSum("4712113014643252", 10)); 
 		// new valid number
		assertEquals("valid number ", true,
						cclist.validCheckSum("8512113", 10));
		// new valid number
		assertEquals("valid number ", true,
						cclist.validCheckSum("4844844844842", 10));
		
		// all 9s in the digits which will be doubled
		assertEquals("all 9s in the digits which will be doubled ", true,
				cclist.validCheckSum("8919193", 10));
		
	}

}
