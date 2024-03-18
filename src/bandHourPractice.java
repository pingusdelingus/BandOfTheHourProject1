/**
 * This program is a band management system that allows the user to add
 * and remove band members from a jagged array.
 @author Esteban Morales
 */



import java.util.Scanner;

public class bandHourPractice {
    /* Importing Scanner class to allow user input.
     @import Scanner class
      */
    public static final Scanner keyboard = new Scanner(System.in);
    /*
     * Final constants for the program
     * */
    public static final byte MAX_ROWS = 10; // max number of rows
    public static final byte MAX_POSITIONS = 8;
    /*
     * ASCII value for 'A'.
     */
    public static final byte ROW_START_VAL = 65;
    public static final byte MIN = 0;
    /*
     * Main method for the program
     * */
    public static void main(String[] args) {
        int numOfRows;

        numOfRows = 0;
        char rowChar, userDecision;

        rowChar = ROW_START_VAL;


        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");

        /*calls getNumOfRows method to retrieve the number of rows from the user.
         * @param numOfRows
         */
        numOfRows = getNumOfRows(numOfRows);


        /* Initializes jagged array with numOfRows # of rows
         *
         */

        double[][] bandSetup = new double[numOfRows][];
        /* call method to set up size of jagged array
         * @param bandSetup (jagged array of doubles)
         */
        setupPositionsInRow(bandSetup, numOfRows, rowChar);


        /*
         * Do-while loop to allow user to add, remove, or print the jagged array Until 'X' or 'x' is entered.
         */

        do {

            /* call method to display the jagged array for the user in the console
             * @param bandSetup (jagged array of doubles)
             * @param rowChar (char)
             */

            System.out.println("(A)dd, (R)emove, (P)rint,          e(X)it : p");

            /* User input to decide what to do with the jagged array
             * @param userDecision (char)
             */
            userDecision = Character.toUpperCase(keyboard.next().charAt(0));
            /* Switch statement to decide what to do with the jagged array
             * @param userDecision (char)
             */
            switch (userDecision) {
                case 'A':

                    /* run addBandMember METHOD
                     * @param bandSetup (jagged array of doubles)
                     */
                    addBandMember(bandSetup);

                    break;
                case 'R':

                    /*run removeBandMember METHOD
                     * @param bandSetup (jagged array of doubles)
                     */
                    removeBandMember(bandSetup);
                    break;
                case 'P':
                    /* run displayJaggedArray METHOD
                     * @param bandSetup (jagged array of doubles)
                     * @param rowChar (char)
                     */
                    displayJaggedArray(bandSetup, rowChar);
                case 'X':

                    //exit code and end main METHOD
                    break;
                default:
                    /* default case for invalid input
                     * */

                    System.out.println("ERROR: Invalid option, try again:");
                    break;
            }// end of switch statement
            /* do while loop to continue the program until user enters 'X' or 'x'
             * @param userDecision (char)
             */
        } while (userDecision != 'X');


    }// end of the main METHOD

    /** Method to retrieve the number of rows from the user
     * @param numberRows (int)
     * @return numberRows (int)
     */
    public static int getNumOfRows(int numberRows) {
        System.out.println("Please enter number of rows");
        numberRows = keyboard.nextInt();
        do {
            /* do while loop to check if the number of rows is within the range of 1 to 10

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
    public static void setupPositionsInRow(double[][] bandSetup, int numOfRows, char rowChar) {
        //sets up the jagged array values
        int index, numPositions;


        for (index = 0; index < numOfRows; index++) {
            rowChar = (char) (ROW_START_VAL + index);
            System.out.println("Please enter the number of positions in row " + rowChar);
            numPositions = keyboard.nextInt();
            /* while loop to check if the number of positions is within the range of 1 to 8.
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
    public static void displayJaggedArray(double[][] bandSetup, char charDisplay) {

        int index, jdex, maxPositions, maxWeightWidth, sumAvgWidth, positionsInRows;
        double sum, average;

        maxWeightWidth = 5;
        sum = 0;
        maxPositions = 0;
        positionsInRows = 0;


        for( double[] row : bandSetup){
            if (row.length > maxPositions){
                maxPositions = row.length;
            }
            for (double weight : row) {
                String weightString = String.valueOf(weight);
                if (weightString.length() > maxWeightWidth){
                    maxWeightWidth = weightString.length();
                }
            }
        }

        sumAvgWidth = maxWeightWidth + 9;

        System.out.println("Current Band of the Hour Arrangement :D");

        for (index = 0; index < bandSetup.length; index++) {
            charDisplay = (char) (ROW_START_VAL + index);
            System.out.printf("%-4s:   ", charDisplay);
            positionsInRows = bandSetup[index].length;

            for (jdex = 0; jdex < maxPositions; jdex++) {
                if (jdex < positionsInRows) {
                    System.out.printf("%-" + maxWeightWidth + ".1f     ", bandSetup[index][jdex]);
                    sum = sum + bandSetup[index][jdex];
                } else {
                    System.out.printf("%-" + maxWeightWidth + "s     ", "");
                }





            }// end of for loop
            average = sum / bandSetup[index].length;

            System.out.printf(" [ %-" + sumAvgWidth + ".1f, %-" + sumAvgWidth + ".1f ]%n", sum, average);

            sum = 0;
            average = 0;
        }


    }// end of the displayJaggedArray METHOD


    /** Method to add a band member to the jagged array
     * @param bandSetup (jagged array of doubles)
     */
    public static void addBandMember(double[][] bandSetup) {
        int offset, rowLetterInt, positionNumber;
        char rowLetter;
        double musicianWeight;
        boolean weightBool;


        // asks user for which row they wish to add a band member into
        System.out.println("Please enter row letter");

        rowLetter = Character.toUpperCase(keyboard.next().charAt(0));


        while ((int) rowLetter < ROW_START_VAL || ((int) rowLetter > 75)) {
            System.out.println("ERROR: Out of range, try again");
            rowLetter = Character.toUpperCase(keyboard.next().charAt(0));

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
            System.out.println("****** Musician added.");
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
    public static boolean checkWeightOfRow(double[][] bandSetup, int rowLetterInt, double musicianWeight) {
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
    public static void removeBandMember(double[][] bandSetup) {
        int offset, rowLetterInt, positionNumber;
        char rowLetter;


        /* asks user for which row they wish to remove a band member into
         * @param rowLetter (char)
         */
        System.out.println("Please enter row letter");
        rowLetter = Character.toUpperCase(keyboard.next().charAt(0));


        rowLetterInt = (int) rowLetter;

        offset = (int) rowLetter;
        offset = offset - ROW_START_VAL;

        while (rowLetterInt > 75 || rowLetterInt < 65) {
            System.out.println("ERROR: Out of range, try again");
            rowLetter = Character.toUpperCase(keyboard.next().charAt(0));
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
