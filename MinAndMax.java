// Zachary Olpin
package minandmax;

import javax.swing.JOptionPane;

public class MinAndMax
{

    public static void main(String[] args)
    {
        int smallest, largest, repeat, input;
        
        // Initialize largest and smallest with edge values most likely to be re-assigned on input
        largest = Integer.MIN_VALUE;
        smallest = Integer.MAX_VALUE;
        do
        {
            input = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a whole number: "));
            
            if (input > largest)
            {
                largest = input;
            }
            else if (input < smallest)
            {
                smallest = input;
            }
            repeat = JOptionPane.showConfirmDialog(null, "Would you like to enter another number?");
        } while (repeat == 0);
        
         // If a user enters only one value, this assigns both largest and smallest to be that value
        if (largest == Integer.MIN_VALUE)
        {
            largest = smallest;
        }
        else if (smallest == Integer.MAX_VALUE)
        {
            smallest = largest;
        }
        
        JOptionPane.showMessageDialog( null
                                     , String.format( "Your smallest value: %d\n"
                                                    + "Your largest value: %d"
                                                    , smallest
                                                    , largest )
                                     );
        System.exit(0);
    }
    
}
