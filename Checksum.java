// Zachary Olpin
package checksum;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Checksum
{

    public static void main(String[] args)
    {
        int isbnIn, divisor, checksum, more;
        String isbnOut;
        ArrayList<Integer> digits;
        JFrame input;
        Object response;
                
        do
        {
            // Read in user's ISBN digits as Integer
            input = new JFrame();
            response = JOptionPane.showInputDialog(input, "Enter the first 9 digits of an ISBN number: ");
            isbnIn = Integer.parseInt(response.toString());
            isbnOut = String.format("%9s", String.valueOf(isbnIn)).replace(" ", "0");

            // Multiply each ISBN digit by its position and store in ArrayList
            divisor = 100000000;
            digits = new ArrayList<>(10);
            do
            {
                digits.add((isbnIn / divisor) * (digits.size() + 1));
                isbnIn %= divisor;
                divisor /= 10;
            }
            while (digits.size() < 9);

            // calculate checksum
            checksum = digits
                           .stream()
                           .reduce(0, Integer::sum) % 11;

            // Print result (replacing checksum digit with X if necessary)
            if (checksum > 9)
            {
              more = JOptionPane.showConfirmDialog(
                         null
                         , "The ISBN-10 number is: \n\n"
                         + String.format("%20s", isbnOut + "-X")
                         + "\n\nDo you want to enter another? "
                         , "ISBN-10 CHECKSUM"
                         , JOptionPane.YES_NO_OPTION);
            }
            else
            {
               more = JOptionPane.showConfirmDialog(
                          null
                          , "The ISBN-10 number is: \n\n"
                          + String.format("%20s", isbnOut + "-" + String.valueOf(checksum))
                          + "\n\nDo You Want to enter another? "
                          , "ISBN-10 CHECKSUM"
                          , JOptionPane.YES_NO_OPTION); 
            }
        } while (more == 0);
        
      System.exit(0);
    }
}
