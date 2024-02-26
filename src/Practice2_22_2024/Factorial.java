package Practice2_22_2024;
import java.util.Scanner;

public class Factorial {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
    long candidate,input, result;
    input = 0;
    //Call getCandidate METHOD and starts retrieves candidate from user.
    candidate = getCandidate(input);
    //calls calcFactorial method and calculates factorial of candidate
    result = calcFactorial(candidate);





    }// end of the main METHOD

    private static long getCandidate(long candidate){
       // asks user for candidate and returns candidate from method into candidate variable in main METHOD

        candidate = keyboard.nextInt();
        return candidate;


    }// end of the getCandidate METHOD

    private static long calcFactorial(long candidate){
        long index;
        long factorialResult;
        factorialResult = 1;
        /* for loop multiplies index by itself all the way until the value of the candidate i.e. if candidate = 4,
        code will run 1 times 1 times 2 times 3 times 4, then return result*/
        for (index = 1; index <= candidate; index++){
            factorialResult = factorialResult * index;
        }// end of the for loop
        return  factorialResult;
    }// end of the calcFactorial METHOD

}// end of the Factorial CLASS
