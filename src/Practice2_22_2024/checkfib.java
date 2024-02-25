package Practice2_22_2024;

import java.util.Scanner;

public class checkfib {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final double PHI = (1 + Math.sqrt(5)) / 2;
    private static final double PSI = (1 - Math.sqrt(5) / 2);


    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long inputNum;
        boolean returnVal;



        System.out.println("Enter the number you wish to check if it is a Fibonacci Number or not: ");
        inputNum = keyboard.nextLong();


        returnVal = FibChecking(inputNum);

        System.out.println("It is: " + returnVal + " that your number: " + inputNum + " is a fibonacci number");
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("This program took: " + totalTime);


    }// end of the main METHOD

    private static boolean FibChecking(long n) {
        double fn, error;
        long truefib;

        fn = ((Math.pow(PHI, n)) - (Math.pow(PSI, n))) / Math.sqrt(5);
        truefib = NthFibRecur(n);

        error = truefib - fn;

        if (error < 0.2) {
            return true;
        }
        else {
            return false;
        }

    }// end of the FibChecking METHOD


    private static long NthFibRecur(long inputNum) {
        long first, second, third, index;
        first = 0;
        second = 1;
        third = 0;

        for (index = 0; index < inputNum -1; index++) {
            third = first + second;
            first = second;
            second = third;

        }// end of for loop

        return third;

    }// end of the NthFibRecur METHOD

}// end of the checkfib CLASS


