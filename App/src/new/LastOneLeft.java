

/**
 * Created by 
 * @author luke on 24/05/2017.
 */
@Deprecated
public class LastOneLeft implements SquareStrategy {

  private static Colour colour = Colour.TURQUOISE;

  @Override
  public void solve(Square square) {

    if (square.getValue() != null) {
      return;
    }

    if (square.getRow().hasOneSquareLeft()) {
      square.setValue(square.getRow().getMissingValue(), colour);

    } else if (square.getColumn().hasOneSquareLeft()) {
      square.setValue(square.getColumn().getMissingValue(), colour);

    } else if (square.getGroup().hasOneSquareLeft()) {
      square.setValue(square.getGroup().getMissingValue(), Colour.TURQUOISE);
    }

  }

}
