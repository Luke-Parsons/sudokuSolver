package strategies.wrappers;

import java.util.Set;

import puzzle.Puzzle;
import puzzle.Square;
import strategies.puzzlestrategies.PuzzleStrategy;
import strategies.squarestrategies.SquareStrategy;
import strategies.StrategyHelper;

/**
 * Created by 
 * @author luke on 28/05/2017.
 */
public class SquareAndPuzzleStrategyWrapper implements PuzzleStrategy {

  Set<SquareStrategy> squareStrategies;
  Set<PuzzleStrategy> puzzleStrategies;

  public SquareAndPuzzleStrategyWrapper(Set<SquareStrategy> squareStrategies,
      Set<PuzzleStrategy> puzzleStrategies) {
    this.squareStrategies = squareStrategies;
    this.puzzleStrategies = puzzleStrategies;
  }

  @Override
  public void solve(Puzzle puzzle) {
    int numberOfSquaresToFill = StrategyHelper.numberOfSquaresToFill(puzzle);
    int numberOfSquaresToFillNow = 0;
    while (numberOfSquaresToFill != numberOfSquaresToFillNow) {
      numberOfSquaresToFill = numberOfSquaresToFillNow;

      if (puzzleStrategies != null) {
        puzzleStrategies.forEach(puzzleStrategy -> puzzleStrategy.solve(puzzle));
      }

      if (squareStrategies != null) {
        for (Square square : puzzle.getSquares()) {
          squareStrategies.forEach(squareStrategy -> squareStrategy.solve(square));
        }
      }
      numberOfSquaresToFillNow = StrategyHelper.numberOfSquaresToFill(puzzle);
    }
  }
}
