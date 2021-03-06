import com.google.common.collect.Sets;

import puzzle.Puzzle;
import puzzle.PuzzleBuilder;
import strategies.puzzlestrategies.AdvanceBlockOut;
import strategies.puzzlestrategies.AdvanceBruteForce;
import strategies.puzzlestrategies.ZoneWiseElimination;
import strategies.squarestrategies.Elimination;

/**
 * Created by 
 * @author luke on 23/05/2017.
 */
public class App {

  private static String puzzleString1 = "?,7,?,3,?,2,?,?,?,8,?,?,?,?,?,1,?,4,6,?,?,?,1,?,?,?,?,?,"
      + "?,8,?,3,?,?,1,?,?,1,?,9,?,6,?,5,?,?,4,?,?,7,?,3,?,?,?,?,?,?,2,?,?,?,3,9,?,2,?,?,?,?,?,7,"
      + "?,?,?,6,?,7,?,8,?";

  private static String puzzleString3 =
      "6,4,?,?,2,?,3,?,?,3,5,?,?,8,1,?,2,?,?,1,2,?,3,6,?,?,?,?,3,?,6,?,?,?,?,2,1,?,?,?,7,?,?,?,8,"
          + "5,?,?,?,?,2,?,6,?,?,?,?,7,5,?,8,3,?,?,8,?,1,6,?,?,4,7,?,?,3,?,9,?,?,5,1";

  private static String puzzleAdvanceBlockOutTest =
      "?,7,?,3,?,2,?,?,?,8,?,?,?,?,?,1,?,4,6,?,?,?,1,?,?,?,?,?,"
          + "?,8,?,3,?,?,1,?,?,1,?,9,?,6,?,5,?,?,4,?,?,7,?,3,?,?,?,?,?,?,2,?,?,?,3,9,?,2,?,?,3,?,"
          + "?,7,?,?,?,6,?,7,2,8,1";

  private static String worldHardest = "8,?,?,?,?,?,?,?,?,?,?,3,6,?,?,?,?,?,?,7,?,?,9,?,2,?,?,?,"
      + "5,?,?,?,7,?,?,?,?,?,?,?,4,5,7,?,?,?,?,?,1,?,?,?,3,?,?,?,1,?,?,?,?,6,8,?,?,8,5,?,?,?,1,?,"
      + "?,9,?,?,?,?,4,?,?";

  public static void main(String[] args) throws InterruptedException {

    //    SquareStrategyWrapper iterativeSquareStrategy =
    //        new SquareStrategyWrapper(Sets.newHashSet(new Elimination(), new BlockOut()));

    //    Sets.newHashSet(squareStrategyWrapper)
    //    AdvanceBruteForce bruteForce =
    //        new AdvanceBruteForce(null, Sets.newHashSet(squareStrategyWrapper));

    //        OptimisedBruteForce bruteForce = new OptimisedBruteForce();
    //    ClassicBruteForce bruteForce = new ClassicBruteForce();

    Puzzle puzzle = PuzzleBuilder.build(worldHardest);

    AdvanceBruteForce bestStrategy =
        new AdvanceBruteForce(
            Sets.newHashSet(new Elimination()),
            Sets.newHashSet(new ZoneWiseElimination(), new AdvanceBlockOut()));

    System.out.print(puzzle);
    try {
      //      puzzle.solve(new ZoneWiseElimination());
      puzzle.solve(bestStrategy);
      //      System.out.print(puzzle);
    } catch (Exception e) {
      System.err.print("ERROR: \n");
      System.out.print(puzzle.toString());
      e.printStackTrace();
    }

  }

}
