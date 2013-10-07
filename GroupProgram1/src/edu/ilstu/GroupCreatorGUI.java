package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFileChooser;

/**
 * Description: GroupCreatorGUI that generates the GUI that allows a user to
 * select the various ways of creating a group.
 * @author Rachel A Schifano
 */

public class GroupCreatorGUI extends JFrame {
	
	// Create new Sort Panel object
	private GroupCreatorSortPanel groupCreatorSortPanel;
	
	// Create button panel and buttons
	private JPanel buttonPanel;
	private JButton createGroupButton;
	private JButton backButton;
	private JButton cancelButton;
	
	// Create new file chooser object
	private JFileChooser fc;
	
	private File currentFile;
	
	private StudentOptionsGUI studentOptions;
	
	/**
	 * Constructor
	 */
	public GroupCreatorGUI(File studentOptionFile) {
		
		// Display title
		super("Lab Group Creator Application");
		
		//Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// stores the filepath of the file being operated on
		currentFile = studentOptionFile;
		
		
		// Create a BorderLayout manager for content pane
		setLayout(new BorderLayout());
		
		// Create custom panels
		groupCreatorSortPanel = new GroupCreatorSortPanel();
		
		// Call the buildButtonPanel method to create button pane.
		buildButtonPanel();
		
		// Add components to the content pane.
	//  add(groupCreatorFileChooser, BorderLayout.NORTH);
		add(groupCreatorSortPanel, BorderLayout.CENTER);
	    add(buttonPanel, BorderLayout.SOUTH);

		// Pack contents of the window and display it.
		pack();
		setVisible(true);
		
	}
	

	/**
	 * The buildButtonPanel method builds a button panel.
	 */
	private void buildButtonPanel() {
		
		buttonPanel = new JPanel();
		
		createGroupButton = new JButton("Create Group");
		createGroupButton.addActionListener(new CreateGroupButtonListener());
		
		backButton = new JButton("Back");
		backButton.addActionListener(new BackButtonListener());
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new CancelButtonListener());
		
		buttonPanel.add(createGroupButton);
		buttonPanel.add(backButton);
		buttonPanel.add(cancelButton);
	}
	
	
	
	/**
	 * Private inner class that handles the event when
	 * the user clicks on the createGroup button
	 */
	private class CreateGroupButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			fc= new JFileChooser();
	    


	      }
	}
	
	
	// May be needed per Corbin's request
	/**
	 * Private inner class that handles the event when
	 * the user clicks on the back button
	 */
	private class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			studentOptions = new StudentOptionsGUI(currentFile);
		}
	}
	
	
	
	
	/**
	 * Private inner class that handles the event when
	 * the user clicks on the cancel button
	 */
	private class CancelButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			// Exit the application
			System.exit(0);
		}
	}
	
}
