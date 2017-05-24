package sudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class BlockOut implements Strategy {

  @Override
  public void solve(Square square) {

    if (square.getValue() == null) {
      Set<Integer> potentialInTheAllOtherSquares = new HashSet<>();
      List<Square> otherSquaresInThisGroup = square.getGroup().getOtherSquaresInThisGroup(square);
      otherSquaresInThisGroup.forEach(s -> potentialInTheAllOtherSquares.addAll(s.getPotentialValues()));

      Set<Integer> potentialValuesForSquare = square.getPotentialValues();

      for (Integer value : square.getGroup().getMissingValues()) {
        if (potentialValuesForSquare.contains(value) && !potentialInTheAllOtherSquares.contains(value)) {
          square.setValue(value);
        }
      }
    }
  }
}
