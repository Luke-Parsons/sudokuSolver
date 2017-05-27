import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by 
 * @author luke on 26/05/2017.
 */
public class BruteForce implements PuzzleStrategy {

  private static int NUMBER_OF_GUESS = 0;
  private static long TIME_TAKEN_SECS = 0;

  private static Set<SpeedFactor> speedFactors;

  private static Colour colour = Colour.RED;

  public BruteForce() {}

  public BruteForce(Set<SpeedFactor> speedFactors) {
    this.speedFactors = speedFactors;
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

    applySpeedFactors(puzzle);

    for (Square square : puzzle.getSquares()) {
      if (square.getValue() != null) {
        continue;
      }

      for (Integer value : Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9)) {
        if (StrategyHelper.canValueGoInSquare(value, square)) {
          NUMBER_OF_GUESS++;
          square.setValue(value, colour);

          puzzle = solveRecursively(puzzle);
          if (StrategyHelper.isPuzzleSolved(puzzle)) {
            return puzzle;
          } else {
            square.resetValue(colour);
          }
        }
      }
      return puzzle;
    }
    return puzzle;
  }

  private static void applySpeedFactors(Puzzle puzzle) {
    if (speedFactors != null) {
      speedFactors.forEach(speedFactor -> speedFactor.process(puzzle));
    }
  }

  private static void print(Puzzle puzzle) {

    puzzle.orderPuzzle();

    System.out.print("NUMBER OF GUESS : " + NUMBER_OF_GUESS + "\n");
    System.out.print("TIME TAKEN SECS : " + TIME_TAKEN_SECS + "\n");
    System.out.print(puzzle.toString());
  }

}


