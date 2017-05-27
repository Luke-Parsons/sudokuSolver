import java.util.Set;

/**
 * Created by 
 * @author luke on 25/05/2017.
 */
public class BlockOut implements SquareStrategy {

  private static Colour colour = Colour.YELLOW;

  @Override
  public void solve(Square square) {

    if (square.getValue() != null) {
      return;
    }

    Set<Integer> missingValues = square.getGroup().getMissingValues();

    Set<Square> otherBlankSquaresInThisZone =
        StrategyHelper.getOtherUnsetSquaresInThisZone(square.getGroup(), square);

    for (Integer value : missingValues) {
      // todo not working
      if (StrategyHelper.valueIsEliminatedFromAll(value, otherBlankSquaresInThisZone)) {
        square.setValue(value , colour);
      }
    }

  }
}
