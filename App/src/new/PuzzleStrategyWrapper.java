import java.util.Set;

/**
 * Created by 
 * @author luke on 28/05/2017.
 */
public class PuzzleStrategyWrapper implements PuzzleStrategy {

  Set<PuzzleStrategy> puzzleStrategies;

  public PuzzleStrategyWrapper(Set<PuzzleStrategy> puzzleStrategies) {
    this.puzzleStrategies = puzzleStrategies;
  }

  @Override
  public void solve(Puzzle puzzle) {

    int numberOfSquaresToFill = StrategyHelper.numberOfSquaresToFill(puzzle);
    int numberOfSquaresToFillNow = 0;
    while (numberOfSquaresToFill != numberOfSquaresToFillNow) {
      numberOfSquaresToFill = numberOfSquaresToFillNow;

      puzzleStrategies.forEach(puzzleStrategy -> puzzleStrategy.solve(puzzle));

      numberOfSquaresToFillNow = StrategyHelper.numberOfSquaresToFill(puzzle);
    }
  }

}
