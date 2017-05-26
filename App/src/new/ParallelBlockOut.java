

import java.util.Set;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class ParallelBlockOut implements Strategy {

  @Override
  public void solve(Square square) {

    if (square.getValue() != null) {
      return;
    }

    Set<Integer> valuesToGet = square.getGroup().getMissingValues();

    if (StrategyHelper.adjacentSquareInRowAreFilled(square)) {
      StrategyHelper.blockOutRows(valuesToGet, square);
    }

    if (StrategyHelper.adjacentSquareInColumnAreFilled(square)) {
      StrategyHelper.blockOutRows(valuesToGet, square);
    }
    if (StrategyHelper.adjacentSquareInColumnAreFilled(square)) {
      StrategyHelper.blockOutColumns(valuesToGet, square);
    }

  }

}
