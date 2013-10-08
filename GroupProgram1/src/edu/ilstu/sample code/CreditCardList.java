package edu.ilstu;

/*
 * Filename: CreditCardList.java
 * Sep 20, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author John Boomgarden
 * 
 *         This class will display a list of different types of credit cards,
 *         and ask the user for a valid credit card number.
 */

public class CreditCardList extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2895915288445041562L;
	// Radio buttons for each type of credit card
	private JRadioButton VA; // Visa
	private JRadioButton MC; // Mastercard
	private JRadioButton AX; // American Express
	private ButtonGroup buttonGroup;
	private boolean validCard;

	/**
	 * Constructor to build radio buttons
	 */

	public CreditCardList() {
		// Create a GridLayout manager with
		// three rows and one column.
		setLayout(new GridLayout(3, 1));

		// Create the radio buttons.
		VA = new JRadioButton("Visa");
		MC = new JRadioButton("Mastercard");
		AX = new JRadioButton("American Express");
		// Group the radio buttons and add them to this panel.
		buttonGroup = new ButtonGroup();
		buttonGroup.add(VA);
		buttonGroup.add(MC);
		buttonGroup.add(AX);

		// Add a border around the panel.
		setBorder(BorderFactory.createTitledBorder("Credit Card"));

		// Add the radio buttons to this panel.
		add(VA);
		add(MC);
		add(AX);
		VA.addActionListener(new VisaButtonListener());
		MC.addActionListener(new MasterCardButtonListener());
		AX.addActionListener(new AmericanExpressButtonListener());
	}

	/**
	 * This method will return the information on whether or not the credit card
	 * information is valid.
	 * 
	 * @return
	 */
	public boolean getValidCard() {
		boolean validity = validCard;
		return validity;
	}

	/**
	 * This class is a private inner class that will validate a Visa credit
	 * card.
	 */

	private class VisaButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			validCard = false;
			String cardNumber = JOptionPane.showInputDialog(null,
					"Please enter your credit card number");
			boolean validNum = validVisa(cardNumber);
			if (validNum)
				validNum = validCheckSum(cardNumber, 10);
			while (!validNum && cardNumber != null) {
				// if invalid card number, display message telling them it is
				// incorrect
				cardNumber = JOptionPane.showInputDialog(null, "Card number "
						+ cardNumber
						+ " does not appear to be valid.Please try again.");
				validNum = validVisa(cardNumber);
				if (validNum)
					validNum = validCheckSum(cardNumber, 10);
			}
			if (validNum)
				validCard = true;
		}
	}

	/**
	 * This method will validate a Visa credit card. In order to be valid, the
	 * entire string must be numeric, the first character must be a 4, and it
	 * must contain either 13 or 16 digits.
	 * 
	 * @param cardNumber
	 *            String which contains credit card number to be validated.
	 * @return
	 */
	protected boolean validVisa(String cardNumber) {

		boolean validity = false;
		if (cardNumber != null) {
			if ((cardNumber.length() == 13) | (cardNumber.length() == 16))
				validity = true;
			else
				validity = false;
			if (validity)
				if (cardNumber.charAt(0) == '4')
					validity = true;
				else
					validity = false;
			if (validity) {
				for (int i = 0; i < cardNumber.length(); i++)
					if (Character.isDigit(cardNumber.charAt(i)))
						;
					else
						validity = false;
			}
		}

		return validity;
	}

	/*
	 * This private inner class will validate a MasterCard credit card.
	 */
	private class MasterCardButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			validCard = false;
			String cardNumber = JOptionPane.showInputDialog(null,
					"Please enter your credit card number");
			boolean validNum = validMasterCard(cardNumber);
			if (validNum)
				validNum = validCheckSum(cardNumber, 10);
			while (!validNum && cardNumber != null) {
				cardNumber = JOptionPane.showInputDialog(null, "Card number "
						+ cardNumber
						+ " does not appear to be valid.Please try again.");
				validNum = validMasterCard(cardNumber);
				if (validNum)
					validNum = validCheckSum(cardNumber, 10);
			}
			if (validNum)
				validCard = true;
		}

	}

	/**
	 * This method will validate a MasterCard credit card. In order to be valid,
	 * the entire string must be numeric, the first 2 characters must be 51, 52,
	 * 53, 54, or 55, and the entire string should be 16 characters in length.
	 * 
	 * @param cardNumber
	 *            String which contains credit card number to be validated.
	 * @return
	 */
	protected boolean validMasterCard(String cardNumber) {
		boolean validity = false;
		if (cardNumber != null) {
			if ((cardNumber.length() == 16))
				validity = true;
			else
				validity = false;
			if (validity)
				if (cardNumber.charAt(0) == '5')
					if (cardNumber.charAt(1) == '1'
							| cardNumber.charAt(1) == '2'
							| cardNumber.charAt(1) == '3'
							| cardNumber.charAt(1) == '4'
							| cardNumber.charAt(1) == '5')
						validity = true;
					else
						validity = false;
				else
					validity = false;
			if (validity) {
				for (int i = 0; i < cardNumber.length(); i++)
					if (Character.isDigit(cardNumber.charAt(i)))
						;
					else
						validity = false;
			}
		}
		return validity;
	}

	/*
	 * This private inner class will validate an American Express credit card.
	 */
	private class AmericanExpressButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			validCard = false;
			String cardNumber = JOptionPane.showInputDialog(null,
					"Please enter your credit card number");
			boolean validNum = validAmericanExpress(cardNumber);
			if (validNum)
				validNum = validCheckSum(cardNumber, 10);
			while (!validNum && cardNumber != null) {
				cardNumber = JOptionPane.showInputDialog(null, "Card number "
						+ cardNumber
						+ " does not appear to be valid.Please try again.");
				validNum = validAmericanExpress(cardNumber);
				if (validNum)
					validNum = validCheckSum(cardNumber, 10);

			}
			if (validNum)
				validCard = true;

		}

	}

	/**
	 * This method will validate an American Express credit card. In order to be
	 * valid, the entire string must be numeric, the first 2 characters must be
	 * 37, and the entire string should be 15 characters in length.
	 * 
	 * @param cardNumber
	 *            String which contains credit card number to be validated.
	 * @return
	 */
	protected boolean validAmericanExpress(String cardNumber) {

		boolean validity = false;
		if (cardNumber != null) {
			if ((cardNumber.length() == 15))
				validity = true;
			else
				validity = false;
			if (validity)
				if (cardNumber.charAt(0) == '3' && cardNumber.charAt(1) == '7')
					validity = true;
				else
					validity = false;
			if (validity) {
				for (int i = 0; i < cardNumber.length(); i++)
					if (Character.isDigit(cardNumber.charAt(i)))
						;
					else
						validity = false;
			}
		}
		return validity;
	}

	/**
	 * This method will determine if the credit card has a valid checksum
	 * 
	 * @param cardNumber
	 *            String containing the credit card number
	 * @param checkSum
	 *            digit which will be divided into the sum of all digits
	 * @return
	 */
	protected boolean validCheckSum(String cardNumber, int checkSum) {
		boolean validity = false;
		if (cardNumber != null && checkSum != 0) {
			int arraySize = cardNumber.length();
			int totalSum = 0;
			int[] tempArray = new int[arraySize];
			for (int i = 0; i < cardNumber.length(); i++)
				if (Character.isDigit(cardNumber.charAt(i))) {
					tempArray[i] = Character.getNumericValue(cardNumber
							.charAt(i));
				} else
					validity = false;
			for (int i = cardNumber.length() - 2; i >= 0; i = i - 2) {
				tempArray[i] = tempArray[i] * 2;
			}

			for (int i = 0; i < cardNumber.length(); i++) {
				/*
				 * Since each integer has been parsed out, it is impossible for
				 * any number in the array to be larger than 9, until we may
				 * have doubled it in the step immediately above. Since that is
				 * the case, the largest any integer can be in the array would
				 * be 18. This step is supposed to take any number with more
				 * than one digit, and break it into the first digit plus the
				 * second digit. This can also be accomplished by just
				 * subtracting 9 from any number greater than 9.
				 */
				if (tempArray[i] > 9)
					totalSum = totalSum + tempArray[i] - 9;
				else
					totalSum = totalSum + tempArray[i];
			}
			if (totalSum % checkSum == 0)
				validity = true;
		}

		return validity;
	}

}
