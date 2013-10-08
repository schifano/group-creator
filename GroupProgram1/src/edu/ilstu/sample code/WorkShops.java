package edu.ilstu;
/*
 * Filename: WorkShops.java
 * Sep 19, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  @author John Boomgarden
 *  
 *  This class will create a list of 4 different workshops at a JAVA conference. 
 *  Workshops can be added, or removed by just changing the constants at the beginning of this class. 
 *   
 */

public class WorkShops extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7754826830859156347L;
	private boolean[] workshopIndicators;
	private static final int NUMWORKSHOPS = 4;
	private static final String[] WORKSHOP_NAMES = {"Introduction to E-Commerce","The Future of the Web", "Advanced JAVA Programming",
		                                            "Network Security"};
	private static final int [] WORKSHOP_PRICES = {29500,29500,39500,39500};
   /**
    *  Constructor to build the frame with the list of workshops
    */

   public WorkShops()
   {
 	   	NumberFormat fmt = NumberFormat.getCurrencyInstance(); 
 	   	String dollarAmt;
 	   	JCheckBox workshopBoxes[] = new JCheckBox[NUMWORKSHOPS];
      // Create a GridLayout manager with 
      // number of rows from number of workshops and two columns.
      setLayout(new GridLayout(NUMWORKSHOPS + 1, 2));
      
      setBorder(BorderFactory.createTitledBorder("Optional Preconference Workshops"));
      
      // add the first two labels which will serve as headers above each column
      JLabel header1 = new JLabel("Workshop");
      add (header1);
      JLabel header2 = new JLabel("Fee");
      add (header2);
      
      // Create the check boxes.
		workshopIndicators = new boolean[NUMWORKSHOPS];
		for(int i=0;i<NUMWORKSHOPS;i++)
		{
			setWorkshopsIndicator(i, false);
			workshopBoxes[i] = new JCheckBox(WORKSHOP_NAMES[i]);
	  		add(workshopBoxes[i]);
	  		workshopBoxes[i].addActionListener(new BoxListener(i)); 
	 	   	dollarAmt = fmt.format(WORKSHOP_PRICES[i]/100);
	  		JLabel feeList = new JLabel (dollarAmt);
	  		add (feeList);
		}

   }
   /*
    * This private inner class will check to see which checkbox is checked, and set that same indicator to be true. 
    */
   private class BoxListener implements ActionListener  
   {  
      private final int i;   
     
      public BoxListener(int i)  
      {  
          this.i = i;  
      }  
     
      
      public void actionPerformed(ActionEvent evt)  
      {  
         workshopIndicators[i] = true;
      }  
   }  

   /**
    *  This method will figure the cost of all the optional workshops, based on which indicator is set.  
    *   
    */
   public void setWorkshopsIndicator(int i, boolean validity)
   {
	   workshopIndicators[i] = validity;
   }
   public int getWorkshopsCost()
   {
     
      int workshopCost = 0;
      
		for(int i=0;i<NUMWORKSHOPS;i++)
		{
			if (workshopIndicators[i])
				workshopCost += WORKSHOP_PRICES[i];
		}
      // Return the total cost.
      return workshopCost;
   	}
}