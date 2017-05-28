import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by 
 * @author luke on 26/05/2017.
 */
public class AdvanceBruteForce implements PuzzleStrategy {

  private static Colour colour = Colour.RED;

  private int NUMBER_OF_GUESS = 0;
  private long TIME_TAKEN_SECS = 0;

  private Set<SquareStrategy> squareSpeedFactors;
  private Set<PuzzleStrategy> puzzleSpeedFactors;

  public AdvanceBruteForce() {}

  public AdvanceBruteForce(Set<SquareStrategy> squareSpeedFactors,
      Set<PuzzleStrategy> puzzleSpeedFactors) {
    this.squareSpeedFactors = squareSpeedFactors;
    this.puzzleSpeedFactors = puzzleSpeedFactors;
  }

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

    Puzzle oldGoodPuzzle = PuzzleBuilder.clone(puzzle);

    if (!StrategyHelper.isThisSolvable(puzzle)) {
      return puzzle;
    }

    applySquareSpeedFactors(puzzle);
    applyPuzzleSpeedFactors(puzzle);

    if (StrategyHelper.isPuzzleSolved(puzzle)) {
      return puzzle;
    }

    for (Square square : puzzle.getSquares()) {
      if (square.getValue() != null) {
        continue;
      }
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

  private void applySquareSpeedFactors(Puzzle puzzle) {
    if (squareSpeedFactors != null) {
      SquareStrategyWrapper squareStrategyWrapper = new SquareStrategyWrapper(squareSpeedFactors);
      squareStrategyWrapper.solve(puzzle);
    }
  }

  private void applyPuzzleSpeedFactors(Puzzle puzzle) {
    if (puzzleSpeedFactors != null) {
      puzzleSpeedFactors.forEach(puzzleStrategy -> puzzleStrategy.solve(puzzle));
    }
  }

  private void print(Puzzle puzzle) {

    puzzle.orderPuzzle();

    System.out.print("NUMBER OF GUESS : " + NUMBER_OF_GUESS + "\n");
    System.out.print("TIME TAKEN SECS : " + TIME_TAKEN_SECS + "\n");
    System.out.print(puzzle.toString());
  }

}


