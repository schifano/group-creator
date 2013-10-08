package edu.ilstu;
/*
 * Filename: CheckoutBanner.java
 * Sep 17, 2013
 * 
 * ULID: jdboomg
 * Course: IT226
 * Instructor: Cathy Holbrook
 */
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author John Boomgarden
 * 
 *  This class will create a banner to display the total cost of registration, along with
 *  headers above the entry of credit card information. 
 */

public class CheckoutBanner extends JPanel
{
   /**
	 *
	 */
	private static final long serialVersionUID = -3336335515681241903L;

/**
   * This will create a banner and format the total cost that is passed in.
   * @param totalCost - integer which represents the number of cents, not dollars.This will be formatted 
   * and displayed at the top of the panel. 
   */
   public CheckoutBanner(int totalCost)
   {
	   Font largerFont = new Font("Serif", Font.BOLD, 18);
	   Font smallerFont = new Font("Serif", Font.BOLD, 14);
 	   NumberFormat fmt = NumberFormat.getCurrencyInstance(); 
	   String dollarAmt;
	   dollarAmt = fmt.format(totalCost/100);
	   setLayout(new GridLayout(0, 1));
	   
	   // large font header to display the total cost of their registration.
     JLabel chkout = new JLabel("The total cost of your registration is " + dollarAmt);
     JLabel empty = new JLabel(""); // empty label for space
     JLabel empty1 = new JLabel(""); // empty label for space
     
     
     // header which will be above the section of the frame created by CreditCardList
     JLabel cardInfo = new JLabel ("Please enter your credit card information below. ");
     
     
     // header which will be above the section of the frame created by DateWindow 
     JLabel expiration = new JLabel("Expiration date of your credit card                                 ");
     
     // center the headers for the total cost and the asking for credit card information.
     chkout.setHorizontalAlignment(JLabel.CENTER);
     cardInfo.setHorizontalAlignment(JLabel.CENTER);
     
     // enlarge the font of the header which displays how much money they owe
     chkout.setFont(largerFont);
     cardInfo.setFont(smallerFont);
     
     // format the label asking them to enter the expiration date of the credit card
     expiration.setHorizontalAlignment(JLabel.RIGHT);
     
     add(empty);// add 1 empty space to move the header showing the total amount of money down from the top
     add(chkout);//add the header which displays the amount of money the user owes
     add(empty1);// add empty space for readability
     add(cardInfo);// add header above the radio buttons for different types of cards
     add(expiration); //add header above the DateWindow object which will display windows asking for expiration date. 
    }

   
}