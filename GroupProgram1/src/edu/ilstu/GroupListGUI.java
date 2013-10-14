package edu.ilstu;

/*
 * Filename: GroupListGUI.java
 * Date: 10/14/13
 * 
 * ULID: raschif
 * Course: IT 226
 * Instructor: Cathy Holbrook
 * 
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Description: Class that displays the newly generated group list
 * and allows the user to either save or go back to the previous 
 * GroupCreatorGUI frame to reselect sorting options.
 * @author Rachel A Schifano
 */

public class GroupListGUI extends JFrame 
{
	// instance variables
	private JPanel groupListPanel;
	private JPanel buttonPanel;
	
	private JTextArea groupListTextArea;
	private GroupList displayList;
	private JScrollPane scroll;
	
	private JButton saveButton;
	private JButton backButton;

	// variables for selecting a file
	private final JFileChooser fc = new JFileChooser();
	private File outFile;
	
	/**
	 * Constructor
	 */
	public GroupListGUI(GroupList displayList) 
	{
		// setup frame
		super("Group List");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.displayList = displayList;
		
		buildGroupList(); // build panel to display group list
		buildButtonPanel(); // build button panel to display save and back button
		
		// add all panels to the frame
		add(groupListPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}
	
	/**
	 * Method that creates the group list panel where the new
	 * group lists will appear.
	 */
	public void buildGroupList() 
	{	
		// create a new panel
		groupListPanel = new JPanel();
		
		// create new text area to display the new group list
		groupListTextArea = new JTextArea(40,30);
		groupListTextArea.setText(displayList.toString());
		groupListTextArea.setLineWrap(true);
		groupListTextArea.setFont(new Font("Arial", Font.BOLD, 14));
		groupListTextArea.setEditable(false);
			
		// add scrolling for longer lists
		scroll = new JScrollPane(groupListTextArea);
		groupListPanel.add(scroll);
	}
	
	/**
	 * Method that creates a button panel with save and back.
	 */
	public void buildButtonPanel() {
		// create new button panel
		buttonPanel = new JPanel();
		
		// create save button and add action listener
		// so the user can save the newly created group list file
		saveButton = new JButton("Save");
		saveButton.addActionListener(new saveButtonListener());
		
		// create back button and add action listener
		// so the user can go back to the GroupCreatorGUI
		backButton = new JButton("Back");
		backButton.addActionListener(new backButtonListener());
		
		// add the buttons to the button panel
		buttonPanel.add(saveButton);
		buttonPanel.add(backButton);
	}
	
	/**
	 * Private inner class action listener that enables the save button.
	 */
	private class saveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			// create a save dialog that allows the user 
			// to select where to save the file
			fc.showSaveDialog(buttonPanel);
			outFile = fc.getSelectedFile();
			
			try 
			{
				// write out the content to the new saved file
				PrintWriter outList = new PrintWriter(outFile);
				// loop through the number of groups
				for(int i = 0; i < displayList.getNumGroups(); i++)
				{
					// loop through the group size
					for(int j = 0; j < displayList.getGroup(i).getGroupSize(); j++)
					{
						// print out each student object
						Student tmpStudent = new Student();
						tmpStudent = displayList.getGroup(i).getStudent(j);
						outList.print(tmpStudent.getFirstName()+ " " + tmpStudent.getLastName() + " " 
						+ tmpStudent.getGender() + " ");
					}
					// add line break
					outList.print("\n");
				}
				// close the list
				outList.close();
			} 
			catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * Private inner class action listener that enables the back button to
	 * return to the GroupCreatorGUI screen.
	 */
	private class backButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
    		dispose(); // dispose current frame
		}
	}
	
}
