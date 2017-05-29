import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 
 * @author luke on 25/05/2017.
 */
public class AdvanceBlockOut implements PuzzleStrategy {

  private static Colour colour = Colour.VIOLET;

  @Override
  public void solve(Puzzle puzzle) {
    //todo

    // | X,X,X | +,+,X |  ,X,  |
    // | X,8,X | X, ,X |  , ,  |
    // |  , ,X | X,?,X | X,X,X |

    // so you know that "?" has to be "8"
    // Elimination and BlockOut would think that "8" could possibly go in "+" or "+"

    // are all potential positions of value in group in the same row
    // zigzag problem
    //               8
    // | ?,X,X |  , ,X | ?,X,X |
    // | X,?,X | X, ,X |  ,?,  |
    // |  , ,X | X,a,  | X,X,X |

    // ------|------|------
    // - 7 - |3 - 2 |- - -
    // 8 - - |- - - |1 - 4
    // 6 - - |- 1 - |- - -
    // ------|------|------
    // - - 8 |- 3 - |- 1 -
    // - 1 - |9 - 6 |- 5 -
    // - 4 - |- 7 - |3 - -
    // ------|------|------
    // - - - |- 2 - |- - 3
    // 9 - 2 |B - 3 |- - 7
    // - - - |- A 7 |2 8 1
    // ------|------|------

    // A = 9
    // B = 1

    StrategyHelper.getAllGroup(puzzle).forEach(this :: advanceBlockOut);

  }

  private void advanceBlockOut(Group thisGroup) {

    ArrayList<Group> horizontallyGroups =
        new ArrayList<>(StrategyHelper.getOtherGroupsHorizontally(thisGroup));
    ArrayList<Group> verticallyGroups =
        new ArrayList<>(StrategyHelper.getOtherGroupsVertically(thisGroup));

    Group h1 = horizontallyGroups.get(0); // good
    Group h2 = horizontallyGroups.get(1); // good

    Group v1 = verticallyGroups.get(0);  // good
    Group v2 = verticallyGroups.get(1);  // good

    for (Integer value : thisGroup.getMissingValues()) { // good

      // set rowsBlockOut
      HashSet<Row> rowsBlockedOut = new HashSet<>();
      // set columnsBlockOut
      HashSet<Column> columnBlockedOut = new HashSet<>();

      //////////////////////////////////////

      // set1 = get the rows this value can go (or is) in thisGroup h1
      // if set.size() == 1 add to rowsBlockOut
      Set<Row> set1 = StrategyHelper.getRowsThisValueCanGoInOrIsIn(value, h1);
      if (set1.size() == 1) {
        rowsBlockedOut.addAll(set1);
      }

      // set2 = get the rows this value can go (or is) in thisGroup h2
      // if set.size() == 1 add to rowsBlockOut
      Set<Row> set2 = StrategyHelper.getRowsThisValueCanGoInOrIsIn(value, h2);
      if (set2.size() == 1) {
        rowsBlockedOut.addAll(set2);
      }

      // zigzag problem
      // if (set1 and set2 contain the same rows) and (set.size() == 2)
      // addAll to rowsBlockOut
      if (set1.size() == 2 && set2.size() == 2) {
        set1.removeAll(set2);
        if (set1.size() == 0) {
          rowsBlockedOut.addAll(set2);
        }
      }

      //////////////////////////////////////

      // set3 = get the Column this value can go (or is) in thisGroup v1
      // if set.size() == 1 add to columnsBlockOut
      Set<Column> set3 = StrategyHelper.getColumnsThisValueCanGoInOrIsIn(value, v1);
      if (set3.size() == 1) {
        columnBlockedOut.addAll(set3);
      }

      // set4 = get the Column this value can go (or is) in thisGroup v2
      // if set.size() == 1 add to columnsBlockOut
      Set<Column> set4 = StrategyHelper.getColumnsThisValueCanGoInOrIsIn(value, v2);
      if (set4.size() == 1) {
        columnBlockedOut.addAll(set4);
      }

      // zigzag problem
      // if set3 and set4 contain the same column and (set.size() == 2)
      // addAll to columnsBlockOut
      if (set3.size() == 2 && set4.size() == 2) {
        set3.removeAll(set4);
        if (set4.size() == 0) {
          columnBlockedOut.addAll(set3);
        }
      }

      ////////////////////////////////////////////////////////////

      // set canGo = thisGroup get squares ware this value can go in this thisGroup
      Set<Square> potentialSquaresForValue =
          StrategyHelper.getPotentialSquaresForThisValueInGroup(value, thisGroup);

      // canGo.remove any square which has a row which is in rowsBlockOut
      potentialSquaresForValue = potentialSquaresForValue.parallelStream()
          .filter(square -> !rowsBlockedOut.contains(square.getRow())).collect(Collectors.toSet());

      // canGo.remove any square which has a column which is in columnsBlockOut
      potentialSquaresForValue = potentialSquaresForValue.parallelStream()
          .filter(square -> !columnBlockedOut.contains(square.getColumn()))
          .collect(Collectors.toSet());

      //////////////////////////////////////////////////////////////////////////////

      // if canGo.size == 1
      // if value canGo square
      if (potentialSquaresForValue.size() == 1) {
        Square square = new ArrayList<>(potentialSquaresForValue).get(0);
        if (StrategyHelper.canValueGoInSquare(value, square)) {
          // canGo.get(0).setValue(value , colour)
          square.setValue(value, colour);
        }
      }

      ///////////////////////////////////////////////////////////////////////////


    }

  }

}
