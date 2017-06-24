package strategies.squarestrategies;

import java.util.Set;

import puzzle.Square;
import strategies.Colour;
import strategies.StrategyHelper;

/**
 * Created by 
 * @author luke on 25/05/2017.
 */
@Deprecated
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
      if (StrategyHelper.valueIsEliminatedFromAll(value, otherBlankSquaresInThisZone)
          && StrategyHelper.valuesNotEliminated(square).contains(value)) {
        square.setValue(value , colour);
      }
    }

  }
}
