import java.util.Set;

/**
 * Created by 
 * @author luke on 25/05/2017.
 */
public class BlockOut implements SquareStrategy {

  @Override
  public void solve(Square square) {

    if (square.getValue() != null) {
      return;
    }

    Set<Integer> missingValues = square.getGroup().getMissingValues();

    Set<Square> otherBlankSquaresInThisZone =
        StrategyHelper.getOtherUnsetSquaresInThisZone(square.getGroup(), square);

    for (Integer value : missingValues) {
      if (StrategyHelper.valueIsEliminatedFromAll(value, otherBlankSquaresInThisZone)) {
        square.setValue(value);
      }
    }

  }
}
