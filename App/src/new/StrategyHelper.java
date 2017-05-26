import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 
 * @author luke on 26/05/2017.
 */
public abstract class StrategyHelper {

  // Elimination
  
  public static Set<Integer> valuesNotEliminated(Square square) {
    Set<Integer> values = Sets.newHashSet(1,2,3,4,5,6,7,8,9);

    values.removeAll(square.getRow().getValues());
    values.removeAll(square.getColumn().getValues());
    values.removeAll(square.getGroup().getValues());
    return values;
  }


  public static void blockOutRows(Set<Integer> valuesToGet, Square square) {
    Set<Row> adjacentRow = getAdjacentRow(square);
    for (Integer value : valuesToGet) {
      if (allRowContains(adjacentRow, value)) {
        square.setValue(value);
      }
    }
  }

  public static void blockOutColumns(Set<Integer> valuesToGet, Square square) {
    Set<Column> adjacentColumn = getAdjacentColumn(square);
    for (Integer value : valuesToGet) {
      if (allColumnContains(adjacentColumn, value)) {
        square.setValue(value);
      }
    }
  }

  public static boolean allRowContains(Set<Row> rows, Integer value) {
    return rows.stream().filter(row -> row.containsValue(value))
        .collect(Collectors.toSet()).size() == rows.size();
  }

  public static boolean allColumnContains(Set<Column> columns, Integer value) {
    return columns.stream().filter(column -> column.containsValue(value))
        .collect(Collectors.toSet()).size() == columns.size();
  }

  public static boolean adjacentSquareInRowAreFilled(Square square) {
    return getAdjacentSquaresInRow(square).stream().filter(s -> s.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  public static boolean adjacentSquareInColumnAreFilled(Square square) {
    return getAdjacentSquaresInColumn(square).stream().filter(s -> s.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  public static Set<Row> getAdjacentRow(Square square) {
    return getAdjacentSquaresInColumn(square).stream().map(Square:: getRow)
        .collect(Collectors.toSet());
  }

  public static Set<Column> getAdjacentColumn(Square square) {
    return getAdjacentSquaresInRow(square).stream().map(Square:: getColumn)
        .collect(Collectors.toSet());
  }

  public static Set<Square> getAdjacentSquaresInRow(Square square) {
    return square.getRow().getOtherSquaresInGroup(square.getGroup(), square);
  }

  public static Set<Square> getAdjacentSquaresInColumn(Square square) {
    return square.getColumn().getOtherSquaresInGroup(square.getGroup(), square);
  }
  
}
