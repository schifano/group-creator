package ilstu.edu;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

/**
 * Description: GroupCreatorGUI that generates the GUI that allows a user to
 * select the various ways of creating a group.
 * @author Rachel A Schifano
 */

public class GroupCreatorSortPanel extends JPanel {

	// Radio buttons for group number sorting
	private JRadioButton studentsPerGroup;
	private JRadioButton groups;
	
	// Checkbox for optional gender sorting
	private JCheckBox gender;
	
	// Buttongroup variable will reference an object to group the radio buttons and checkbox
	private ButtonGroup bg_sort;
	
	/**
	 * Constructor
	 */
	public GroupCreatorSortPanel() {
		
		// GridLayout manager with three rows one column
		setLayout(new GridLayout(3,1));
		
		// Radio buttons
		studentsPerGroup = new JRadioButton("Number of students per group.");
		groups = new JRadioButton("Number of groups.");
		// Checkbox
		gender = new JCheckBox("Gender.");
		
	    // Group the radio buttons.
	    bg_sort = new ButtonGroup();
	    bg_sort.add(studentsPerGroup);
	    bg_sort.add(groups);
	    bg_sort.add(gender);
	    
	    // Adds border around panel
	    setBorder(BorderFactory.createTitledBorder("Sort"));
	   
	    // Add buttons to panel.
	    add(studentsPerGroup);
	    add(groups);
	    add(gender);
	}
	
}
