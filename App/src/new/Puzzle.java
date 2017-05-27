
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Puzzle implements Cloneable {

  private List<Square> squares;

  public Puzzle(List<Square> squares) {
    this.squares = squares;

  }

  public void solveWithSquareStrategies(SquareStrategy squareStrategy) {
    SquareStrategyWrapper squareStrategyWrapper =
        new SquareStrategyWrapper(Sets.newHashSet(squareStrategy));
    squareStrategyWrapper.solve(this);
  }

  public void solveWithSquareStrategies(Set<SquareStrategy> squareStrategies) {
    SquareStrategyWrapper squareStrategyWrapper =
        new SquareStrategyWrapper(squareStrategies);
    squareStrategyWrapper.solve(this);
  }

  public void solveWithPuzzleStrategies(PuzzleStrategy puzzleStrategy) {
    puzzleStrategy.solve(this);
  }

  public void solveWithPuzzleStrategies(Set<PuzzleStrategy> puzzleStrategies) {
    puzzleStrategies.forEach(puzzleStrategy -> puzzleStrategy.solve(this));
  }

  public List<Square> getSquares() {
    return squares;
  }

  public void setSquares(List<Square> squares) {
    this.squares = squares;
  }

  public void orderPuzzle(){
    squares.sort((o1, o2) -> {
      if (o1.getPosition().getPositionInPuzzle() < o2.getPosition().getPositionInPuzzle()) {
        return -1;
      } else {
        return 1;
      }
    });
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("------|------|------\n");
    for (Square square : squares) {
      if (square.getPosition().getPositionInRow() == 1
          && (square.getPosition().getPositionInColumn() == 4 ||square.getPosition()
          .getPositionInColumn() == 7)) {
        out.append("------|------|------\n");
      }
      out.append(""+ square.toString()+" ");
      if (square.getPosition().getPositionInRow() == 9) {
        out.append("\n");
      }
      if (square.getPosition().getPositionInRow() == 3
          ||square.getPosition().getPositionInRow() == 6){
        out.append("|");
      }
    }
    out.append("------|------|------\n");
    return out.toString() + "\n\n\n\n";
  }


}
