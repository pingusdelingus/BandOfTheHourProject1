/**
 * This program is a band management system that allows the user to add
 * and remove band members from a jagged array.
 @author Esteban Morales
 */



import java.util.Scanner;

public class bandHourPractice {
    /** Importing Scanner class to allow user input.
     @imports Scanner class
      */
    private static final Scanner keyboard = new Scanner(System.in);
    /**
     * Final constants for the program
     * */
    private static final byte MAX_ROWS = 10;
    private static final byte MAX_POSITIONS = 8;
    /**
     * ASCII value for 'A'.
     */
    private static final byte ROW_START_VAL = 65;
    private static final byte MIN = 0;
    /**
     * Main method for the program
     * */
    public static void main(String[] args) {
        int numOfRows;

        numOfRows = 0;
        char rowChar, userDecision;

        rowChar = ROW_START_VAL;


        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");

        /**calls getNumOfRows method to retrieve the number of rows from the user.
         * @param numOfRows
         */
        numOfRows = getNumOfRows(numOfRows);


        /** Initializes jagged array with numOfRows # of rows
         *
         */

        double[][] bandSetup = new double[numOfRows][];
        /** call method to set up size of jagged array
         * @param bandSetup (jagged array of doubles)
         */
        setupPositionsInRow(bandSetup, numOfRows, rowChar);


        /**
         * Do-while loop to allow user to add, remove, or print the jagged array Until 'X' or 'x' is entered.
         */

        do {

            /** call method to display the jagged array for the user in the console
             * @param bandSetup (jagged array of doubles)
             * @param rowChar (char)
             */
            displayJaggedArray(bandSetup, rowChar);
            System.out.println("(A)dd, (R)emove, (P)rint,          e(X)it : p");

            /** User input to decide what to do with the jagged array
             * @param userDecision (char)
             */
            userDecision = Character.toUpperCase(keyboard.next().charAt(0));
            /** Switch statement to decide what to do with the jagged array
             * @param userDecision (char)
             */
            switch (userDecision) {
                case 'A':

                    /** run addBandMember METHOD
                     * @param bandSetup (jagged array of doubles)
                     */
                    addBandMember(bandSetup);

                    break;
                case 'R':

                    /**run removeBandMember METHOD
                     * @param bandSetup (jagged array of doubles)
                     */
                    removeBandMember(bandSetup);
                    break;
                case 'P':
                    /** run displayJaggedArray METHOD
                     * @param bandSetup (jagged array of doubles)
                     * @param rowChar (char)
                     */
                    displayJaggedArray(bandSetup, rowChar);
                case 'X':

                    //exit code and end main METHOD
                    break;
                default:
                    /** default case for invalid input
                     * */

                    System.out.println("ERROR: Invalid option, try again:");
                    break;
            }// end of switch statement
            /** do while loop to continue the program until user enters 'X' or 'x'
             * @param userDecision (char)
             */
        } while (userDecision != 'X');


    }// end of the main METHOD

    /** Method to retrieve the number of rows from the user
     * @param numberRows (int)
     * @return numberRows (int)
     */
    private static int getNumOfRows(int numberRows) {
        System.out.println("Please enter number of rows");
        numberRows = keyboard.nextInt();
        do {
            /** do while loop to check if the number of rows is within the range of 1 to 10

             */
            if (numberRows > MIN && numberRows <= MAX_ROWS) {
                return numberRows;
            } else {
                System.out.println("ERROR: Out of range, try again");
                numberRows = keyboard.nextInt();
            }
        } while (numberRows <= MIN || numberRows > MAX_ROWS);

        return numberRows;

    }// end of the getNumOfRows METHOD

    /** Method to set up the size of the jagged array
     * @param bandSetup (jagged array of doubles)
     * @param numOfRows (int)
     * @param rowChar (char)
     */
    private static void setupPositionsInRow(double[][] bandSetup, int numOfRows, char rowChar) {
        //sets up the jagged array values
        int index, numPositions;


        for (index = 0; index < numOfRows; index++) {
            rowChar = (char) (ROW_START_VAL + index);
            System.out.println("Please enter the number of positions in row " + rowChar);
            numPositions = keyboard.nextInt();
            /** while loop to check if the number of positions is within the range of 1 to 8.
             */

            while (numPositions < 0 || numPositions > MAX_POSITIONS) {
                System.out.println("ERROR: Out of range, try again");
                numPositions = keyboard.nextInt();
            }

            bandSetup[index] = new double[numPositions];

        }// end of the for loop


    }// end of the setupPositionsInRow METHOD

    /** Method to display the jagged array for the user
     * @param bandSetup (jagged array of doubles)
     * @param charDisplay (char)
     */
    private static void displayJaggedArray(double[][] bandSetup, char charDisplay) {

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


    /** Method to add a band member to the jagged array
     * @param bandSetup (jagged array of doubles)
     */
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


    /** Method to check the weight of the row
     * @param bandSetup (jagged array of doubles)
     * @param rowLetterInt (int)
     * @param musicianWeight (double)
     * @return boolean
     */

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


    /** Method to remove a band member from the jagged array
     * @param bandSetup (jagged array of doubles)
     */
    private static void removeBandMember(double[][] bandSetup) {
        int offset, rowLetterInt, positionNumber;
        char rowLetter;


        /** asks user for which row they wish to remove a band member into
         * @param rowLetter (char)
         */
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
