/*
Algorithm taken heavily from Micah Stairs from
http://www.problemvault.com/#problem333
As best as possible, I have modified it
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Dice {

    private static double s1;
    private static int k;

    private static List<List<Double>> listOfLists = new ArrayList<>();
    static Double[][] memo;

    public static void main(String[] args) throws FileNotFoundException {

       Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int s = in.nextInt();
        s1 = (double) s;
        k = in.nextInt();
        memo = new Double[n + 1][s + 1];
        out.printf("%.7f", calc(n,0));
    }

    private static double calc(int numThrowsLeft, int numNumsSeen) {


        if (numNumsSeen >= k) return 1.0;
        if (numThrowsLeft == 0) return 0.0;

        if (memo[numThrowsLeft][numNumsSeen] != null)
            return memo[numThrowsLeft][numNumsSeen];

        double probabilityOfOldNumber = (double) numNumsSeen / s1;
        double probabilityOfNewNumber = 1.0 - probabilityOfOldNumber;

        double probability = probabilityOfOldNumber * calc(numThrowsLeft - 1, numNumsSeen) + probabilityOfNewNumber * calc(numThrowsLeft - 1, numNumsSeen + 1);

        return memo[numThrowsLeft][numNumsSeen] = probability;
    }
}