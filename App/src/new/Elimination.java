

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Set;

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

    if (valuesNotEliminated(square).size() == 1) {
      square.setValue(new ArrayList<>(valuesNotEliminated(square)).get(0));
    }
  }

  public static Set<Integer> valuesNotEliminated(Square square) {
    Set<Integer> values = Sets.newHashSet(1,2,3,4,5,6,7,8,9);

    values.removeAll(square.getRow().getValues());
    values.removeAll(square.getColumn().getValues());
    values.removeAll(square.getGroup().getValues());
    return values;
  }
}
