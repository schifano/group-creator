package edu.ilstu;

/*
 * Filename: RegistrationGUI.java
 * Sep 17, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.awt.GridLayout;
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
 *         The RegistrationGUI class creates the GUI for registering for a JAVA
 *         conference. It will create a frame first, and then add a banner to
 *         that frame, a list of optional workshops, and a checkbox for whether
 *         the user would like to attend an optional dinner with a keynote
 *         speaker.
 */

public class RegsitrationGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * the banner will be the header of the entire frame and contain a checkbox
	 * as to whether or not the user is a student
	 */
	private Banner basicRegistration;
	// The list will contain a list of optional workshops which will be offered
	// at the conference
	private WorkShops list;

	private Dinner dinn;

	private JPanel buttonPanel; // To hold the button at the bottom of the frame
	private JButton registerButton; // To enter credit card information.
	private JButton exitButton; // To exit the application

	/**
	 * Constructor which will build the frame, and then add the different
	 * components.
	 */

	public RegsitrationGUI() {
		// Display a title.
		super("JAVA conference registration");

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager for
		// the content pane with only one column
		setLayout(new GridLayout(0, 1));

		// Create the custom panels.
		basicRegistration = new Banner();
		list = new WorkShops();
		dinn = new Dinner();

		// Call the buildButtonPanel method to
		// create the button panel.
		buildButtonPanel();

		// Add the components to the content pane.
		add(basicRegistration);
		add(list);
		add(dinn);
		add(buttonPanel);

		// Pack the contents of the window and display it.
		pack();
		setVisible(true);

	}

	/**
	 * The buildButtonPanel method builds the button panel.
	 */

	private void buildButtonPanel() {
		buttonPanel = new JPanel();

		registerButton = new JButton("Register for Conference");
		exitButton = new JButton("Exit");

		registerButton.addActionListener(new RegisterButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		buttonPanel.add(registerButton);
		buttonPanel.add(exitButton);
	}

	/**
	 * Private inner class that handles the event when the user clicks the
	 * Registration button. This class will delete the previous frame, and
	 * create a new CheckoutGUI frame for the user to enter credit card
	 * information.
	 */

	private class RegisterButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Calculate the total cost.
			int totalCost = basicRegistration.getBasicCost()
					+ list.getWorkshopsCost() + dinn.getDinnerCost();

			// Display the charges, and ask user if they want to enter credit
			// card information now.
			NumberFormat fmt = NumberFormat.getCurrencyInstance();
			String dollarAmt;
			dollarAmt = fmt.format(totalCost / 100);
			int selection = JOptionPane
					.showConfirmDialog(
							null,
							"The total cost of your conference will be "
									+ dollarAmt
									+ "\nWould you like to enter your credit card information now?",
							"", JOptionPane.YES_NO_OPTION);
			if (selection == 0) {
				setVisible(false);
				new CheckoutGUI(totalCost);
			}
		}
	}

	/**
	 * Private inner class that handles the event when the user clicks the Exit
	 * button. This will shut down the application.
	 */

	private class ExitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Exit the application.
			System.exit(0);
		}
	}

}