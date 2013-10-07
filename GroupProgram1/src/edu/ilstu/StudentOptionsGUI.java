package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * This class is the GUI for student list options
 * @author Corbin John and Rachel
 */
public class StudentOptionsGUI extends JFrame
{	
	//These are the assets of the student list options
	private JPanel optionPanel;
	private JButton addStudentButton;
	private JButton removeStudentButton;
	
	//These are the assets that display the list of students
	private JPanel studentListPanel;
	private JTextArea studentListTextArea;
	private JScrollPane scroll;
	
	//These are the assets that are displayed at the top of the frame
	private JPanel topPanel;
	private File currentFile;
	private JLabel fileLabel;
	private JTextField fileField;
	
	//These are the assets that are displayed at the bottom on the screen
	private JPanel bottomPanel;
	private JButton backButton;
	private JButton launchGroupButton;
	private JButton saveButton;
	
	private AddStudentGUI addStudent;
	private RemoveStudentGUI removeStudent;
	private FileChooserGUI fileChooser;
	private GroupCreatorGUI groupCreator;
	
	
	protected Group studentList;
	/**
	 * default constructor
	 * @param file
	 */
	public StudentOptionsGUI(File fileChooserFile)
	{
		//Sets up the frame
    	super("Student List");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Gets the current file
		currentFile = fileChooserFile;
		studentList = new Group(currentFile);
			
		//Builds all the panels
		buildOptions();
		buildStudentList();
		buildTopPanel();
		buildBottomPanel();
		
		//adds all the created panels to the frame
		add(optionPanel, BorderLayout.CENTER);
		add(studentListPanel, BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}

	public StudentOptionsGUI(File listFile, Group grp1)
	{
		//Sets up the frame
    	super("Student List");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Gets the current file
		currentFile = listFile;
		studentList = grp1;
			
		//Builds all the panels
		buildOptions();
		buildStudentList();
		buildTopPanel();
		buildBottomPanel();
		
		//adds all the created panels to the frame
		add(optionPanel, BorderLayout.CENTER);
		add(studentListPanel, BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	
	
	/**
	 * Builds the options panel
	 */
	public void buildOptions()
	{
		
		optionPanel = new JPanel();
		
		addStudentButton = new JButton("Add A Student");
		addStudentButton.addActionListener(new addStudentListener());
		
		removeStudentButton = new JButton("Remove A Student");
		removeStudentButton.addActionListener(new removeStudentListener());
		
		optionPanel.setLayout(new GridLayout(0,1));
		
		optionPanel.add(addStudentButton);
		optionPanel.add(removeStudentButton);
	}
	
	/**
	 * Builds the top panel
	 */
	public void buildTopPanel()
	{
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		
		fileLabel = new JLabel("Current File: ");
		fileLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		fileField = new JTextField(currentFile.getName());
		fileField.setEditable(false);
		fileField.setFont(new Font("Serif", Font.BOLD, 18));
		
		topPanel.add(fileLabel);
		topPanel.add(fileField);
	}
	
	/**
	 * Creates the text area that will read in the contents of a student list
	 */
	public void buildStudentList()
	{
		studentListPanel = new JPanel();
			
		studentListTextArea = new JTextArea(5,30);
		studentListTextArea.setText(studentList.toString());
		studentListTextArea.setLineWrap(true);
		studentListTextArea.setFont(new Font("Arial", Font.BOLD, 14));
		studentListTextArea.setEditable(false);
			
		scroll = new JScrollPane(studentListTextArea);
			
		studentListPanel.add(scroll);
	}
	
	/**
	 * creates the panel at the bottom of the frame
	 */
	public void buildBottomPanel()
	{
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		
		backButton  = new JButton("Back");
		backButton.addActionListener(new backButtonListener());
		
		launchGroupButton = new JButton("Launch Group Creator");
		launchGroupButton.addActionListener(new launchGroupButtonListener());
		
		saveButton = new JButton("Save Changes");
		
		bottomPanel.add(backButton);
		bottomPanel.add(saveButton);
		bottomPanel.add(launchGroupButton);	
	}
	
	private class saveChangesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
    private class addStudentListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {	
    		addStudent = new AddStudentGUI(currentFile, studentList);
    		dispose();
        }
    }
    
    private class launchGroupButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {	
    		dispose();
    		groupCreator = new GroupCreatorGUI(currentFile);
        }
    }


    private class removeStudentListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {	
    		removeStudent = new RemoveStudentGUI();
        }
    }
	
    private class backButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {	
    		fileChooser = new FileChooserGUI();
    		dispose();
        }
    }
}