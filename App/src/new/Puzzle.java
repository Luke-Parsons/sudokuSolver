
import java.util.List;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Puzzle {

  List<Square> squares;

  public Puzzle(List<Square> squares) {
    this.squares = squares;
  }

  public void solve() {
    squares.forEach(Square:: update);
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
