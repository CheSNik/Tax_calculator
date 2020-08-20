import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Double.parseDouble;

/**
 * Assignment 4 E5.18
 * @author Sergei Chekhonin
 * This program computes income tax according to 1913 schedule
 */

public class Main {

    public static void main(String[] args) {
        PrintWriter out = null;
        try {
            out = new PrintWriter("Assignment4_E5.18output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String input = JOptionPane.showInputDialog("Enter your year income in US dollars:");
        /**
         * stores input income
         */
        double income = parseDouble(input);

        /**
         * stores income
         */
        double taxAmount = computeTax(income);

        out.println(dtf.format(now));
        out.printf("Income of the year is:  $%.2f\n", income);
        out.printf("You have to pay as taxes amount of: $%.2f\n", taxAmount);

        out.close();
    }

    /***
     *
     * @param income input income
     * @return amount of tax
     */
    public static double computeTax(double income)
    {
        double _income = income;
        double tax=0;

        if (_income<=50000)
            tax = income*0.01;
        else if (_income>50000 && _income<=75000)
            tax = income*0.02;
        else if (_income>75000 && _income<=100000)
            tax = income*0.03;
        else if (_income>100000 && _income<=250000)
            tax = income*0.04;
        else if (_income>250000 && _income<=500000)
            tax = income*0.05;
        else if (_income>500000)
            tax = income*0.06;

        return tax;

    }
}
