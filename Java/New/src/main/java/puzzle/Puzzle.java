package puzzle;

import com.google.common.collect.Sets;

import java.util.List;

import strategies.puzzlestrategies.PuzzleStrategy;
import strategies.squarestrategies.SquareStrategy;
import strategies.wrappers.PuzzleStrategyWrapper;
import strategies.wrappers.SquareStrategyWrapper;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Puzzle implements Cloneable {

  private List<Square> squares;

  public Puzzle(List<Square> squares) {
    this.squares = squares;
  }

  public void solve(SquareStrategy squareStrategy) {
    SquareStrategyWrapper squareStrategyWrapper =
        new SquareStrategyWrapper(Sets.newHashSet(squareStrategy));
    squareStrategyWrapper.solve(this);
  }

  public void solve(SquareStrategy... squareStrategies) {
    SquareStrategyWrapper squareStrategyWrapper =
        new SquareStrategyWrapper(Sets.newHashSet((squareStrategies)));
    squareStrategyWrapper.solve(this);
  }

  public void solve(PuzzleStrategy puzzleStrategy) {
    PuzzleStrategyWrapper puzzleStrategyWrapper =
        new PuzzleStrategyWrapper(Sets.newHashSet(puzzleStrategy));
    puzzleStrategyWrapper.solve(this);
  }

  public void solve(PuzzleStrategy... puzzleStrategies) {
    PuzzleStrategyWrapper puzzleStrategyWrapper =
        new PuzzleStrategyWrapper(Sets.newHashSet(puzzleStrategies));
    puzzleStrategyWrapper.solve(this);
  }

  public List<Square> getSquares() {
    return squares;
  }

  public void setSquares(List<Square> squares) {
    this.squares = squares;
  }

  public void orderPuzzle() {
    squares.sort((o1, o2) -> {
      if (o1.getPosition().getPositionInPuzzle() < o2.getPosition().getPositionInPuzzle()) {
        return -1;
      } else if (o1.getPosition().getPositionInPuzzle() > o2.getPosition().getPositionInPuzzle()) {
        return 1;
      }
      return 0;
    });
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("------|------|------\n");
    for (Square square : squares) {
      if (square.getPosition().getPositionInRow() == 1 && (
          square.getPosition().getPositionInColumn() == 4
              || square.getPosition().getPositionInColumn() == 7)) {
        out.append("------|------|------\n");
      }
      out.append("").append(square.toString()).append(" ");
      if (square.getPosition().getPositionInRow() == 9) {
        out.append("\n");
      }
      if (square.getPosition().getPositionInRow() == 3
          || square.getPosition().getPositionInRow() == 6) {
        out.append("|");
      }
    }
    out.append("------|------|------\n");
    return out.toString() + "\n\n\n\n";
  }

}
