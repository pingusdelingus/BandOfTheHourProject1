package FactorialUsingMethods;

import java.util.Scanner;



public class nChooseX {
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        int dataFromUser, result;

        // creating class object factorialFunction
        factorial factObject = new factorial();
        System.out.println("What number would you like to see it's factorial?");
        dataFromUser = keyboard.nextInt();

        result = factObject.computeFactorial(dataFromUser);


        System.out.println("The result is: " + result);









    }// end of the main METHOD

}// end of the FactorialUsingMethods.nChooseX METHOD
