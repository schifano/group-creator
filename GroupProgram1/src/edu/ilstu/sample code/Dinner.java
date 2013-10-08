package edu.ilstu;
/*
 * Filename: Dinner.java
 * Sep 17, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.awt.GridLayout;
import java.text.NumberFormat;


import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * @author John Boomgarden 
 * 
 *  This class will display a checkbox to ask the user if they would like to attend an optional dinner. 
 *  
 */

public class Dinner extends JPanel
{
     /**
	 * 
	 */
	private static final long serialVersionUID = 3194763921240962341L;

	private final int DINNER_COST = 3000;  // cost of dinner in cents, not dollars

   private JCheckBox dinner;  // checkbox to indicate if user will be attending dinner with keynote speaker
 

   /**
    *  Constructor
    */

   public Dinner()
   {
  
	   NumberFormat fmt = NumberFormat.getCurrencyInstance(); 
	   String dollarAmt;
	   dollarAmt = fmt.format(DINNER_COST/100);
	   setLayout(new GridLayout(0, 1));

      // Create the check boxes.
      dinner = new JCheckBox("If you would like to attend a dinner on the first night of the conference with a special surprise keynote speaker, please check here. The cost will be an additional "+ dollarAmt);
     
       
      // Add the check box to this panel.
      add(dinner);
    }

   /**
    *  The getBasicCost method returns the cost of
    *  the basic registration.
    */

   public int getDinnerCost()
   {
      // Basic registration will normally cost 895.00, which is the amount stored in BASIC_COST
      // For students, the basic cost is 495.00, which is stored in the constant STUDENT_COST
	  int dinnerCost = 0; 
      if (dinner.isSelected())
      {
    	  dinnerCost = DINNER_COST;
      }
            
      // Return the basic registration cost.
      return dinnerCost;
   }
}