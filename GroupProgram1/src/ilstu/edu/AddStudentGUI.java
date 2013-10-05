package edu.ilstu;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Creates the interface to add a student to the list
 * @author John, Rachel, Corbin
 *
 */
public class AddStudentGUI extends JFrame 
{
	//assets of the first name panel
	JPanel fNamePanel; 
	JLabel fNameLabel;
	JTextField fNameField;
	
	//assets of the last name panel
	JPanel lNamePanel;
	JLabel lNameLabel;
	JTextField lNameField;
	
	/**
	 * Default Constructor
	 */
	public AddStudentGUI()
	{
		//sets up frame
    	super("Add a Student");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1));
		
		//builds panels
		buildFirstNamePanel();
		buildLastNamePanel();
		
		//adds panels
		add(fNamePanel);
		add(lNamePanel);
		
		pack();
		setVisible(true);
		
	}
	
	/**
	 * creates first name panel
	 */
	public void buildFirstNamePanel()
	{
		//sets up first name assets
		fNamePanel = new JPanel();
		fNamePanel.setLayout(new FlowLayout());
		fNameLabel = new JLabel("First Name: ");
		fNameField = new JTextField(15);
		
		//adds first name assets
		fNamePanel.add(fNameLabel);
		fNamePanel.add(fNameField);
	}
	
	/**
	 * creates last name panel
	 */
	public void buildLastNamePanel()
	{
		//sets up last name panel
		lNamePanel = new JPanel();
		lNamePanel.setLayout(new FlowLayout());
		lNameLabel = new JLabel("Last Name: ");
		lNameField = new JTextField(15);
		
		//adds last name assets
		lNamePanel.add(lNameLabel);
		lNamePanel.add(lNameField);
	}
	
	public static void main(String [] args)
	{
		AddStudentGUI app = new AddStudentGUI();
	}	
}