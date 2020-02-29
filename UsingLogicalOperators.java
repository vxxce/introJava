// Zachary Olpin
package usinglogicaloperators;

import java.util.Scanner;

public class UsingLogicalOperators
{

    public static void main(String[] args)
    {
        int userInt;
        Scanner input;

        // Get integer from user
        input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        userInt = input.nextInt();
        input.close();

        // Determine whether userInt evenly divisible by 5 (AND|OR|XOR|NOR) 6
        if (userInt % 5 == 0 || userInt % 6 == 0)
        {
            if (userInt % 5 == 0 ^ userInt % 6 == 0)
            {
                System.out.printf("\n%d is evenly divisible by 5 or 6, but not both.\n\n", userInt); // XOR ( ⊢OR)
            }
            else if (userInt % 5 == 0 && userInt % 6 == 0)
            {
                System.out.printf("\n%d is evenly divisible by both 5 and 6.\n\n", userInt); // AND
            }
        }
        else
        {
            System.out.printf("\n%d is not evenly divisible by 5 or 6.\n\n", userInt); // NOR
        }       
    }
    
}
