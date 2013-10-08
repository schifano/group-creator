package edu.ilstu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private	JPanel fNamePanel; 
	private JLabel fNameLabel;
	private JTextField fNameField;
	private String fName;
	
	//last name panel assets
	private JPanel lNamePanel;
	private JLabel lNameLabel;
	private JTextField lNameField;
	private String lName;
	
	
	private JPanel buttonPanel;
	private JButton removeButton;
	private JButton cancelButton;
	
	private Group removeStudentList;
	
	
	/**
	 * creates the remove student interface
	 */
	public RemoveStudentGUI(Group studentList)
	{
		//sets up the frame
    	super("Remove a Student");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1));
		
		removeStudentList = studentList;
		
		//builds the panels
		buildFirstNamePanel();
		buildLastNamePanel();
		buildButtonPanel();
		
		//adds the panels
		add(fNamePanel);
		add(lNamePanel);
		add(buttonPanel);
		
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
	
	public void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		removeButton = new JButton("Remove");
		removeButton.addActionListener(new removeListener());
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new cancelListener());
		
		buttonPanel.add(removeButton);
		buttonPanel.add(cancelButton);
	}
	
	public class removeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean isRemoved;
			
			fName = fNameField.getText();
    		lName = lNameField.getText();
    		
    		isRemoved = removeStudentList.removeStudent(fName, lName);
    		
    		if(isRemoved)
    		{
    			JOptionPane.showMessageDialog(null, fName + " " + lName + " has been removed", 
    										"Student Removed", JOptionPane.INFORMATION_MESSAGE);
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Student Not Found", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		dispose();
		}
	}
    
	public class cancelListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {	
    		dispose();
        }
    }
}
