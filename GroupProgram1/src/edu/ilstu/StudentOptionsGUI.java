package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
 * 
 * @author Corbin John and Rachel
 */
public class StudentOptionsGUI extends JFrame {
	/*
	 * These are the assets of the student list options
	 */
	private JPanel optionPanel;
	private JButton addStudentButton;
	private JButton removeStudentButton;

	/*
	 * These are the assets that display the list of students
	 */
	private JPanel studentListPanel;
	private JTextArea studentListTextArea;
	private JScrollPane scroll;

	/*
	 * These are the assets that are displayed at the top of the frame
	 */
	private JPanel topPanel;
	private File studentListFile;
	private JLabel fileLabel;
	private JTextField fileField;

	/*
	 *  These are the assets that are displayed at the bottom on the screen
	 */
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
	 * Default constructor
	 * 
	 * @param fileChooserFile -  the file that was created by the FileChooserGUI
	 */
	public StudentOptionsGUI(File fileChooserFile) {
		/*
		 * Sets up the frame
		 */
		super("Student List");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		/*
		 * Gets the current file
		 */
		studentListFile = fileChooserFile;
		studentList = new Group(studentListFile);

		/*
		 * Builds all the panels
		 */
		buildOptions();
		buildStudentList();
		buildTopPanel();
		buildBottomPanel();

		/*
		 * adds all the created panels to the frame
		 */
		add(optionPanel, BorderLayout.CENTER);
		add(studentListPanel, BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}
	
	/**
	 * returns the current file being used
	 * @return the current file
	 */
	public File getCurrentFile() {
		return studentListFile;
	}

	/**
	 * Builds the options panel
	 */
	public void buildOptions() {
		optionPanel = new JPanel();

		addStudentButton = new JButton("Add A Student");
		addStudentButton.addActionListener(new addStudentListener());

		removeStudentButton = new JButton("Remove A Student");
		removeStudentButton.addActionListener(new removeStudentListener());

		optionPanel.setLayout(new GridLayout(0, 1));

		optionPanel.add(addStudentButton);
		optionPanel.add(removeStudentButton);
	}

	/**
	 * Builds the top panel
	 */
	public void buildTopPanel() {
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());

		fileLabel = new JLabel("Current File: ");
		fileLabel.setFont(new Font("Serif", Font.BOLD, 18));

		fileField = new JTextField(studentListFile.getName());
		fileField.setEditable(false);
		fileField.setFont(new Font("Serif", Font.BOLD, 18));

		topPanel.add(fileLabel);
		topPanel.add(fileField);
	}

	/**
	 * Creates the text area that will read in the contents of a student list
	 */
	public void buildStudentList() {
		studentListPanel = new JPanel();

		studentListTextArea = new JTextArea(10, 30);
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
	public void buildBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());

		backButton = new JButton("Back");
		backButton.addActionListener(new backButtonListener());

		launchGroupButton = new JButton("Launch Group Creator");
		launchGroupButton.addActionListener(new launchGroupButtonListener());

		saveButton = new JButton("Save Changes");
		saveButton.addActionListener(new saveChangesListener());

		bottomPanel.add(backButton);
		bottomPanel.add(saveButton);
		bottomPanel.add(launchGroupButton);
	}

	/**
	 * Allows the user to save changes made to the student list
	 * @author Corbin Sumner
	 *
	 */
	private class saveChangesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				PrintWriter out = new PrintWriter(studentListFile);
				for (int i = 0; i < studentList.getGroupSize(); i++) {
					out.println(studentList.getStudent(i).getFirstName() + " "
							+ studentList.getStudent(i).getLastName() + " "
							+ studentList.getStudent(i).getGender());
				}
				JOptionPane.showMessageDialog(null,
						"Changed successfully saved.");
				out.close();
			}

			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Button that allows the user to add a student to the list
	 * @author Corbin Sumner
	 *
	 */
	private class addStudentListener implements ActionListener, WindowListener {
		public void actionPerformed(ActionEvent e) {
			addStudent = new AddStudentGUI(studentList);
			addStudent.addWindowListener(this);
		}
		public void windowActivated(WindowEvent e) {
		}
		/*
		 * Refreshes the displayed list of students when the window closes
		 */
		public void windowClosed(WindowEvent e) {
			// UPDATES EVERY TIME A NEW STUDENT IS ADDED
			studentListTextArea.setText(studentList.toString());
		}

		// redundant
		public void windowClosing(WindowEvent e) {
		}

		// redundant
		public void windowDeactivated(WindowEvent e) {
		}

		// redundant
		public void windowDeiconified(WindowEvent e) {
		}

		// redundant
		public void windowIconified(WindowEvent e) {
		}

		// redundant
		public void windowOpened(WindowEvent e) {
		}
	}
	/**
	 * Button used to launch the group creator
	 * @author Corbin Sumner
	 *
	 */
	private class launchGroupButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			groupCreator = new GroupCreatorGUI(studentListFile);
		}
	}
	/**
	 * Launches the remove student GUI
	 * @author Corbin Sumner
	 *
	 */
	private class removeStudentListener implements ActionListener,
			WindowListener {
		public void actionPerformed(ActionEvent e) {
			removeStudent = new RemoveStudentGUI(studentList);
			removeStudent.addWindowListener(this);
		}

		@Override
		public void windowActivated(WindowEvent arg0) {
		}

		/*
		 * Updates the displayed list of students when the removeStudentGUI is closed
		 * 
		 */
		public void windowClosed(WindowEvent arg0) {
			studentListTextArea.setText(studentList.toString());
		}

		//redundant
		public void windowClosing(WindowEvent arg0) {
		}

		//redundant
		public void windowDeactivated(WindowEvent arg0) {
		}

		//redundant
		public void windowDeiconified(WindowEvent arg0) {
		}

		//redundant
		public void windowIconified(WindowEvent arg0) {
		}

		//redundant
		public void windowOpened(WindowEvent arg0) {
		}
	}

	/**
	 * Allows the user to go back to the previous GUI
	 * @author Corbin Sumner
	 *
	 */
	private class backButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fileChooser = new FileChooserGUI();
			dispose();
		}
	}
}