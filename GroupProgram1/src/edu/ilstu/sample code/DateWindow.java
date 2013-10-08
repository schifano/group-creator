package edu.ilstu;
/*
 * Filename: CreditCardList.java
 * Sep 22, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author John Boomgarden
 * This class will display 2 lists, one for the month of the expiration date of
 * the credit card, and one to allow for the entry of the year.
 */

public class DateWindow extends JPanel {
	/**
	 * 
	 */
	private boolean validDate;
	private static final long serialVersionUID = 6590932966626640087L;
	
	private JPanel datePanel; // To hold components
	private JPanel selectedDatePanel; // To hold components
	
	private JList<Object> monthList; // A list of months
	private JList<Object> yearList; // A list of years
	
	private JTextField selectedDate; // The selected date displayed for the user
	private JLabel label; // To display a message

	// The following array holds the values that will be
	// displayed in the monthList list component.
	private String[] months = { "01", "02", "03", "04", "05", "06", "07", "08",
			"09", "10", "11", "12" };
	private String[] years = { "2013", "2014", "2015", "2016", "2017", "2018",
			"2019", "2020", "2021", "2022", "2023", "2024" };

	/**
	 * Constructor
	 */

	public DateWindow() {

		// Create a BorderLayout manager for the content pane.
		setLayout(new GridLayout(0, 2));

		// Add a border around the panel with spacing to place headings above
		// the lists.
		setBorder(BorderFactory
				.createTitledBorder("                       Month Year              "));
		// Build the month and selectedMonth panels.
		buildDatePanel();
		buildSelectedDatePanel();

		// Add the panels to the content pane.
		add(datePanel);
		add(selectedDatePanel);

	}

	/**
	 * The buildDatePanel method adds 2 lists, one with a list of months, and
	 * one with a list of years.
	 */

	private void buildDatePanel() {
		// Create a panel to hold the list.
		datePanel = new JPanel();

		// Create the lists.
		monthList = new JList<Object>(months);
		yearList = new JList<Object>(years);
		// Set the selection mode to single selection.
		monthList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		yearList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Register the list selection listener.
		monthList.addListSelectionListener(new ListListener());
		yearList.addListSelectionListener(new ListListener());
		// Add the list to the panel.
		datePanel.add(monthList);
		datePanel.add(yearList);
	}

	/**
	 * The buildSelectedDatePanel method adds an uneditable text field to a
	 * panel.
	 */

	private void buildSelectedDatePanel() {
		// Create a panel to hold the text field.
		selectedDatePanel = new JPanel();

		// Create the label.
		label = new JLabel("Expiration date: ");

		// Create the text field.
		selectedDate = new JTextField(10);

		// Make the text field uneditable.
		selectedDate.setEditable(false);

		// Add the label and text field to the panel.
		selectedDatePanel.add(label);
		selectedDatePanel.add(selectedDate);
	}

	/**
	 * This method will return whether the expiration date of a credit card is
	 * valid, or not.
	 * 
	 * @return
	 */
	public boolean getValidDate() {
		boolean validity = validDate;
		return validity;
	}

	/**
	 * Private inner class that handles the event when the user selects an item
	 * from both lists.
	 */

	private class ListListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			validDate = false;

			/*
			 * we want to get the current date in a YYYYMM format, so that we
			 * can compare the entered expiration to it
			 */
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMM");

			// Get the selected string from the list.
			String monthSelection = "";
			String yearSelection = "";
			monthSelection = (String) monthList.getSelectedValue();
			yearSelection = (String) yearList.getSelectedValue();
			// Store the selected string in the text field.

			// Once the month and year have both been selected, if they are less
			// than or equal to the
			// present year and month, we will ask them to enter it again
			if (monthSelection != null && yearSelection != null) {
				String currentDate = (dateFormat.format(date));
				
				/* today's date was returned in string format,
				 * in order to do the comparison, we need to move the YYYYY  MM
				 * into an integer. 
				 */
				int checkCurrentDate = Integer.parseInt(currentDate);
				String dateSelection = yearSelection + monthSelection;
				
				int checkDate = Integer.parseInt(dateSelection);
				
				if (checkDate <= checkCurrentDate) {
					JOptionPane.showMessageDialog(null,
							"That credit card appears to be expired");
					selectedDate.setText("");
				} else {
					validDate = true;
					selectedDate.setText(monthSelection + "/" + yearSelection);
				}
			}
		}
	}
}
