package edu.ilstu;

/*
 * Filename: GroupCreatorGUI.java
 * Date: 10/14/13
 * 
 * ULID: raschif
 * Course: IT 226
 * Instructor: Cathy Holbrook
 * 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Description: GroupCreatorGUI that generates the GUI that allows a user to
 * select the various ways of sorting a group or optionally upload a previous
 * group file to compare the new group file to. This GUI provides a Create
 * Group button that will launch the GroupListGUI where the new group file
 * will appear.
 * @author Rachel A Schifano, John Boomgarden, Corbin Sumner
 */

public class GroupCreatorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	// instance variables
	private StudentOptionsGUI studentOptions;
	private GroupCreatorSortPanel groupCreatorSortPanel;
	private UploadPanel uploadPanel;
	private GroupList finalGroupList;
	private GroupListApp groupListApp;
	private GroupListGUI groupListGUI;
	
	// create button panel and buttons
	private JPanel buttonPanel;
	private JButton createGroupButton;
	private JButton backButton;
	private JButton cancelButton;
	
	// create objects for file choosing
	private File currentFile;
	
	/**
	 * Constructor
	 */
	public GroupCreatorGUI(File studentOptionFile) {
		
		// Display title
		super("Lab Group Creator Application");
		
		//Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// stores the file path of the file being operated on
		currentFile = studentOptionFile;
		
		groupListApp = new GroupListApp();
		// Create a BorderLayout manager for content pane
		setLayout(new BorderLayout());
		
		// Create custom panels
		groupCreatorSortPanel = new GroupCreatorSortPanel(groupListApp);
		uploadPanel = new UploadPanel();
		
		// Call the buildButtonPanel method to create button pane.
		buildButtonPanel();
		
		// Add components to the content pane.
		add(groupCreatorSortPanel, BorderLayout.NORTH);
		add(uploadPanel, BorderLayout.CENTER);
	    add(buttonPanel, BorderLayout.SOUTH);

		// Pack contents of the window and display it.
		pack();
		setVisible(true);
		
	}

	/**
	 * The buildButtonPanel method builds a button panel
	 * with a create group and back button.
	 */
	private void buildButtonPanel() 
	{
		// create new button panel
		buttonPanel = new JPanel();
		
		// create new create group button
		// add action listener for launching the new group list
		createGroupButton = new JButton("Create Group");
		createGroupButton.addActionListener(new CreateGroupButtonListener());
		
		// create new back button
		// add action listener for the user go back to the previous GUI
		backButton = new JButton("Back");
		backButton.addActionListener(new BackButtonListener());
		
		// add buttons to the panel
		buttonPanel.add(backButton);
		buttonPanel.add(createGroupButton);
	}
	
	/**
	 * Private inner class that handles the event when
	 * the user clicks on the createGroup button
	 */
	private class CreateGroupButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			// Determine if the input for the number of groups entered or group size
			// is equal to 0. Display an error message. 
			if(groupListApp.getNumGroups() == 0 && groupListApp.getGroupSize() == 0)
			{
				JOptionPane.showMessageDialog(null, "Please Select a Sort Option", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				// Pass the current group student file and the optional uploaded previous group list file
				// Store the newly generated student list and pass the final group list into the GroupListGUI
				finalGroupList = groupListApp.CreateGroupList(currentFile, uploadPanel.getGroupPreviousFile());
				groupListGUI = new GroupListGUI(finalGroupList);
			}
			
	      }
	}
	
	/**
	 * Private inner class that handles the event when the user clicks on the back button
	 */
	private class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			// disposes current frame
			dispose();
			// passes current student list file to the StudentOptionsGUI 
			// to take the user back to the previous StudentOptions frame
			studentOptions = new StudentOptionsGUI(currentFile);
		}
	}
}
