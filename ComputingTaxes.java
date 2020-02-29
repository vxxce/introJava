// Zachary Olpin
package computingtaxes;

import java.util.Scanner;

public class ComputingTaxes
{

    public static void main(String[] args)
    {
        int status;
        double income;
        double tax;
        Scanner input;

        // Get filing status
        input = new Scanner(System.in);
        System.out.print("Choose a filing status from the following options.\n"
            + "\t0: Single\n"
            + "\t1: Married (filing jointly) or widow(er)\n"
            + "\t2: Married (filing separately)\n"
            + "\t3: Head of Household\n"
            + "Your status: ");
        status = input.nextByte();

        // Get taxable income
        System.out.print("Enter your taxable income: ");
        income = input.nextDouble();
        input.close();
        
        
        // Calculate taxes owed
        tax = 0;
        switch (status)
        {
            // Single
            case 0:
                if (income > 372950)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25
                        + (171550 - 82250) * 0.28
                        + (372950 - 171550) * 0.33
                        + (income - 372950) * 0.35;
                } else if (income > 171550)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25
                        + (171550 - 82250) * 0.28
                        + (income - 171550) * 0.33;
                } else if (income > 82250)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25
                        + (income - 82250) * 0.28;
                } else if (income > 33950)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (income - 33950) * 0.25;
                } else if (income > 8350)
                {
                    tax = 8350 * 0.10
                        + (income - 8350) * 0.15;
                } else
                {
                    tax = income * 0.10;
                }   break;
            // Married (filing jointly) or widow(er)
            case 1:
                if (income > 372950)
                {
                    tax = 16700 * 0.10
                        + (67900 - 16700) * 0.15
                        + (137050 - 67900) * 0.25
                        + (208850 - 137050) * 0.28
                        + (372950 - 208850) * 0.33
                        + (income - 372950) * 0.35;
                } else if (income > 208850)
                {
                    tax = 16700 * 0.10
                        + (67900 - 16700) * 0.15
                        + (137050 - 67900) * 0.25
                        + (208850 - 137050) * 0.28
                        + (income - 208850) * 0.33;
                } else if (income > 137050)
                {
                    tax = 16700 * 0.10
                        + (67900 - 16700) * 0.15
                        + (137050 - 67900) * 0.25
                        + (income - 137050) * 0.28;
                } else if (income > 67900)
                {
                    tax = 16700 * 0.10
                        + (67900 - 16700) * 0.15
                        + (income - 67900) * 0.25;
                } else if (income > 16700)
                {
                    tax = 16700 * 0.10
                        + (income - 16700) * 0.15;
                } else
                {
                    tax = income * 0.10;
                }   break;
            // Married (filing separately)
            case 2:
                if (income > 186475)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (68525 - 33950) * 0.25
                        + (104425 - 68525) * 0.28
                        + (186475 - 104425) * 0.33
                        + (income - 186475) * 0.35;
                } else if (income > 104425)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (68525 - 33950) * 0.25
                        + (104425 - 68525) * 0.28
                        + (income - 104425) * 0.33;
                } else if (income > 68525)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (68525 - 33950) * 0.25
                        + (income - 68525) * 0.28;
                } else if (income > 33950)
                {
                    tax = 8350 * 0.10
                        + (33950 - 8350) * 0.15
                        + (income - 33950) * 0.25;
                } else if (income > 8350)
                {
                    tax = 8350 * 0.10
                        + (income - 8350) * 0.15;
                } else
                {
                    tax = income * 0.10;
                }   break;
            // Head of household
            case 3:
                if (income > 372950)
                {
                    tax = 11950 * 0.10
                        + (45500 - 11950) * 0.15
                        + (117450 - 45500) * 0.25
                        + (190200 - 117450) * 0.28
                        + (372950 - 190200) * 0.33
                        + (income - 372950) * 0.35;
                } else if (income > 190200)
                {
                    tax = 11950 * 0.10
                        + (45500 - 11950) * 0.15
                        + (117450 - 45500) * 0.25
                        + (190200 - 117450) * 0.28
                        + (income - 190200) * 0.33;
                } else if (income > 117450)
                {
                    tax = 11950 * 0.10
                        + (45500 - 11950) * 0.15
                        + (117450 - 45500) * 0.25
                        + (income - 117450) * 0.28;
                } else if (income > 45500)
                {
                    tax = 11950 * 0.10
                        + (45500 - 11950) * 0.15
                        + (income - 45500) * 0.25;
                } else if (income > 11950)
                {
                    tax = 11950 * 0.10
                        + (income - 11950) * 0.15;
                } else
                {
                    tax = income * 0.10;
                }
                break;
            default:
                System.out.println("Error: invalid status");
                System.exit(1);
                break;
        }

        // Print calculated taxes 
        System.out.print("\n ------------------------------\n");
        System.out.printf( "|%14s  %11.2f $ |\n"
                         + "|%14s  %11.2f $ |\n"
                         + "|------------------------------|\n"
                         + "|%14s  %11.2f $ |\n"
                         + " ------------------------------\n\n"
                         , "Gross income:", income, "- Taxes owed:", tax, "Net income:", income - tax);
    }
}

/*****************************
Test inputs:

    (status, income) => taxes
    
    (0,      1)  =>      0.10
    (0,   8352)  =>    835.30
    (0,  33952)  =>   4675.50
    (0,  82252)  =>  16750.56
    (0, 171552)  =>  41754.66
    (0, 372953)  => 108217.05
    (1,      1)  =>      0.10
    (1,  16702)  =>   1670.30
    (1,  67902)  =>   9350.50
    (1, 137051)  =>  26637.78
    (1, 208851)  =>  46741.83
    (1, 372952)  => 100895.20
    (2,      1)  =>      0.10
    (2,   8352)  =>    835.30
    (2,  33952)  =>   4675.50
    (2,  68527)  =>  13319.31
    (2, 104427)  =>  23371.41
    (2, 186477)  =>  50447.95
    (3,      1)  =>      0.10
    (3,  11952)  =>   1195.30
    (3,  45502)  =>   6228.00
    (3, 117452)  =>  24215.56
    (3, 190202)  =>  44585.66
    (3, 372952)  => 104893.20

******************************/