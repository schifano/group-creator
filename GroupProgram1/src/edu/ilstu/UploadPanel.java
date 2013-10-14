package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Description: 
 * @author Rachel A Schifano
 */

public class UploadPanel extends JPanel 
{

	private GroupListApp groupListApp;
	private GroupCreatorGUI groupCreatorGUI;
	
	private JPanel groupListPanel;
	private JLabel blankLabel;
	private JLabel groupListLabel;
	private JTextField groupListFileField;
	
	
	private JLabel uploadLabel;
	private JButton uploadButton;
	
	private final JFileChooser fileChoose = new JFileChooser();
	private File newFile;
	private PrintWriter out;

	
	/**
	 * Constructor
	 */
	public UploadPanel() 
	{

		
		setLayout(new GridLayout(2,1));
		
		uploadLabel = new JLabel("Choose previous group file to compare new group file to.");
			
		uploadButton = new JButton("Upload");
		uploadButton.addActionListener(new UploadButtonListener());
		
		setBorder(BorderFactory.createTitledBorder("Optional"));
		
		
		// build group file panel
		buildGroupFilePanel();
		
		add(uploadLabel); // row 1
		add(groupListPanel); // row 2
		
	}
	
	/**
	 * Method that builds the group file panel.
	 */
	public void buildGroupFilePanel() {
		groupListPanel = new JPanel();
		groupListPanel.setLayout(new BorderLayout());
		
		blankLabel = new JLabel(" ");
		groupListLabel = new JLabel("File: ");
		// change dimensions?
		groupListFileField = new JTextField("NO FILE");
		groupListFileField.setEnabled(false);
		
		// add all assets to the file panel
		groupListPanel.add(groupListLabel, BorderLayout.WEST);
		groupListPanel.add(groupListFileField, BorderLayout.CENTER);
		groupListPanel.add(uploadButton, BorderLayout.EAST);
	}
	
	public void setGroupListFileField(String text) 
	{
		
		groupListFileField.setText(text);
	}
	
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

	        	fileChoose.showOpenDialog(groupCreatorGUI);
	        	newFile = fileChoose.getSelectedFile();
	        	
	        	String fileName = newFile.getName();
	        	setGroupListFileField(fileName);
	        	/*
	        	try {
					PrintWriter outTest = new PrintWriter(newFile);
					outTest.close();
				} 
	        	catch (FileNotFoundException e1) 
	        	{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	 */
	        }
		}
	}
}
