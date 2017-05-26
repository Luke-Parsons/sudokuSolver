
/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Row extends Zone {

  @Override
  protected void addSquare(Square square) {
    map.put(square.getPosition().getPositionInRow(), square);
  }
}
