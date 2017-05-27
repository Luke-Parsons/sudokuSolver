import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class PuzzleBuilder {

  public static Puzzle build(String puzzleString) {

    Row r1 = new Row();
    Row r2 = new Row();
    Row r3 = new Row();
    Row r4 = new Row();
    Row r5 = new Row();
    Row r6 = new Row();
    Row r7 = new Row();
    Row r8 = new Row();
    Row r9 = new Row();

    Column c1 = new Column();
    Column c2 = new Column();
    Column c3 = new Column();
    Column c4 = new Column();
    Column c5 = new Column();
    Column c6 = new Column();
    Column c7 = new Column();
    Column c8 = new Column();
    Column c9 = new Column();

    Group g1 = new Group();
    Group g2 = new Group();
    Group g3 = new Group();
    Group g4 = new Group();
    Group g5 = new Group();
    Group g6 = new Group();
    Group g7 = new Group();
    Group g8 = new Group();
    Group g9 = new Group();

    List<String> strings = Arrays.asList(puzzleString.split(","));
    if (strings.size() != 81) {
      throw new IllegalArgumentException(
          "strings must represent every position, positions = " + strings.size());
    }

    List<Square> squares = new ArrayList<>();

    squares.add(getSquare(strings.get(0), 1, 1, 1, 1, r1, c1, g1));
    squares.add(getSquare(strings.get(1), 2, 2, 1, 2, r1, c2, g1));
    squares.add(getSquare(strings.get(2), 3, 3, 1, 3, r1, c3, g1));
    squares.add(getSquare(strings.get(3), 4, 4, 1, 1, r1, c4, g2));
    squares.add(getSquare(strings.get(4), 5, 5, 1, 2, r1, c5, g2));
    squares.add(getSquare(strings.get(5), 6, 6, 1, 3, r1, c6, g2));
    squares.add(getSquare(strings.get(6), 7, 7, 1, 1, r1, c7, g3));
    squares.add(getSquare(strings.get(7), 8, 8, 1, 2, r1, c8, g3));
    squares.add(getSquare(strings.get(8), 9, 9, 1, 3, r1, c9, g3));

    squares.add(getSquare(strings.get(9), 10, 1, 2, 4, r2, c1, g1));
    squares.add(getSquare(strings.get(10), 11, 2, 2, 5, r2, c2, g1));
    squares.add(getSquare(strings.get(11), 12, 3, 2, 6, r2, c3, g1));
    squares.add(getSquare(strings.get(12), 13, 4, 2, 4, r2, c4, g2));
    squares.add(getSquare(strings.get(13), 14, 5, 2, 5, r2, c5, g2));
    squares.add(getSquare(strings.get(14), 15, 6, 2, 6, r2, c6, g2));
    squares.add(getSquare(strings.get(15), 16, 7, 2, 4, r2, c7, g3));
    squares.add(getSquare(strings.get(16), 17, 8, 2, 5, r2, c8, g3));
    squares.add(getSquare(strings.get(17), 18, 9, 2, 6, r2, c9, g3));

    squares.add(getSquare(strings.get(18), 19, 1, 3, 7, r3, c1, g1));
    squares.add(getSquare(strings.get(19), 20, 2, 3, 8, r3, c2, g1));
    squares.add(getSquare(strings.get(20), 21, 3, 3, 9, r3, c3, g1));
    squares.add(getSquare(strings.get(21), 22, 4, 3, 7, r3, c4, g2));
    squares.add(getSquare(strings.get(22), 23, 5, 3, 8, r3, c5, g2));
    squares.add(getSquare(strings.get(23), 24, 6, 3, 9, r3, c6, g2));
    squares.add(getSquare(strings.get(24), 25, 7, 3, 7, r3, c7, g3));
    squares.add(getSquare(strings.get(25), 26, 8, 3, 8, r3, c8, g3));
    squares.add(getSquare(strings.get(26), 27, 9, 3, 9, r3, c9, g3));

    //
    squares.add(getSquare(strings.get(27), 28, 1, 4, 1, r4, c1, g4));
    squares.add(getSquare(strings.get(28), 29, 2, 4, 2, r4, c2, g4));
    squares.add(getSquare(strings.get(29), 30, 3, 4, 3, r4, c3, g4));
    squares.add(getSquare(strings.get(30), 31, 4, 4, 1, r4, c4, g5));
    squares.add(getSquare(strings.get(31), 32, 5, 4, 2, r4, c5, g5));
    squares.add(getSquare(strings.get(32), 33, 6, 4, 3, r4, c6, g5));
    squares.add(getSquare(strings.get(33), 34, 7, 4, 1, r4, c7, g6));
    squares.add(getSquare(strings.get(34), 35, 8, 4, 2, r4, c8, g6));
    squares.add(getSquare(strings.get(35), 36, 9, 4, 3, r4, c9, g6));

    squares.add(getSquare(strings.get(36), 37, 1, 5, 4, r5, c1, g4));
    squares.add(getSquare(strings.get(37), 38, 2, 5, 5, r5, c2, g4));
    squares.add(getSquare(strings.get(38), 39, 3, 5, 6, r5, c3, g4));
    squares.add(getSquare(strings.get(39), 40, 4, 5, 4, r5, c4, g5));
    squares.add(getSquare(strings.get(40), 41, 5, 5, 5, r5, c5, g5));
    squares.add(getSquare(strings.get(41), 42, 6, 5, 6, r5, c6, g5));
    squares.add(getSquare(strings.get(42), 43, 7, 5, 4, r5, c7, g6));
    squares.add(getSquare(strings.get(43), 44, 8, 5, 5, r5, c8, g6));
    squares.add(getSquare(strings.get(44), 45, 9, 5, 6, r5, c9, g6));

    squares.add(getSquare(strings.get(45), 46, 1, 6, 7, r6, c1, g4));
    squares.add(getSquare(strings.get(46), 47, 2, 6, 8, r6, c2, g4));
    squares.add(getSquare(strings.get(47), 48, 3, 6, 9, r6, c3, g4));
    squares.add(getSquare(strings.get(48), 49, 4, 6, 7, r6, c4, g5));
    squares.add(getSquare(strings.get(49), 50, 5, 6, 8, r6, c5, g5));
    squares.add(getSquare(strings.get(50), 51, 6, 6, 9, r6, c6, g5));
    squares.add(getSquare(strings.get(51), 52, 7, 6, 7, r6, c7, g6));
    squares.add(getSquare(strings.get(52), 53, 8, 6, 8, r6, c8, g6));
    squares.add(getSquare(strings.get(53), 54, 9, 6, 9, r6, c9, g6));

    //
    squares.add(getSquare(strings.get(54), 55, 1, 7, 1, r7, c1, g7));
    squares.add(getSquare(strings.get(55), 56, 2, 7, 2, r7, c2, g7));
    squares.add(getSquare(strings.get(56), 57, 3, 7, 3, r7, c3, g7));
    squares.add(getSquare(strings.get(57), 58, 4, 7, 1, r7, c4, g8));
    squares.add(getSquare(strings.get(58), 59, 5, 7, 2, r7, c5, g8));
    squares.add(getSquare(strings.get(59), 60, 6, 7, 3, r7, c6, g8));
    squares.add(getSquare(strings.get(60), 61, 7, 7, 1, r7, c7, g9));
    squares.add(getSquare(strings.get(61), 62, 8, 7, 2, r7, c8, g9));
    squares.add(getSquare(strings.get(62), 63, 9, 7, 3, r7, c9, g9));

    squares.add(getSquare(strings.get(63), 64, 1, 8, 4, r8, c1, g7));
    squares.add(getSquare(strings.get(64), 65, 2, 8, 5, r8, c2, g7));
    squares.add(getSquare(strings.get(65), 66, 3, 8, 6, r8, c3, g7));
    squares.add(getSquare(strings.get(66), 67, 4, 8, 4, r8, c4, g8));
    squares.add(getSquare(strings.get(67), 68, 5, 8, 5, r8, c5, g8));
    squares.add(getSquare(strings.get(68), 69, 6, 8, 6, r8, c6, g8));
    squares.add(getSquare(strings.get(69), 70, 7, 8, 4, r8, c7, g9));
    squares.add(getSquare(strings.get(70), 71, 8, 8, 5, r8, c8, g9));
    squares.add(getSquare(strings.get(71), 72, 9, 8, 6, r8, c9, g9));

    squares.add(getSquare(strings.get(72), 73, 1, 9, 7, r9, c1, g7));
    squares.add(getSquare(strings.get(73), 74, 2, 9, 8, r9, c2, g7));
    squares.add(getSquare(strings.get(74), 75, 3, 9, 9, r9, c3, g7));
    squares.add(getSquare(strings.get(75), 76, 4, 9, 7, r9, c4, g8));
    squares.add(getSquare(strings.get(76), 77, 5, 9, 8, r9, c5, g8));
    squares.add(getSquare(strings.get(77), 78, 6, 9, 9, r9, c6, g8));
    squares.add(getSquare(strings.get(78), 79, 7, 9, 7, r9, c7, g9));
    squares.add(getSquare(strings.get(79), 80, 8, 9, 8, r9, c8, g9));
    squares.add(getSquare(strings.get(80), 81, 9, 9, 9, r9, c9, g9));

    return new Puzzle(squares);
  }

  public static Puzzle clone(Puzzle puzzle) {
    puzzle.orderPuzzle();
    List<Square> squares = puzzle.getSquares();

    StringBuilder stringBuilder = new StringBuilder();
    squares.forEach(square -> stringBuilder
        .append(square.getValue() == null ? "?," : square.getValue().toString() + ","));

    Puzzle newPuzzle = build(stringBuilder.toString());
    newPuzzle.orderPuzzle();

    return newPuzzle;

  }


  private static Integer getValue(String value) {
    return (!value.equals("?")) ? Integer.parseInt(value) : null;
  }

  private static Square getSquare(String valueString, Integer positionInPuzzle,
      Integer positionInRow, Integer positionInColumn, Integer positionIngroup, Row row,
      Column column, Group group) {

    Integer value = getValue(valueString);
    Position position =
        new Position(positionInPuzzle, positionInRow, positionInColumn, positionIngroup);
    Square square = new Square(value, position, row, column, group);
    row.addSquare(square);
    column.addSquare(square);
    group.addSquare(square);

    return square;
  }

  public static Puzzle rollback(Puzzle badPuzzle, Puzzle oldPuzzle) {
    oldPuzzle.orderPuzzle();
    badPuzzle.orderPuzzle();

    List<Square> oldSquares = oldPuzzle.getSquares();
    List<Square> badSquares = badPuzzle.getSquares();

    int i = 0;
    for (Square square : badSquares) {
      square.setValue(oldSquares.get(i).getValue());
      i++;
    }
    return badPuzzle;
  }

}
