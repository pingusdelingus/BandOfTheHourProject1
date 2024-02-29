import FactorialUsingMethods.factorial;

import java.util.Scanner;

public class bandHourPractice {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final byte MAX_ROWS = 10;
    private static final byte MAX_POSITIONS = 8;
    private static final byte ROW_START_VAL = 65;
    private static final byte MIN = 0;

    public static void main(String[] args) {
        int numOfRows;

        numOfRows = 0;
        char rowChar, userDecision;

        rowChar = ROW_START_VAL;


        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");

        //calls getNumOfRows method to retrieve the number of rows from the user.
        numOfRows = getNumOfRows(numOfRows);
        //print check



        // Initializes jagged array with numOfRows # of rows

        double[][] bandSetup = new double[numOfRows][];
        // call method to set up size of jagged array
        setupPositionsInRow(bandSetup, numOfRows, rowChar);


        // call method to display the jagged array for the user in the console
        do {
            displayJaggedArray(bandSetup, rowChar);


            System.out.println("(A)dd, (R)emove, (P)rint,          e(X)it : p");
            userDecision = Character.toUpperCase(keyboard.next().charAt(0));
            switch (userDecision) {
                case 'A':

                    // run addBandMember METHOD
                    addBandMember(bandSetup);

                    break;
                case 'R':

                    //run removeBandMember METHOD
                    removeBandMember(bandSetup);
                    break;
                case 'P':
                    displayJaggedArray(bandSetup, rowChar);
                case 'X':

                    //exit code and end main METHOD
                    break;
                default:
            }// end of switch statement
            if (userDecision != 'X'){
                System.out.println("ERROR: Invalid option, try again");
            }
        } while (userDecision != 'X');


    }// end of the main METHOD

    private static int getNumOfRows(int numberRows) {
        System.out.println("Please enter number of rows");
        numberRows = keyboard.nextInt();
        do {
            if (numberRows > MIN && numberRows <= MAX_ROWS) {
                return numberRows;
            } else {
                System.out.println("ERROR: Out of range, try again");
                numberRows = keyboard.nextInt();
            }
        } while (numberRows <= MIN || numberRows > MAX_ROWS);

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
        double sum, average;
        sum = 0;


        System.out.println("Current Band of the Hour Arrangement :D");
        for (index = 0; index < bandSetup.length; index++) {
            charDisplay = (char) (ROW_START_VAL + index);
            System.out.print(charDisplay + ":   ");
            for (jdex = 0; jdex < bandSetup[index].length; jdex++) {

                System.out.print(bandSetup[index][jdex]);
                System.out.print("     ");
                sum = sum + bandSetup[index][jdex];


            }// end of for loop
            average = sum / bandSetup[index].length;

            System.out.print("                       [  " + sum + ",   " + average + " ]");
            System.out.println();
            sum = 0;
            average = 0;
        }


    }// end of the displayJaggedArray METHOD

    private static void addBandMember(double[][] bandSetup) {
        int offset, rowLetterInt, positionNumber;
        char rowLetter;
        double musicianWeight;
        boolean weightBool;


        // asks user for which row they wish to add a band member into
        System.out.println("Please enter row letter");

        rowLetter = Character.toUpperCase(keyboard.next().charAt(0));


        while ((int) rowLetter < ROW_START_VAL || ((int) rowLetter > 75)) {
            System.out.println("ERROR: Out of range, try again");
            rowLetter = keyboard.next().charAt(0);

        }// end of the while loop

        rowLetterInt = (int) rowLetter;
        offset = rowLetterInt;
        offset = offset - ROW_START_VAL;


        System.out.println("Please enter position number (1 to " + (bandSetup[offset].length) + ")");
        positionNumber = keyboard.nextInt();

        while (positionNumber < 0 || positionNumber > bandSetup[offset].length) {
            System.out.println("ERROR: Out of range, try again");
            positionNumber = keyboard.nextInt();

        }// end of the while loop
        if (bandSetup[offset][positionNumber -1] != 0.0){
            System.out.println("ERROR: There is already a musician there.");
            return;
        }

        System.out.println("Please enter weight (45.0 to 200.0 kg)");

        musicianWeight = keyboard.nextDouble();
        while (musicianWeight < 45.0 || musicianWeight > 200.0) {
            System.out.println("ERROR: Out of range, try again");
            musicianWeight = keyboard.nextDouble();


        }// end of the while loop

        // RUN checkWeightOfRow METHOD HERE


        weightBool = checkWeightOfRow(bandSetup, rowLetterInt, musicianWeight);


        if (!weightBool) {
            System.out.println("ERROR: That would exceed the average weight limit.");
            return;
        } else {
            bandSetup[offset][positionNumber - 1] = musicianWeight;
            return;
        }


        // end of the if statement


    }// end of the addBandMember METHOD


    private static boolean checkWeightOfRow(double[][] bandSetup, int rowLetterInt, double musicianWeight) {
        int index, offset;
        double sum;
        sum = 0;
        offset = rowLetterInt - ROW_START_VAL;

        for (index = 0; index < bandSetup[offset].length; index++) {
            sum += bandSetup[offset][index];


        }// end of the for loop


        if (sum + musicianWeight  < 100 * bandSetup[offset].length + 1) {
            return true;

        } else {
            return false;
        }


    }// end of the checkWeightOfRow METHOD


    private static void removeBandMember(double[][] bandSetup) {
        int offset, rowLetterInt, positionNumber;
        char rowLetter;


        // asks user for which row they wish to add a band member into
        System.out.println("Please enter row letter");
        rowLetter = Character.toUpperCase(keyboard.next().charAt(0));


        rowLetterInt = (int) rowLetter;

        offset = (int) rowLetter;
        offset = offset - ROW_START_VAL;

        while (rowLetterInt > 75 && rowLetterInt < 65) {
            System.out.println("ERROR: Out of range, try again");
            rowLetter = keyboard.next().charAt(0);
            rowLetterInt = (int) rowLetter;
            offset = (int) rowLetter;
            offset = offset - ROW_START_VAL;

        }
        System.out.println("Please enter Position Number (1 to " + bandSetup[offset].length + ")");
        positionNumber = keyboard.nextInt();

        while (positionNumber < 0 || positionNumber > bandSetup[offset].length) {
            System.out.println("ERROR: Out of range, try again");
            positionNumber = keyboard.nextInt();

        }
        if (bandSetup[offset][positionNumber - 1] == 0.0) {
            System.out.println("ERROR: That position is vacant.");
            return;
        }

        bandSetup[offset][positionNumber - 1] = 0.0;
        return;

    }// end of the removeBandMember METHOD


}// end of the bandHourPractice CLASS
