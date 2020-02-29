// Zachary Olpin
package theadditiongame;

import java.util.*;

public class TheAdditionGame
{

    public static void main(String[] args)
    {
        Scanner input;
        int rounds, addend1, addend2, attempt, correct;

        input = new Scanner(System.in);
        System.out.println("How many addition problems would you like to attempt? ");
        rounds = input.nextInt();
        
        correct = 0;
        for (int i = 0; i < rounds; i++)
        {
            addend1 = 10 + (int) (Math.random() * 41);
            addend2 = 10 + (int) (Math.random() * 41);
            System.out.printf( "------------------------------\n"
            + "Problem #%d: What is %d + %d? "
            , i + 1
            , addend1
            , addend2);
            
            attempt = input.nextInt();
            
            if (attempt == addend1 + addend2)
            {
                correct++;
                System.out.printf("\nThat's correct!\n\nThat puts you at %d for %d.\n\n"
                , correct
                , i + 1);
            }
            else
            {
                System.out.printf(
                    "\nNo, sorry, the answer was %d.\n\nYour score is now %d for %d.\n\n"
                    , addend1 + addend2
                    , correct
                    , i + 1);
                }
            }
            System.out.printf("\nAnd that's the final score! Thanks for playing! %c \n\n", 128512);
            input.close();
        }
    }
    