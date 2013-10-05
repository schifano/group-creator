package edu.ilstu;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * creates the remove student interface
 * @author Corbin, Rachel, John
 *
 */
public class RemoveStudentGUI extends JFrame
{

	//first name panel assets
	JPanel fNamePanel; 
	JLabel fNameLabel;
	JTextField fNameField;
	
	//last name panel assets
	JPanel lNamePanel;
	JLabel lNameLabel;
	JTextField lNameField;
	
	/**
	 * creates the remove student interface
	 */
	public RemoveStudentGUI()
	{
		//sets up the frame
    	super("Remove a Student");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1));
		
		//builds the panels
		buildFirstNamePanel();
		buildLastNamePanel();
		
		//adds the panels
		add(fNamePanel);
		add(lNamePanel);
		
		pack();
		setVisible(true);	
	}
	
	/**
	 * builds the first name panel
	 */
	public void buildFirstNamePanel()
	{
		//sets up the assets of first name panel
		fNamePanel = new JPanel();
		fNamePanel.setLayout(new FlowLayout());
		fNameLabel = new JLabel("First Name: ");
		fNameField = new JTextField(15);
		
		//adds the assets of the first name panel
		fNamePanel.add(fNameLabel);
		fNamePanel.add(fNameField);
	}
	
	/**
	 * builds the last name panel
	 */
	public void buildLastNamePanel()
	{
		//sets up the assets of the last name panel
		lNamePanel = new JPanel();
		lNamePanel.setLayout(new FlowLayout());
		lNameLabel = new JLabel("Last Name: ");
		lNameField = new JTextField(15);
		
		//adds assets of the last name panel
		lNamePanel.add(lNameLabel);
		lNamePanel.add(lNameField);
	}
	
	public static void main(String [] args)
	{
		RemoveStudentGUI app = new RemoveStudentGUI();
	}
}
