package FactorialUsingMethods;
import java.util.Scanner;


public class factorial {
    private static final Scanner keyboard = new Scanner(System.in);
    private int userInput;
    public factorial(){
        userInput = 0;


    }// end of factorial CONSTRUCTOR METHOD

    public void readInput() {
        userInput = keyboard.nextInt();

    }// end of readInput METHOD

    public void writeOutput() {
        System.out.println(userInput);

    }// end of the writeOutput METHOD

    public int computeFactorial(int factorialThisInt){
        int index, factorialResult;
        factorialResult = 1;

        for (index = 1; index <= factorialThisInt; index++) {
            factorialResult = factorialResult * index;
        }// end of the for loop
        return  factorialResult;

    }// end of computeFactorial  METHOD


}// end of the factorial CLASS
