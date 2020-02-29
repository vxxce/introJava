// Zachary Olpin
package compoundinterest;

import javax.swing.JOptionPane;

public class CompoundInterest
{

    public static void main(String[] args)
    {
        double monthlySavings;
        double apr;
        double monthlyAccrualRate;
        double accountBalance;

        monthlySavings = Double.parseDouble(JOptionPane.showInputDialog("How much do you save monthly?"));
        apr = Double.parseDouble(JOptionPane.showInputDialog("What is the Annual Percentage Rate (APR) on your savings?"));
        monthlyAccrualRate = 1 + apr / 100 / 12;
        accountBalance = 0;
        for (int i = 0; i < 6; i++)
        {
            accountBalance += monthlySavings;
            accountBalance *= monthlyAccrualRate;
        }
        JOptionPane.showMessageDialog(null,
                String.format( "If you begin with an empty account and save $%.2f a month with an \nAPR of %.2f%%, "
                             + "in 6 months your account balance will be:\t$%.2f.", monthlySavings, apr, accountBalance)
        );
        
    }
}
