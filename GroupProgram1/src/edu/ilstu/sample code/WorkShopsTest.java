/*
 * Filename: WorkShopsTest.java
 * Sep 25, 2013
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
 * This will test the get workshops cost calculations. 
 *
 */
public class WorkShopsTest {
	WorkShops wslist;

	@Before
	public void setup() throws Exception {
		wslist = new WorkShops();
	}

	/**
	 * Test method for {@link edu.ilstu.WorkShops#getWorkshopsCost()}.
	 */
	@Test
	public void testGetWorkshopsCost() {
		// no indicators turned on should return 0
		assertEquals("no indicators", 0, wslist.getWorkshopsCost());
		
		// 1st indicator turned on should return 29500
		wslist.setWorkshopsIndicator(0, true);
		assertEquals("1st indicator", 29500, wslist.getWorkshopsCost());
	
		// 2nd indicator turned on should return 29500
		wslist.setWorkshopsIndicator(0, false);
		wslist.setWorkshopsIndicator(1, true);
		assertEquals("2nd indicator", 29500, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(1, false);
		
		// 3rd indicator turned on should return 39500
		wslist.setWorkshopsIndicator(2, true);
		assertEquals("3rd indicator", 39500, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(2, false);
		
		// 4th indicator turned on should return 39500
		wslist.setWorkshopsIndicator(3, true);
		assertEquals("4th indicator", 39500, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(3, false);
		
		// 1st and 2nd indicators turned on should return 59000
		wslist.setWorkshopsIndicator(0, true);
		wslist.setWorkshopsIndicator(1, true);
		assertEquals("1st and 2nd indicator ", 59000, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(0, false);
		wslist.setWorkshopsIndicator(1, false);
		
		// 2nd and 3rd indicators turned on should return 69000
		wslist.setWorkshopsIndicator(1, true);
		wslist.setWorkshopsIndicator(2, true);
		assertEquals("2nd and 3rd indicator", 69000, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(1, false);
		wslist.setWorkshopsIndicator(2, false);
		
		// 3rd and 4th indicators turned on should return 79000
		wslist.setWorkshopsIndicator(2, true);
		wslist.setWorkshopsIndicator(3, true);
		assertEquals("3rd and 4th indicator", 79000, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(2, false);
		wslist.setWorkshopsIndicator(3, false);
		
		// 1st and 3rd indicators turned on should return 69000
		wslist.setWorkshopsIndicator(0, true);
		wslist.setWorkshopsIndicator(2, true);
		assertEquals("1st and 3rd indicator", 69000, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(0, false);
		wslist.setWorkshopsIndicator(2, false);
		
		// 1st and 4th indicators turned on should return 69000
		wslist.setWorkshopsIndicator(0, true);
		wslist.setWorkshopsIndicator(3, true);
		assertEquals("1st and 4th indicator", 69000, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(0, false);
		wslist.setWorkshopsIndicator(3, false);	
		
		// 2nd and 4th indicators turned on should return 69000
		wslist.setWorkshopsIndicator(1, true);
		wslist.setWorkshopsIndicator(3, true);
		assertEquals("1st and 3rd indicator", 69000, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(1, false);
		wslist.setWorkshopsIndicator(3, false);
		
		// 1st 2nd and 3rd indicators turned on should return 98500
		wslist.setWorkshopsIndicator(0, true);
		wslist.setWorkshopsIndicator(1, true);
		wslist.setWorkshopsIndicator(2, true);
		assertEquals("1st 2nd and 3rd indicator", 98500, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(0, false);
		wslist.setWorkshopsIndicator(1, false);
		wslist.setWorkshopsIndicator(2, false);
		
		// 1st 3rd and 4th indicators turned on should return 108500
		wslist.setWorkshopsIndicator(0, true);
		wslist.setWorkshopsIndicator(2, true);
		wslist.setWorkshopsIndicator(3, true);
		assertEquals("1st 3rd and 4th indicator", 108500, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(0, false);
		wslist.setWorkshopsIndicator(2, false);
		wslist.setWorkshopsIndicator(3, false);
	
		// 2nd 3rd and 4th indicators turned on should return 108500
		wslist.setWorkshopsIndicator(1, true);
		wslist.setWorkshopsIndicator(2, true);
		wslist.setWorkshopsIndicator(3, true);
		assertEquals("2nd 3rd and 4th indicator", 108500, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(1, false);
		wslist.setWorkshopsIndicator(2, false);
		wslist.setWorkshopsIndicator(3, false);
		
		// 1st 2nd 3rd and 4th indicators turned on should return 138000
		wslist.setWorkshopsIndicator(0, true);
		wslist.setWorkshopsIndicator(1, true);
		wslist.setWorkshopsIndicator(2, true);
		wslist.setWorkshopsIndicator(3, true);
		assertEquals("2nd 3rd and 4th indicator", 138000, wslist.getWorkshopsCost());
		wslist.setWorkshopsIndicator(0, false);
		wslist.setWorkshopsIndicator(1, false);
		wslist.setWorkshopsIndicator(2, false);
		wslist.setWorkshopsIndicator(3, false);
		
	}

}
