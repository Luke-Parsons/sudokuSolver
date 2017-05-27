import com.google.common.collect.Sets;

/**
 * Created by 
 * @author luke on 23/05/2017.
 */
public class App {

  private static String puzzleString1 = "?,7,?,3,?,2,?,?,?,8,?,?,?,?,?,1,?,4,6,?,?,?,1,?,?,?,?,?,"
      + "?,8,?,3,?,?,1,?,?,1,?,9,?,6,?,5,?,?,4,?,?,7,?,3,?,?,?,?,?,?,2,?,?,?,3,9,?,2,?,?,?,?,?,7,"
      + "?,?,?,6,?,7,?,8,?";
  private static String puzzleString2 =
      "8,?,?,?,?,?,?,?,?,?,?,3,6,?,?,?,?,?,?,7,?,?,9,?,2,?,?,?,5,?,?,?,7,?,?,?,?,?,?,?,4,5,7,?,?,"
          + "?,?,?,1,?,?,?,3,?,?,?,1,?,?,?,?,6,8,?,?,8,5,?,?,?,1,?,?,9,?,?,?,?,4,?,?";
  private static String puzzleString3 =
      "6,4,?,?,2,?,3,?,?,3,5,?,?,8,1,?,2,?,?,1,2,?,3,6,?,?,?,?,3,?,6,?,?,?,?,2,1,?,?,?,7,?,?,?,8,"
          + "5,?,?,?,?,2,?,6,?,?,?,?,7,5,?,8,3,?,?,8,?,1,6,?,?,4,7,?,?,3,?,9,?,?,5,1";
  private static String puzzleString4 = "8,?,?,?,?,?,?,?,?,?,?,3,6,?,?,?,?,?,?,7,?,?,9,?,2,?,?,?,"
      + "5,?,?,?,7,?,?,?,?,?,?,?,4,5,7,?,?,?,?,?,1,?,?,?,3,?,?,?,1,?,?,?,?,6,8,?,?,8,5,?,?,?,1,?,"
      + "?,9,?,?,?,?,4,?,?";

  public static void main(String[] args) throws InterruptedException {

//    IterativeSquareStrategy iterativeSquareStrategy =
    //        new IterativeSquareStrategy(Sets.newHashSet(new Elimination(), new BlockOut()));

    Puzzle puzzle =
        PuzzleBuilder.Build(puzzleString2, null, Sets.newHashSet(new BruteForceLessGuess()));
    puzzle.solveByPuzzle();

    //
//    System.out.println("Interaction : 0");
//    System.out.println(puzzle.toString());
//    int it = 1 ;
//    while (true) {
//      puzzle.solveBySquare();
//      System.out.println("Interaction : "+ it);
//      System.out.println(puzzle.toString());
//      it++;
//      Thread.sleep(1000L);
//    }
  }

}
