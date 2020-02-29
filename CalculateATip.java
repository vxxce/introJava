// Zachary Olpin
package calculateatip;

import java.util.*;

public class CalculateATip {

    public static void main(String[] args)
    {
        Scanner input;
        int bill;
        int tipRate;
        int tip;
        int total;

        input = new Scanner(System.in);

        // Handle invalid inputs (e.g. $14.20)
        do
        {
            System.out.print("Enter your bill total: ");
            if (input.hasNextFloat())
            {
                bill = (int)(input.nextFloat() * 100);
            } else
            {
                bill = -1;
                input.nextLine();
                System.out.println("Invalid input. Input should be a real number. Do not include the dollar symbol.");
            }
        } while (bill < 0);

        // Handle invalid inputs (e.g. 15%)
        do
        {
            System.out.print("Enter your tipping rate as whole number (e.g. 15): ");
            if (input.hasNextInt())
            {
                tipRate = input.nextInt();
            } else
            {
                tipRate = -1;
                input.nextLine();
                System.out.println("Invalid input. Input should be a whole number. Do not include the percent symbol.");
            }
        } while (tipRate < 0);
        
        input.close();
        
        tip = (int)((tipRate * 0.01) * bill);
        total = tip + bill;
        
        System.out.printf("%.2f\n", bill * 0.01);
        System.out.printf("%.2f\n", tip * 0.01);
        System.out.printf("%.2f\n", total * 0.01);

    }
}
