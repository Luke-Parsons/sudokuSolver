package strategies.squarestrategies;

import java.util.ArrayList;

import puzzle.Square;
import strategies.Colour;
import strategies.StrategyHelper;

/**
 * Created by 
 * @author luke on 25/05/2017.
 */
public class Elimination implements SquareStrategy {

  private static Colour colour = Colour.BLUE;

  @Override
  public void solve(Square square) {
    if (square.getValue() != null) {
      return;
    }

    if (StrategyHelper.valuesNotEliminated(square).size() == 1) {
      square.setValue(new ArrayList<>(StrategyHelper.valuesNotEliminated(square)).get(0), colour);
    }
  }

}
