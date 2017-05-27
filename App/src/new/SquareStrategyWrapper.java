import java.util.Set;

/**
 * Created by 
 * @author luke on 27/05/2017.
 *
 * this strategy is a combination of Square Strategies appliance to each Square structures
 * until there is no further change in the Puzzle.
 *
 * in short, it does all it can without guessing
 *
 */
public class SquareStrategyWrapper implements PuzzleStrategy {

  private Set<SquareStrategy> squareStrategies;

  public SquareStrategyWrapper(Set<SquareStrategy> squareStrategies) {
    this.squareStrategies = squareStrategies;
  }

  @Override
  public void solve(Puzzle puzzle) {

    int numberOfSquaresToFill = StrategyHelper.numberOfSquaresToFill(puzzle);
    int numberOfSquaresToFillNow = 0;
    while (numberOfSquaresToFill != numberOfSquaresToFillNow) {
      numberOfSquaresToFill = numberOfSquaresToFillNow;
      for (Square square : puzzle.getSquares()) {
        squareStrategies.forEach(squareStrategy -> squareStrategy.solve(square));
      }
      numberOfSquaresToFillNow = StrategyHelper.numberOfSquaresToFill(puzzle);
    }
  }
}
