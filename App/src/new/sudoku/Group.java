package sudoku;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Group extends Zone {

  @Override
  protected void addSquare(Square square) {
    map.put(square.getPosition().getPositionInGroup(), square);
  }

  public boolean contains(Square square){
    return map.values().contains(square);
  }
}
