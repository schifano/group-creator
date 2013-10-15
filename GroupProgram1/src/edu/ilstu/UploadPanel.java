package edu.ilstu;

/*
 * Filename: UploadPanel.java
 * Date: 10/14/13
 * 
 * ULID: raschif
 * Course: IT 226
 * Instructor: Cathy Holbrook
 * 
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Description: The upload panel that sits on the GroupCreatorGUI frame. The upload panel
 * gives the user the option of uploading a previous group file to do a comparison to before
 * generating a new group list file.
 * @author Rachel A Schifano, John Boomgarden, Corbin Sumner
 */

public class UploadPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;

	// instance variables
	private GroupCreatorGUI groupCreatorGUI;
	
	private JPanel groupListPanel;
	private JLabel groupListLabel;
	private JTextField groupListFileField;
	private JLabel uploadLabel;
	private JButton uploadButton;
	
	// variables for saving and uploading files
	private final JFileChooser fileChoose = new JFileChooser();
	private File newFile;
	
	/**
	 * Constructor
	 */
	public UploadPanel() 
	{
		// create new layout with 2 rows and 1 column
		setLayout(new GridLayout(2,1));
		
		// create new label to give upload instructions to the user
		uploadLabel = new JLabel("Choose previous group file to compare new group file to.");
			
		// create upload button with a listener so that the user can select a file to upload
		uploadButton = new JButton("Upload");
		uploadButton.addActionListener(new UploadButtonListener());
		
		// indicate that the upload panel is optional
		setBorder(BorderFactory.createTitledBorder("Optional"));
		
		// build group file panel
		buildGroupFilePanel();
		
		// add the label and panel
		add(uploadLabel); // row 1
		add(groupListPanel); // row 2
	}
	
	/**
	 * Method that builds the upload panel with a label, 
	 * text field, and upload button.
	 */
	public void buildGroupFilePanel() {
		
		// create new panel
		groupListPanel = new JPanel();
		groupListPanel.setLayout(new BorderLayout());
		
		// create labels for the file name to appear
		groupListLabel = new JLabel("File: ");
		groupListFileField = new JTextField("NO FILE");
		groupListFileField.setEnabled(false);
		
		// add all assets to the file panel
		groupListPanel.add(groupListLabel, BorderLayout.WEST);
		groupListPanel.add(groupListFileField, BorderLayout.CENTER);
		groupListPanel.add(uploadButton, BorderLayout.EAST);
	}
	
	/**
	 * Method that sets the JTextField with an 
	 * updated file name on the upload panel.
	 * @param text The name of the file
	 */
	public void setGroupListFileField(String text) 
	{
		groupListFileField.setText(text);
	}
	
	/**
	 * Method that returns the previous group file that the user uploaded to be
	 * compared to the new group list file that will be created.
	 * @return newFile The name of the previous group file that was uploaded by the user
	 */
	public File getGroupPreviousFile() 
	{
		return newFile;
	}
	
	/**
	 * Private inner class that allows the user to upload a pre-exiting group file to compare
	 * the newly created file to to ensure students are not working with students from the last past group.
	 */
	private class UploadButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
	        {	
	        	// select the file to upload
	        	fileChoose.showOpenDialog(groupCreatorGUI);
	        	newFile = fileChoose.getSelectedFile();
	        	
	        	// update the filename JTextField
	        	String fileName = newFile.getName();
	        	setGroupListFileField(fileName);
	        }
		}
	}
}
