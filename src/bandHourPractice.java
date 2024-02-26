import java.util.Scanner;

public class bandHourPractice {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final byte MAX_ROWS = 10;
    private static final byte MAX_POSITIONS = 8;
    private static final byte ROW_START_VAL = 65;


    public static void main(String[] args) {
      int numOfRows, index, jdex;

        numOfRows = 0;
        // ask user for # of rows
        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");
        numOfRows = getNumOfRows(numOfRows);
        System.out.println("The number of rows is :" + numOfRows);


        // Initializes jagged array with numOfRows # of rows

        int[][] bandSetup = new int[numOfRows][];

        setupPositionsInRow(bandSetup, numOfRows);
        // displaying contents of the array created :D
        System.out.println("Contents of the 2D jagged array");
        for (index = 0; index < bandSetup.length; index++){
            for (jdex = 0; jdex < bandSetup[index].length; jdex++){
                System.out.println(bandSetup[index][jdex]);
            }
            System.out.println();
        }












    }// end of the main METHOD

    private static int getNumOfRows(int numberRows){
        System.out.println("Please enter number of rows");
        numberRows = keyboard.nextInt();
        do{
            if (numberRows > 0 && numberRows <= MAX_ROWS){
                return numberRows;
            }
            else {
                System.out.println("ERROR: Out of range, try again");
                numberRows = keyboard.nextInt();
            }
        } while (numberRows < 0 || numberRows > MAX_ROWS);

        return numberRows;

    }// end of the getNumOfRows METHOD

    private static void setupPositionsInRow(int[][] bandSetup, int numOfRows){
    //sets up the jagged array values
        int index;
        char rowChar;
        int numPositions;
        rowChar = ROW_START_VAL;
        for (index = 0; index < numOfRows; index++){
            rowChar = (char) (rowChar + index);
            System.out.println("Please enter the number of positions in row" + rowChar);
            numPositions = keyboard.nextInt();
            while(numPositions < 0 || numPositions > MAX_POSITIONS){
                System.out.println("ERROR: Out of range, try again");
                numPositions = keyboard.nextInt();
            }
            bandSetup[index] = new int[numPositions];


        }// end of the for loop







    }// end of the setupPositionsInRow METHOD


}// end of the bandHourPractice CLASS
