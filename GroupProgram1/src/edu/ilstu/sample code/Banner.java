package edu.ilstu;
/*
 * Filename: Banner.java
 * Sep 14, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */

import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *  @author John Boomgarden
 *  
 * This class will create the head of the registration menu. It will create a
 * banner with a checkbox to indicate if the user is a student or not.
 * 
 */

public class Banner extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4719815553415896827L;
	
	
	/* The following constants are used to indicate
	  the cost of the basic registration.
	 This will be an integer value which represents the number of cents, not dollars.   */
	private final int BASIC_COST = 89500;
	private final int STUDENT_COST = 49500;

	private JCheckBox student; // checkbox to indicate if user is a student

	/**
	 * Constructor
	 */

	public Banner() {

		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String dollarAmt1, dollarAmt2;
		dollarAmt1 = fmt.format(BASIC_COST / 100);
		dollarAmt2 = fmt.format(STUDENT_COST / 100);
		// create a gridlayout with 1 column
		setLayout(new GridLayout(0, 1));

		// Create the check box.
		student = new JCheckBox(
				"For students, the cost of basic registration is " + dollarAmt2);

		// Add a border around the panel. The title will contain the cost of basic registration.
		setBorder(BorderFactory
				.createTitledBorder("Cost Of basic registration is "
						+ dollarAmt1));

		// Add the check box to this panel.
		add(student);
	}

	/**
	 * The getBasicCost method returns the cost of the basic registration. This
	 * will be an integer indicating number of cents, not dollars. This will
	 * eliminate the need to use a floating point number.
	 */

	public int getBasicCost() {
		// Basic registration will normally cost 895.00, which is the amount
		// stored in BASIC_COST
		// For students, the basic cost is 495.00, which is stored in the
		// constant STUDENT_COST
		int basicCost = 0;
		if (student.isSelected()) {
			basicCost = STUDENT_COST;
		} else {
			basicCost = BASIC_COST;
		}

		// Return the basic registration cost.
		return basicCost;
	}
}