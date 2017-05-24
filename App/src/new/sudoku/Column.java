package sudoku;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Column extends Zone {

  @Override
  protected void addSquare(Square square) {
    map.put(square.getPosition().getPositionInColumn(), square);
  }
}
