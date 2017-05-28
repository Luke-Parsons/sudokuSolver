import java.util.ArrayList;

/**
 * Created by 
 * @author luke on 25/05/2017.
 */
public class AdvanceBlockOut implements SquareStrategy {

  private static Colour colour = Colour.TURQUOISE;

  @Override
  public void solve(Square square) {
    //todo

    // | X,X,X | +,+,X |  ,X,  |
    // | X,8,X | X, ,X |  , ,  |
    // |  , ,X | X,?,X | X,X,X |

    // so you know that "?" has to be "8"
    // Elimination and BlockOut would think that "8" could possibly go in "+" or "+"

    // are all potential positions of value in group in the same row
    // todo  as zeg zag
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
  }

  private void advanceBlockOut(Group group) {

    ArrayList<Group> horizontallyGroups =
        new ArrayList<>(StrategyHelper.getOtherGroupsHorizontally(square));
    ArrayList<Group> verticallyGroups =
        new ArrayList<>(StrategyHelper.getOtherGroupsVertically(square));

    Group h1 = horizontallyGroups.get(0);
    Group h2 = horizontallyGroups.get(1);

    Group v1 = verticallyGroups.get(0);
    Group v2 = verticallyGroups.get(1);

    // set rowsBlockOut
    // set columnsBlockOut

    for (Integer value : group.getMissingValues()) {

      // set rowsBlockOut
      // set columnsBlockOut

      //////////////////////////////////////

      // set1 = get the rows this value can go (or is) in group h1
      // if set.size() == 1 add to rowsBlockOut

      // set2 = get the rows this value can go (or is) in group h2
      // if set.size() == 1 add to rowsBlockOut

      // zigzag problem
      // if set1 and set2 contain the same rows
      // addAll to rowsBlockOut

      //////////////////////////////////////

      // set3 = get the Column this value can go (or is) in group v1
      // if set.size() == 1 add to columnsBlockOut

      // set4 = get the Column this value can go (or is) in group v2
      // if set.size() == 1 add to columnsBlockOut

      // zigzag problem
      // if set3 and set4 contain the same rows
      // addAll to columnsBlockOut

      ////////////////////////////////////////////////////////////

      // set canGo = group get squares ware this value can go in this group

      // canGo.remove any square which has a row which is in rowsBlockOut
      // canGo.remove any square which has a column which is in columnsBlockOut

      // if canGo.size == 1
      // if value canGo square
      // canGo.get(0).setValue(value , colour)
    }

  }

  private void advanceBlockOutByRow(Square square) {

  }

  private void advanceBlockOutByColumn(Square square) {

  }

}
