

/**
 * Created by 
 * @author luke on 24/05/2017.
 */
public class LastOneLeft implements Strategy {

  @Override
  public void solve(Square square) {

    if (square.getValue() != null) {
      return;
    }

    if (square.getRow().hasOneSquareLeft()) {
      square.setValue(square.getRow().getMissingValue());

    } else if (square.getColumn().hasOneSquareLeft()) {
      square.setValue(square.getColumn().getMissingValue());

    } else if (square.getGroup().hasOneSquareLeft()) {
      square.setValue(square.getGroup().getMissingValue());
    }

  }

}
