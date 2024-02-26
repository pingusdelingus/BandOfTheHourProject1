import java.util.Scanner;

public class bandHourPractice {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final byte MAX_ROWS = 10;
    private static final byte MAX_POSITIONS = 8;
    private static final byte ROW_START_VAL = 65;


    public static void main(String[] args) {
        int numOfRows,

        numOfRows = 0;
        char rowChar, userDecision;

        rowChar = ROW_START_VAL;


        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");

        //calls getNumOfRows method to retrieve the number of rows from the user.
        numOfRows = getNumOfRows(numOfRows);
        //print check
        System.out.println("The number of rows is :" + numOfRows);


        // Initializes jagged array with numOfRows # of rows

        double[][] bandSetup = new double[numOfRows][];
        // call method to setup size of jagged array
        setupPositionsInRow(bandSetup, numOfRows, rowChar);


        // call method to display the jagged array for the user in the console
        do {
            displayJaggedArray(bandSetup, rowChar);


            System.out.println("(A)dd, (R)emove, (P)rint,          e(X)it : p");
            userDecision = keyboard.next().charAt(0);
            switch (userDecision){
                case 'A':
                    // run addBandMember METHOD
                    break;
                case 'R':
                    //run removeBandMember METHOD
                    break;
                case 'X':
                    //exit code and end main METHOD
                    break;
            }// end of switch statement
        } while (keyboard.next().charAt(0) != 'X');


    }// end of the main METHOD

    private static int getNumOfRows(int numberRows) {
        System.out.println("Please enter number of rows");
        numberRows = keyboard.nextInt();
        do {
            if (numberRows > 0 && numberRows <= MAX_ROWS) {
                return numberRows;
            } else {
                System.out.println("ERROR: Out of range, try again");
                numberRows = keyboard.nextInt();
            }
        } while (numberRows < 0 || numberRows > MAX_ROWS);

        return numberRows;

    }// end of the getNumOfRows METHOD

    private static void setupPositionsInRow(double[][] bandSetup, int numOfRows, char rowChar) {
        //sets up the jagged array values
        int index, numPositions;



        for (index = 0; index < numOfRows; index++) {
            rowChar = (char) (ROW_START_VAL + index);
            System.out.println("Please enter the number of positions in row " + rowChar);
            numPositions = keyboard.nextInt();
            while (numPositions < 0 || numPositions > MAX_POSITIONS) {
                System.out.println("ERROR: Out of range, try again");
                numPositions = keyboard.nextInt();
            }

            bandSetup[index] = new double[numPositions];


        }// end of the for loop


    }// end of the setupPositionsInRow METHOD

    private static void displayJaggedArray(double[][] bandSetup, char charDisplay) {
        // displaying contents of the array created :D
        int index, jdex;


        System.out.println("Current Band of the Hour Arrangement :D");
        for (index = 0; index < bandSetup.length; index++) {
            charDisplay = (char) (ROW_START_VAL + index);
            System.out.print(charDisplay + ":   ");
            for (jdex = 0; jdex < bandSetup[index].length; jdex++) {

                System.out.print(bandSetup[index][jdex]);
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println();


    }// end of the displayJaggedArray METHOD




}// end of the bandHourPractice CLASS
