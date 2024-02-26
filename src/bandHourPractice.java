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
                case 'a':
                    // run addBandMember METHOD

                    break;
                case 'R':
                case 'r':
                    //run removeBandMember METHOD
                    break;
                case 'X':
                case 'x':
                    //exit code and end main METHOD
                    break;
                default:
                    System.out.println("Uh oh! This shouldn't have happened. Please contact Esteban Morales to fix this.");
            }// end of switch statement
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

    private static void addBandMember(double[][] bandSetup){
    int index, jdex, offset, rowLetterInt, positionNumber;
    char rowLetter;
    double musicianWeight;
    boolean weightBool;

        // asks user for which row they wish to add a band member into
        System.out.println("Please enter row letter");
        rowLetter = keyboard.next().charAt(0);


        rowLetterInt = (int) rowLetter;
        offset = (int) rowLetter;
        offset = offset - ROW_START_VAL;


        do {
            if (offset >= 0 && offset <= 10){
                System.out.println("Please enter position number (1 to" +  (bandSetup[offset].length + 1) + ")");
                positionNumber = keyboard.nextInt();
                while(positionNumber > bandSetup[offset].length || positionNumber < bandSetup[offset].length){
                    System.out.println("ERROR: Out of range, try again");
                    positionNumber = keyboard.nextInt();

                }// end of while loop
                System.out.println("Please enter weight (45.0 to 200.0");

                musicianWeight = keyboard.nextDouble();
                while (musicianWeight < 45.0 || musicianWeight > 200.0){
                    System.out.println("ERROR: Out of range, try again");
                    musicianWeight = keyboard.nextDouble();


                }
                // RUN checkWeightOfRow METHOD HERE
                weightBool = checkWeightOfRow(bandSetup, rowLetterInt);
                if (!weightBool){
                    System.out.println("ERROR: That would exceed the average weight limit");
                    return;
                }

                bandSetup[offset][positionNumber] = musicianWeight;
                System.out.println("****** Musician added.");
                return;

            }// end of if statement
            else{
                System.out.println("ERROR: Out of range, try again");
            }
        }while(rowLetterInt < ROW_START_VAL && rowLetter > 75);




    }// end of the addBandMember METHOD


    private static boolean checkWeightOfRow(double[][] bandSetup, int rowLetterInt){
        int index, sum;
        int rowAverage;
        sum = 0;

        for (index = 0; index < bandSetup[rowLetterInt].length ; index++) {
            sum = sum + (int) bandSetup[rowLetterInt][index];


        }// end of the for loop

        rowAverage = sum / bandSetup[rowLetterInt].length;
        if (rowAverage < 100 && rowAverage >= 0){
            return true;

        }
        else{
            return false;
        }


    }// end of the checkWeightOfRow METHOD





}// end of the bandHourPractice CLASS
