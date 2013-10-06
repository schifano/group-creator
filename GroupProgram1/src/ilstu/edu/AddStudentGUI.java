package edu.ilstu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ilstu.RemoveStudentGUI.cancelListener;


/**
 * Creates the interface to add a student to the list
 * @author John, Rachel, Corbin
 *
 */
public class AddStudentGUI extends JFrame 
{
	//assets of the first name panel
	private JPanel fNamePanel; 
	private JLabel fNameLabel;
	private JTextField fNameField;
	
	//assets of the last name panel
	private JPanel lNamePanel;
	private JLabel lNameLabel;
	private JTextField lNameField;
	
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton cancelButton;
	
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
		buildButtonPanel();
		
		//adds panels
		add(fNamePanel);
		add(lNamePanel);
		add(buttonPanel);
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
	
	public void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		addButton = new JButton("Add");
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new cancelListener());
		
		buttonPanel.add(addButton);
		buttonPanel.add(cancelButton);
	}
	
    private class cancelListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {	
    		dispose();
        }
    }
	
	
	public static void main(String [] args)
	{
		AddStudentGUI app = new AddStudentGUI();
	}	
}