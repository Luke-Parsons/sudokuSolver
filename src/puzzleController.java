/**
 * Created by Luke Parsons on 14/12/2015.
 */
public class puzzleController {

    private String fileName;

    public puzzleController(String fileName) {
        this.fileName = fileName;
    }

    public String SolvePuzzle(){
        return "hi";
    }



    public static void main(String[] args) {

        String PuzzleString = " 2 178 3 " +
                              " 4 3 2 9 " +
                              "1       6" +
                              "  86 35  " +
                              "3       4" +
                              "  67 92  " +
                              "9       2" +
                              " 8 9 1 6 " +
                              " 1 436 5 ";

        String PuzzleString2 =
                        "| | | | | | | | |1|" +
                        "| | |1| | | | |2| |" +
                        "|2| | | | | | | | |" +
                        "| | | | | | | | | |" +
                        "| | | | | |1| | | |" +
                        "| | | | |2| | | | |" +
                        "| | | | | | | | | |" +
                        "| | | |1| | | | | |" +
                        "| | | |2| | | | | |" ;

        String s =
                           " |  0 |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |\n" +
                           "                |              |                 "+
                           " |  9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 |\n" +
                           "                |              |                 "+
                           " | 18 | 19 | 20 | 21 | 22 | 23 | 24 | 25 | 26 |\n" +
                           "----------------|--------------|---------------\n"+
                           " | 27 | 28 | 29 | 30 | 31 | 32 | 33 | 34 | 35 |\n" +
                           "                |              |                 "+
                           " | 36 | 37 | 38 | 39 | 40 | 41 | 42 | 43 | 44 |\n" +
                           "                |              |                 "+
                           " | 45 | 46 | 47 | 48 | 49 | 50 | 51 | 52 | 53 |\n" +
                           "----------------|--------------|---------------\n"+
                           " | 54 | 55 | 56 | 57 | 58 | 59 | 60 | 61 | 62 |\n" +
                           "                |              |                 "+
                           " | 63 | 64 | 65 | 66 | 67 | 68 | 69 | 70 | 71 |\n" +
                           "                |              |                 "+
                           " | 72 | 73 | 74 | 75 | 76 | 77 | 78 | 79 | 80 |\n" ;


        puzzle p = new puzzle(new logicalInference(), PuzzleString);
        System.out.print(p+"\n\n");
        p.Solve();
        System.out.print(p);

        //puzzleController Controller = new puzzleController("Filename");
        //System.out.println(Controller.SolvePuzzle());
    }



}
