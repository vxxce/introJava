// Zachary Olpin

package fractionclass_zachary.olpin;

import java.util.Scanner;

public class FractionClass_ZacharyOlpin
{

    public static void main(String[] args) throws Exception
    {
        Fraction[] fs;
        Scanner input;
        String toString, reduce, toMixed, getDecimal;

        // Test fractions
        fs = new Fraction[] { new Fraction(380, -68)
                            , new Fraction(0, 3)
                            , new Fraction(-126, -999999992)
                            , new Fraction(-6, 1)
                            , new Fraction()
        };

        input = new Scanner(System.in);
        for (var f : fs)
        {
            toString = reduce = toMixed = getDecimal = "          ";
            
            // User chooses methods to test. Output of selected test, when applicable, displayed
            // next to menu option.
            while (true)
            {
                System.out.printf( "\n+------------------------------------------------------+\n"
                                 + "| 1. toString() %-35s    |\n"
                                 + "| 2. reduce() %-35s      |\n"
                                 + "| 3. toMixed() %-35s     |\n"
                                 + "| 4. getDecimal() %-35s  |\n"
                                 + "| 5. Next                                              |\n"
                                 + "+------------------------------------------------------+\n"
                                 + "Select a method to test or skip to the next Fraction:   \n"
                                 , toString, reduce, toMixed, getDecimal
                );

                switch (input.nextInt())
                {
                    case 1:
                        toString = "---->  " + f.toString();
                        continue;
                    case 2:
                        reduce = "------>    " + "\u2713";
                        f.reduce();
                        continue;
                    case 3:
                        toMixed = "----->  " + f.toMixed();
                        continue;
                    case 4:
                        getDecimal = "-->  " + String.format("%.7f", f.getDecimal());
                        continue;
                    case 6:
                        input.close();
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        break;
                }
                break;
            }
        }
        input.close();
        System.exit(0);
    } 
}
