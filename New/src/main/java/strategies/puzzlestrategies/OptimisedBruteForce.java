package strategies.puzzlestrategies;

import com.google.common.collect.Sets;

import puzzle.Puzzle;
import puzzle.PuzzleBuilder;
import puzzle.Square;
import strategies.Colour;
import strategies.StrategyHelper;

/**
 * Created by 
 * @author luke on 26/05/2017.
 */
public class OptimisedBruteForce implements PuzzleStrategy {

  private static Colour colour = Colour.RED;

  private int NUMBER_OF_GUESS = 0;
  private long TIME_TAKEN_SECS = 0;

  public OptimisedBruteForce() {}

  @Override
  public void solve(Puzzle puzzle) {

    long start = System.currentTimeMillis();

    puzzle = solveRecursively(puzzle);

    long stop = System.currentTimeMillis();
    TIME_TAKEN_SECS = (stop - start) / 1000L;

    print(puzzle);
  }

  private Puzzle solveRecursively(Puzzle puzzle) {

    if (StrategyHelper.isPuzzleSolved(puzzle)) {
      return puzzle;
    }

    if (!StrategyHelper.isThisSolvable(puzzle)) {
      return puzzle;
    }

    Puzzle oldGoodPuzzle = PuzzleBuilder.clone(puzzle);

    for (Square square : puzzle.getSquares()) {
      if (square.getValue() != null) {
        continue;
      }
      // TODO: 28/05/2017 : order in count of this number left to get in puzzle
      // got to next empty square
      for (Integer value : Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9)) {
        if (StrategyHelper.canValueGoInSquare(value, square)) {
          NUMBER_OF_GUESS++;
          square.setValue(value, colour);

          puzzle = solveRecursively(puzzle);
          if (StrategyHelper.isPuzzleSolved(puzzle)) {
            return puzzle;
          } else {
            puzzle = PuzzleBuilder.rollback(puzzle, oldGoodPuzzle);
            square.resetValue(colour);
          }
        }
      }
      // hit a block
      return puzzle;
    }
    return puzzle;
  }

  private void print(Puzzle puzzle) {

    puzzle.orderPuzzle();

    System.out.print("NUMBER OF GUESS : " + NUMBER_OF_GUESS + "\n");
    System.out.print("TIME TAKEN SECS : " + TIME_TAKEN_SECS + "\n");
    System.out.print(puzzle.toString());
  }

}


