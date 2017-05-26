

import java.util.ArrayList;

/**
 * Created by 
 * @author luke on 25/05/2017.
 */
public class Elimination implements Strategy {

  @Override
  public void solve(Square square) {
    if (square.getValue() != null) {
      return;
    }

    if (StrategyHelper.valuesNotEliminated(square).size() == 1) {
      square.setValue(new ArrayList<>(StrategyHelper.valuesNotEliminated(square)).get(0));
    }
  }

}
