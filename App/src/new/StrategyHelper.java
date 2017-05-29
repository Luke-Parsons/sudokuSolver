import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 
 * @author luke on 26/05/2017.
 */
public abstract class StrategyHelper {

  //

  // Elimination ///////////////////////////////////////////////////////////////

  public static Set<Integer> valuesNotEliminated(Square square) {
    Set<Integer> values = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9);

    values.removeAll(square.getRow().getValues());
    values.removeAll(square.getColumn().getValues());
    values.removeAll(square.getGroup().getValues());
    return values;
  }

  public static boolean valueIsEliminatedFromAll(Integer value, Set<Square> squares) {
    for (Square square : squares) {
      if (valuesNotEliminated(square).contains(value)) {
        return false;
      }
    }
    return true;
  }

  // blockOut //////////////////////////////////////////////////////////////////

  public static Set<Group> getAllGroup(Puzzle puzzle) {
    Set<Group> groups = new HashSet<>();
    puzzle.getSquares().forEach(square -> groups.add(square.getGroup()));
    return groups;
  }

  public static Set<Square> getOtherUnsetSquaresInThisZone(Group group, Square square) {
    return group.getOtherSquaresInThisZone(square).parallelStream()
        .filter(s -> s.getValue() == null).collect(Collectors.toSet());
  }

  public static boolean allRowContains(Set<Row> rows, Integer value) {
    return rows.parallelStream().filter(row -> row.containsValue(value))
        .collect(Collectors.toSet()).size() == rows.size();
  }

  public static boolean allColumnContains(Set<Column> columns, Integer value) {
    return columns.parallelStream().filter(column -> column.containsValue(value))
        .collect(Collectors.toSet()).size() == columns.size();
  }

  public static boolean adjacentSquareInRowAreFilled(Square square) {
    return getAdjacentSquaresInRow(square).parallelStream().filter(s -> s.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  public static boolean adjacentSquareInColumnAreFilled(Square square) {
    return getAdjacentSquaresInColumn(square).parallelStream().filter(s -> s.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  public static Set<Zone> getAdjacentRowsAndColumns(Square square) {
    Set<Zone> adjacentRowsAndColumns = new HashSet<>();
    adjacentRowsAndColumns.addAll(getAdjacentColumns(square));
    adjacentRowsAndColumns.addAll(getAdjacentRows(square));
    return adjacentRowsAndColumns;
  }

  public static Set<Row> getAdjacentRows(Square square) {
    return getAdjacentSquaresInColumn(square).parallelStream().map(Square:: getRow)
        .collect(Collectors.toSet());
  }

  public static Set<Column> getAdjacentColumns(Square square) {
    return getAdjacentSquaresInRow(square).parallelStream().map(Square:: getColumn)
        .collect(Collectors.toSet());
  }

  public static Set<Square> getAdjacentSquaresInRow(Square square) {
    return square.getRow().getOtherSquaresInGroup(square.getGroup(), square);
  }

  public static Set<Square> getAdjacentSquaresInColumn(Square square) {
    return square.getColumn().getOtherSquaresInGroup(square.getGroup(), square);
  }

  public static Set<Group> getOtherGroupsHorizontally(Group group) {
    ArrayList<Square> square = new ArrayList<>(group.getSquares());
    return getOtherGroupsHorizontally(square.get(0));
  }

  public static Set<Group> getOtherGroupsHorizontally(Square square) {
    Set<Group> groups = new HashSet<>();
    for (Square rowSquare : square.getRow().getSquares()) {
      if (!rowSquare.getGroup().equals(square.getGroup())) {
        groups.add(rowSquare.getGroup());
      }
    }
    return groups;
  }

  public static Set<Group> getOtherGroupsVertically(Group group) {
    ArrayList<Square> square = new ArrayList<>(group.getSquares());
    return getOtherGroupsVertically(square.get(0));
  }

  public static Set<Group> getOtherGroupsVertically(Square square) {
    Set<Group> groups = new HashSet<>();
    for (Square columnSquare : square.getColumn().getSquares()) {
      if (!columnSquare.getGroup().equals(square.getGroup())) {
        groups.add(columnSquare.getGroup());
      }
    }
    return groups;
  }

  public static boolean isPuzzleSolved(Puzzle puzzle) {
    return isPuzzleSolved(puzzle.getSquares());
  }

  public static boolean isPuzzleSolved(List<Square> squares) {
    return squares.parallelStream().filter(square -> square.getValue() == null)
        .collect(Collectors.toSet()).size() == 0;
  }

  public static boolean canValueGoInSquare(Integer value, Square square) {
    return valuesNotEliminated(square).contains(value);
  }

  public static int numberOfSquaresToFill(Puzzle puzzle) {
    return puzzle.getSquares().parallelStream().filter(square -> square.getValue() == null)
        .collect(Collectors.toSet()).size();
  }

  public static boolean allPotentialPositionsOfValueInGroupInTheSameRow(Integer value,
      Group group) {
    Set<Square> emptySquares = group.getEmptySquares();
    Set<Square> squaresWhereValueCanGo =
        emptySquares.parallelStream().filter(square -> valuesNotEliminated(square).contains(value))
            .collect(Collectors.toSet());
    return squaresWhereValueCanGo.stream().map(Square:: getRow).collect(Collectors.toSet()).size()
        <= 1;
  }

  public static boolean allPotentialPositionsOfValueInGroupInTheSameColumn(Integer value,
      Group group) {
    Set<Square> emptySquares = group.getEmptySquares();
    Set<Square> squaresWhereValueCanGo =
        emptySquares.parallelStream().filter(square -> valuesNotEliminated(square).contains(value))
            .collect(Collectors.toSet());
    return
        squaresWhereValueCanGo.parallelStream().map(Square:: getColumn).collect(Collectors.toSet()).size()
            <= 1;
  }

  public static boolean isThisSolvable(Puzzle puzzle) {
    for (Square square : puzzle.getSquares()) {
      if (square.getValue() == null && valuesNotEliminated(square).size() == 0) {
        return false;
      }
    }
    return true;
  }

  ////////////////////////////////////////////////////////////////////////////////////

  public static Set<Row> getRowsThisValueCanGoInOrIsIn(Integer value, Group group) {
    Set<Row> rows =
        getPotentialSquaresForThisValueInGroup(value, group).stream().map(Square:: getRow)
            .collect(Collectors.toSet());
    Square square = getSquareWithValueInGroup(value, group);
    if (square != null) {
      rows.add(square.getRow());
    }
    return rows;
  }

  public static Set<Column> getColumnsThisValueCanGoInOrIsIn(Integer value, Group group) {
    Set<Column> columns =
        getPotentialSquaresForThisValueInGroup(value, group).parallelStream().map(Square:: getColumn)
            .collect(Collectors.toSet());
    Square square = getSquareWithValueInGroup(value, group);
    if (square != null) {
      columns.add(square.getColumn());
    }
    return columns;
  }

  public static Set<Square> getPotentialSquaresForThisValueInGroup(Integer value, Group group) {
    Set<Square> squares = group.getSquares().parallelStream()
        .filter(square -> valuesNotEliminated(square).contains(value)).collect(Collectors.toSet());

    return squares.parallelStream().filter(square -> square.getValue() == null)
        .collect(Collectors.toSet());
  }

  public static Square getSquareWithValueInGroup(Integer value, Group group) {
    List<Square> squares =
        group.getSquares().parallelStream().filter(square -> value.equals(square.getValue()))
            .collect(Collectors.toList());

    if (squares != null && !squares.isEmpty()) {
      return squares.get(0);
    } else {
      return null;
    }
  }
}
