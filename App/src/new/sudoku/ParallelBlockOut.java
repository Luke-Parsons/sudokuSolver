package sudoku;

import java.util.Set;
import java.util.stream.Collectors;

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

    if (adjacentSquareInRowAreFilled(square)) {
      blockOutRows(valuesToGet, square);
    }

    if (adjacentSquareInColumnAreFilled(square)) {
      blockOutRows(valuesToGet, square);
    }
    if (adjacentSquareInColumnAreFilled(square)) {
      blockOutColumns(valuesToGet, square);
    }

  }

  private static void blockOutRows(Set<Integer> valuesToGet, Square square) {
    Set<Row> adjacentRow = getAdjacentRow(square);
    for (Integer value : valuesToGet) {
      if (allRowContains(adjacentRow, value)) {
        square.setValue(value);
      }
    }
  }

  private static void blockOutColumns(Set<Integer> valuesToGet, Square square) {
    Set<Column> adjacentColumn = getAdjacentColumn(square);
    for (Integer value : valuesToGet) {
      if (allColumnContains(adjacentColumn, value)) {
        square.setValue(value);
      }
    }
  }

  private static boolean allRowContains(Set<Row> rows, Integer value) {
    return rows.stream().filter(row -> row.containsValue(value))
        .collect(Collectors.toSet()).size() == rows.size();
  }

  private static boolean allColumnContains(Set<Column> columns, Integer value) {
    return columns.stream().filter(column -> column.containsValue(value))
        .collect(Collectors.toSet()).size() == columns.size();
  }

  private static boolean adjacentSquareInRowAreFilled(Square square) {
    return getAdjacentSquaresInRow(square).stream().filter(s -> s.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  private static boolean adjacentSquareInColumnAreFilled(Square square) {
    return getAdjacentSquaresInColumn(square).stream().filter(s -> s.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  private static Set<Row> getAdjacentRow(Square square) {
    return getAdjacentSquaresInColumn(square).stream().map(Square:: getRow)
        .collect(Collectors.toSet());
  }

  private static Set<Column> getAdjacentColumn(Square square) {
    return getAdjacentSquaresInRow(square).stream().map(Square:: getColumn)
        .collect(Collectors.toSet());
  }

  private static Set<Square> getAdjacentSquaresInRow(Square square) {
    return square.getRow().getOtherSquaresInGroup(square.getGroup(), square);
  }

  private static Set<Square> getAdjacentSquaresInColumn(Square square) {
    return square.getColumn().getOtherSquaresInGroup(square.getGroup(), square);
  }
}
