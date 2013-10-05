package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates the initial interface for user to create a new file or load an existing one
 * @author Rachel, Corbin, and John
 *
 */
public class FileChooserGUI extends JFrame
{
	//These are the assets for the button panel
	private JPanel buttonPanel;
    private JButton createButton;
    private JButton loadExistingButton;
    
    //These are the assets for the file panel
    private JPanel filePanel;
    private JLabel blankLabel;
    private JLabel fileLabel;
    private JTextField fileField;
    
    //an instance of the studentOptionsGUI
    private StudentOptionsGUI studentGUI;
    private File file;
    
    // file chooser
    private final JFileChooser fc = new JFileChooser(); 
    String filePath;
    
    /**
     * default constructor
     */
    public FileChooserGUI()
    {
    	//sets up the frame
    	super("Main Menu");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//builds the panels
		buildButtonPanel();
		buildFilePanel();
		
		//adds the filepanel to the frame
		add(filePanel);
		
		pack();
		setVisible(true);
    }
    
    /**
     * builds the button panel
     */
    public void buildButtonPanel()
    {
    	//set up the button panel
    	buttonPanel = new JPanel();
    	buttonPanel.setLayout(new FlowLayout());
    	
    	//creates the button that allows the user to make a new list
		createButton = new JButton("Create New List");
		createButton.addActionListener(new createButtonListener());
		
		//creates the button that allows the user to load an existing list
		loadExistingButton = new JButton("Load Existing List");
		loadExistingButton.addActionListener(new loadExistingListener());
		
		//adds the buttons to the panel
		buttonPanel.add(createButton);
		buttonPanel.add(loadExistingButton);
    }

    //builds the file panel
    public void buildFilePanel()
    {
    	//creates and layouts the filepanel
    	filePanel = new JPanel();
    	filePanel.setLayout(new BorderLayout());
    	
    	//creates the assets for the file panel
    	blankLabel = new JLabel(" ");
    	fileLabel = new JLabel("Current File: ");
    	fileField = new JTextField("NO FILE");
    	fileField.setEnabled(false);
    	
    	//adds all of the assets to the file panel
    	filePanel.add(blankLabel, BorderLayout.NORTH);
    	filePanel.add(fileLabel, BorderLayout.WEST);
    	filePanel.add(fileField, BorderLayout.CENTER);
    	
    	/*
    	 * THE BUTTON PANEL IS ADDED TO THE FILE PANEL
    	 */
    	filePanel.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private class createButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {	
    		fc.showSaveDialog(filePanel);
    		studentGUI = new StudentOptionsGUI(fc.getSelectedFile());
    		dispose();
        }
    }
    
    private class loadExistingListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {
    		fc.showOpenDialog(filePanel);
     		studentGUI = new StudentOptionsGUI(fc.getSelectedFile());
     		dispose();
        }
    }
    
    public static void main(String [] args)
    {
    	FileChooserGUI app = new FileChooserGUI();
    }
}