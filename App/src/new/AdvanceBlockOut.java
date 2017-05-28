import java.util.Set;
import java.util.stream.Collectors;

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

  }

  private void advanceBlockOut(Square square){

  }

  private void advanceBlockOutByRow(Square square){
    Set<Row> adjacentRows = StrategyHelper.getAdjacentRows(square);

    Set<Group> otherGroups = StrategyHelper.getOtherGroupsHorizontally(square);

    valuesLoop:
    for (Integer value: StrategyHelper.valuesNotEliminated(square)) {

      if (!(StrategyHelper.getAdjacentSquaresInRow(square).stream().filter(square1 -> square
          .getValue() == null).collect(Collectors.toSet()).size() == 0)){
        continue;
      }

      for (Group group : otherGroups) {
        // are all potential positions of value in group in the same row
        // todo  as zeg zag
        //               8
        // | ?,X,X |  , ,X | ?,X,X |
        // | X,?,X | X, ,X |  ,?,  |
        // |  , ,X | X,a,  | X,X,X |

        if (!StrategyHelper.allPotentialPositionsOfValueInGroupInTheSameRow(value, group)) {
          continue valuesLoop;
        }
      }

      // if it has got this far we can set value
      if (StrategyHelper.valuesNotEliminated(square).contains(value)){
        square.setValue(value,colour);
      }

    }

  }

  private void advanceBlockOutByColumn(Square square){

  }

}
