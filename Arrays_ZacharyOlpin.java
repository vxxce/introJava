// Zachary Olpin
package arrays_zachary.olpin;

import java.io.File;
import java.util.*;

public class Arrays_ZacharyOlpin
{

   public static void main(String[] args) throws Exception
    {
        Scanner reader;
        int numRows;
        double[] gpas;
        String[] ids, splitLine;

        // Get number of rows in file
        reader = new Scanner(new File("studentdata.txt"));
        numRows = 0;
        while (reader.hasNextLine())
        {
            numRows++;
            reader.nextLine();
        }
        reader.close();

        // Read file and store student data
        ids = new String[numRows];
        gpas = new double[numRows];
        reader = new Scanner(new File("studentdata.txt"));
        for (int i = 0; reader.hasNextLine(); i++)
        {
            splitLine = reader.nextLine().split("\\s\\s");
            ids[i] = splitLine[0];
            gpas[i] = Double.parseDouble(splitLine[1]);
        }
        reader.close();

        // Print student rankings and histogram
        printStudents(ids, gpas);
        printHistogram(gpas);
    }

    private static void printHistogram(double[] gpas)
    {
        int[] gpaBracketTotals;
        double totalStudents;

        // Get count of occurrences of gpas for each bracket
        gpaBracketTotals = new int[8];
        for (Double g : gpas) {
            if (g < 0.5) gpaBracketTotals[0] += 1;
            else if (g >= 0.5 && g < 1.0) gpaBracketTotals[1] += 1;
            else if (g >= 1.0 && g < 1.5) gpaBracketTotals[2] += 1;
            else if (g >= 1.5 && g < 2.0) gpaBracketTotals[3] += 1;
            else if (g >= 2.0 && g < 2.5) gpaBracketTotals[4] += 1;
            else if (g >= 2.5 && g < 3.0) gpaBracketTotals[5] += 1;
            else if (g >= 3.0 && g < 3.5) gpaBracketTotals[6] += 1;
            else if (g >= 3.5) gpaBracketTotals[7] += 1;
        }

        // Print histogram to console
        totalStudents = Arrays.stream(gpaBracketTotals).sum();
        System.out.println( "\nStudent GPA distribution by octile\n"
                          + "----------------------------------------");
        for (int i = 0; i < gpaBracketTotals.length; i++)
        {
            System.out.printf( "%.2f - %.2f: %s [%d]\n"
                             , i * 0.5, i * 0.5 + 0.5
                             , "||".repeat((int) Math.floor((gpaBracketTotals[i] / totalStudents) * 100))
                             , gpaBracketTotals[i]);
        }
    }

    private static void printStudents(String[] ids, double[] gpas)
    {
        HashMap<String, Double> students;
        double[] sortedGpas;
        int[] ranks;
        double lowest;
        int currentRank, ties;
        HashMap<Double, Integer> gpaCounts;

        students = new HashMap<>(ids.length);
        sortedGpas = gpas.clone(); // Avoid mutating original array
        Arrays.sort(sortedGpas);
        ranks = new int[ids.length];
        lowest = 4.0;
        currentRank = ids.length;
        
        // Loop backwards through ids and make a 1-for-1 array of ranks where ranks[n]
        // is the correct rank for the student ID at 
        for (int i = ids.length - 1; i >= 0; i--)
        {
            if (sortedGpas[i] < lowest)
            {
                lowest = sortedGpas[i];
                currentRank = i;
            }
            ranks[i] = ids.length - currentRank + 1;
            
            // Store student data in hashmap for easier lookup
            students.put(ids[i], gpas[i]);
        }

        // Second hashmap with counts for occurrences of each gpa.
        gpaCounts = new HashMap<>(ranks.length);
        for (Double gpa: sortedGpas)
        {
            gpaCounts.put(gpa, gpaCounts.getOrDefault(gpa, 0) + 1);
        }
        
        // Print student ID / Rank / GPA. If rank tied with others, show how many in group.
        for (int i = 0; i < ids.length; i++)
        {
            ties = gpaCounts.get(students.get(ids[i])) - 1;

            if (ties > 0)
            {
                System.out.printf( "\nStudent: %s\nRank: %s%d (with %d others)\nGPA: %.2f\n"
                                 , ids[i]
                                 , "T"
                                 , ranks[Arrays.binarySearch(sortedGpas, students.get(ids[i]))]
                                 , ties
                                 , students.get(ids[i]));
            }
            else
            {
                System.out.printf( "\nStudent: %s\nRank: %d\nGPA: %.2f\n"
                                 , ids[i]
                                 , ranks[Arrays.binarySearch(sortedGpas, students.get(ids[i]))]
                                 , students.get(ids[i]));
            }
        }
    }
    
}
