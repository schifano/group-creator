package edu.ilstu;
/*
 * Filename: CheckoutGUI.java
 * Sep 23, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author John Boomgarden
 * 
 * The CheckoutGUI class creates the GUI for the user to finalize their
 * registration. it will add a banner across the top to display the total amount
 * owed for the JAVA conference. Directly below that, on the left(as you are
 * facing the screen), will be 3 radio buttons, one for each type of major
 * credit card. On the right side of the screen will be an area to enter the
 * expiration date of the credit card.
 */

public class CheckoutGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4515509557397661132L;
	private CheckoutBanner chkout; // Banner to display total amount owed
	private CreditCardList creditCards; // radio buttons for types of credit
										// cards
	private DateWindow dates; // list selections for expiration date entry

	private JPanel buttonPanel; // To hold the buttons
	private JButton registerButton; // To finish registration
	private JButton exitButton; // To exit the application
	private int displayCost; // integer which contains the total value of the
								// java conference registration

	public CheckoutGUI(int totalCost) {
		super("JAVA conference registration");
		// Display a title.

		setVisible(true);
		// Display the charges.
		displayCost = totalCost;
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager for
		// the content pane.
		setLayout(new BorderLayout());

		// Create the custom panels.
		chkout = new CheckoutBanner(totalCost);
		creditCards = new CreditCardList();
		dates = new DateWindow();

		// Call the buildButtonPanel method to
		// create the button panel.
		buildButtonPanel();

		// Add the components to the content pane.
		add(chkout, BorderLayout.NORTH);
		add(creditCards, BorderLayout.WEST);
		add(dates, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);

		// Pack the contents of the window and display it.
		pack();
		setVisible(true);

	}

	/**
	 * The buildButtonPanel method builds the button panel.
	 */

	private void buildButtonPanel() {
		buttonPanel = new JPanel();

		registerButton = new JButton("Complete checkout");
		exitButton = new JButton("Exit");

		registerButton.addActionListener(new RegisterButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		buttonPanel.add(registerButton);
		buttonPanel.add(exitButton);
	}

	/**
	 * Private inner class that handles the event when the user clicks the
	 * complete checkout button. If everything is successful, a thank you message will  be displayed.
	 * If not, the user will be asked to enter correct credit card information. 
	 */

	private class RegisterButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			NumberFormat fmt = NumberFormat.getCurrencyInstance();
			String dollarAmt;
			dollarAmt = fmt.format(displayCost / 100);

			// if credit card information is valid display a message showing total charges
			if (creditCards.getValidCard() && dates.getValidDate()) {
				setVisible(false);
				JOptionPane.showMessageDialog(null,
						"Thank you for your registration. \n"
								+ "Your credit card will be charged "
								+ dollarAmt);
			} else {
				JOptionPane.showMessageDialog(null,
						"Your registration is incomplete \n"
								+ "without valid credit card information.");

			}
		}
	}

	/**
	 * Private inner class that handles the event when the user clicks the Exit
	 * button.
	 */

	private class ExitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Exit the application.
			System.exit(0);
		}
	}

}