import java.util.Set;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
@Deprecated
public class ParallelBlockOut implements SquareStrategy {

  private static Colour colour = Colour.YELLOW;

  @Override
  public void solve(Square square) {

    if (square.getValue() != null) {
      return;
    }

    Set<Integer> valuesToGet = square.getGroup().getMissingValues();

    if (StrategyHelper.adjacentSquareInRowAreFilled(square)) {
      blockOutRows(valuesToGet, square);
    }

    if (StrategyHelper.adjacentSquareInColumnAreFilled(square)) {
      blockOutRows(valuesToGet, square);
    }
    if (StrategyHelper.adjacentSquareInColumnAreFilled(square)) {
      blockOutColumns(valuesToGet, square);
    }

  }

    public static void blockOutRows(Set<Integer> valuesToGet, Square square) {
      Set<Row> adjacentRow = StrategyHelper.getAdjacentRows(square);
      for (Integer value : valuesToGet) {
        if (StrategyHelper.allRowContains(adjacentRow, value)) {
          square.setValue(value, colour);
        }
      }
    }

    public static void blockOutColumns(Set<Integer> valuesToGet, Square square) {
      Set<Column> adjacentColumn = StrategyHelper.getAdjacentColumns(square);
      for (Integer value : valuesToGet) {
        if (StrategyHelper.allColumnContains(adjacentColumn, value)) {
          square.setValue(value ,colour);
        }
      }
    }


}
