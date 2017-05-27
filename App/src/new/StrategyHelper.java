import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 
 * @author luke on 26/05/2017.
 */
public abstract class StrategyHelper {

  // Elimination ///////////////////////////////////////////////////////////////
  
  public static Set<Integer> valuesNotEliminated(Square square) {
    Set<Integer> values = Sets.newHashSet(1,2,3,4,5,6,7,8,9);

    values.removeAll(square.getRow().getValues());
    values.removeAll(square.getColumn().getValues());
    values.removeAll(square.getGroup().getValues());
    return values;
  }

  public static boolean valueIsEliminatedFromAll(Integer value, Set<Square> squares) {
    for (Square square: squares){
      if (valuesNotEliminated(square).contains(value)){
        return false;
      }
    }
    return true;
  }

  // blockOut //////////////////////////////////////////////////////////////////

  public static Set<Square> getOtherUnsetSquaresInThisZone(Group group, Square square) {
    return group.getOtherSquaresInThisZone(square).stream().filter(s -> s.getValue() == null)
        .collect(Collectors.toSet());
  }

  public static void blockOutRows(Set<Integer> valuesToGet, Square square) {
    Set<Row> adjacentRow = getAdjacentRows(square);
    for (Integer value : valuesToGet) {
      if (allRowContains(adjacentRow, value)) {
        square.setValue(value);
      }
    }
  }

  public static void blockOutColumns(Set<Integer> valuesToGet, Square square) {
    Set<Column> adjacentColumn = getAdjacentColumns(square);
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

  public static Set<Zone> getAdjacentRowsAndColumns(Square square) {
    Set<Zone> adjacentRowsAndColumns = new HashSet<>();
    adjacentRowsAndColumns.addAll(getAdjacentColumns(square));
    adjacentRowsAndColumns.addAll(getAdjacentRows(square));
    return adjacentRowsAndColumns;
  }

  public static Set<Row> getAdjacentRows(Square square) {
    return getAdjacentSquaresInColumn(square).stream().map(Square:: getRow)
        .collect(Collectors.toSet());
  }

  public static Set<Column> getAdjacentColumns(Square square) {
    return getAdjacentSquaresInRow(square).stream().map(Square:: getColumn)
        .collect(Collectors.toSet());
  }

  public static Set<Square> getAdjacentSquaresInRow(Square square) {
    return square.getRow().getOtherSquaresInGroup(square.getGroup(), square);
  }

  public static Set<Square> getAdjacentSquaresInColumn(Square square) {
    return square.getColumn().getOtherSquaresInGroup(square.getGroup(), square);
  }

  public static boolean isPuzzleSolved(List<Square> squares) {
    return squares.parallelStream().filter(square -> square.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  public static boolean valueCanGoInSquare(Integer value, Square square){
    return valuesNotEliminated(square).contains(value);
  }

  public static int numberOfSquaresToFill(Puzzle puzzle) {
    return puzzle.getSquares().parallelStream().filter(square -> square.getValue() == null)
        .collect(Collectors.toSet()).size();
  }
}
