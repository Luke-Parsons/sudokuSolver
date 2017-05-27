import com.google.common.collect.Sets;

import java.util.List;

/**
 * Created by 
 * @author luke on 26/05/2017.
 */
public class BruteForce implements PuzzleStrategy {

  private static int NUMBER_OF_GUESS = 0;
  private static long TIME_TAKEN_SECS = 0;

  @Override
  public void solve(Puzzle puzzle) {

    long start = System.currentTimeMillis();

    puzzle = solveRecursively(puzzle.getSquares());

    long stop = System.currentTimeMillis();
    TIME_TAKEN_SECS = (stop - start) / 1000L;

    print(puzzle);
  }

  private Puzzle solveRecursively(List<Square> squares) {

    if (StrategyHelper.isPuzzleSolved(squares)) {
      return new Puzzle(squares);
    }

    for (Square square : squares) {
      if (square.getValue() != null) {
        continue;
      }

      for (Integer value : Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9)) {
        if (StrategyHelper.valueCanGoInSquare(value, square)) {
          NUMBER_OF_GUESS++;
          square.setValue(value);

          Puzzle puzzle = solveRecursively(squares);
          if (puzzle != null) {
            return puzzle;
          } else {
            square.setValue(null);
          }
        }
      }
      return null;
    }
    return null;
  }


  private static void print(Puzzle puzzle) {

    puzzle.orderPuzzle();

    System.out.print("NUMBER OF GUESS : " + NUMBER_OF_GUESS + "\n");
    System.out.print("TIME TAKEN SECS : " + TIME_TAKEN_SECS + "\n");
    System.out.print(puzzle.toString());
  }

}


