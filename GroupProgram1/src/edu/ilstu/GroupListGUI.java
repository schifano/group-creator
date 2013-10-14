package edu.ilstu;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Description: 
 * @author Rachel A Schifano
 */

public class GroupListGUI extends JFrame 
{

	// instantiate variables
	private JPanel groupListPanel;
	private JPanel buttonPanel;
	
	private GroupList groupList;
	private GroupCreatorGUI groupCreatorGUI;
	
	private JTextArea groupListTextArea;
	private JScrollPane scroll;
	
	private JButton saveButton;
	private JButton backButton;
	private GroupList displayList;
	
	private final JFileChooser fc = new JFileChooser();
	private File outFile;
	
	/**
	 * Constructor
	 */
	
	// pass file in?
	public GroupListGUI(GroupList displayList) 
	{
		// setup frame
		super("Group List");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.displayList = displayList;
		
		// call in group list file ?
		
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
		groupListPanel = new JPanel();
		
		groupListTextArea = new JTextArea(40,30);
		groupListTextArea.setText(displayList.toString());
		groupListTextArea.setLineWrap(true);
		groupListTextArea.setFont(new Font("Arial", Font.BOLD, 14));
		groupListTextArea.setEditable(false);
			
		scroll = new JScrollPane(groupListTextArea);
			
		groupListPanel.add(scroll);
	}
	
	
	
	/**
	 * Method that creates a button panel with save and back.
	 */
	public void buildButtonPanel() {
		
		buttonPanel = new JPanel();
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new saveButtonListener());
		
		backButton = new JButton("Back");
		backButton.addActionListener(new backButtonListener());
		
		buttonPanel.add(saveButton);
		buttonPanel.add(backButton);
	}
	
	/**
	 * Private inner class action listener that enables the save button.
	 */
	private class saveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			fc.showSaveDialog(buttonPanel);
			outFile = fc.getSelectedFile();
			try 
			{
				PrintWriter outList = new PrintWriter(outFile);
				for(int i = 0; i < displayList.getNumGroups(); i++)
				{
					for(int j = 0; j < displayList.getGroup(i).getGroupSize(); j++)
					{
						Student tmpStudent = new Student();
						tmpStudent = displayList.getGroup(i).getStudent(j);
						outList.print(tmpStudent.getFirstName()+ " " + tmpStudent.getLastName() + " " 
						+ tmpStudent.getGender() + " ");
					}
					outList.print("\n");
				}
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
			
    		//groupCreatorGUI = new GroupCreatorGUI(file);
    		dispose();
		}
	}
	
}
