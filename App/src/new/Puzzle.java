
import java.util.List;
import java.util.Set;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Puzzle {

  private List<Square> squares;
  private Set<PuzzleStrategy> puzzleStrategies;

  public Puzzle(List<Square> squares) {
    this.squares = squares;
  }

  public Puzzle(List<Square> squares, Set<PuzzleStrategy> puzzleStrategies) {
    this.squares = squares;
    this.puzzleStrategies = puzzleStrategies;
  }

  public void solveBySquare() {
    squares.forEach(Square:: update);
  }

  public void solveByPuzzle() {
    puzzleStrategies.forEach(puzzleStrategy -> puzzleStrategy.solve(this));
  }

  public List<Square> getSquares() {
    return squares;
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
