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

  public static void main(String[] args) throws InterruptedException {

    //    SquareStrategyWrapper iterativeSquareStrategy =
    //        new SquareStrategyWrapper(Sets.newHashSet(new Elimination(), new BlockOut()));

    SquareStrategyWrapper squareStrategyWrapper =
        new SquareStrategyWrapper(Sets.newHashSet(new BlockOut()));
    //    Sets.newHashSet(squareStrategyWrapper)
    //    AdvanceBruteForce bruteForce =
    //        new AdvanceBruteForce(null, Sets.newHashSet(squareStrategyWrapper));

        OptimisedBruteForce bruteForce = new OptimisedBruteForce();
    //    ClassicBruteForce bruteForce = new ClassicBruteForce();

    Puzzle puzzle = PuzzleBuilder.build(puzzleString1);

    try {
      puzzle.solveWithPuzzleStrategies(Sets.newHashSet(squareStrategyWrapper));
      System.out.print(puzzle);
    } catch (Exception e) {
      System.err.print("ERROR: \n");
      System.out.print(puzzle.toString());
    }

  }

}
