import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 
 * @author luke on 29/05/2017.
 */
public class ZoneWiseElimination implements PuzzleStrategy {

  private Colour colour = Colour.TURQUOISE;

  @Override
  public void solve(Puzzle puzzle) {

    // consider each zone in turn
    // get the empty position
    // for each value left to get
    // if value is is contained within the only one of the
    // squares "StrategyHelper.valuesNotEliminated()"
    // set values

    Set<Zone> allZones = StrategyHelper.getAllZones(puzzle);

    allZones.forEach(this :: zoneWiseElimination);
  }

  private void zoneWiseElimination(Zone zone) {

    // get the empty position
    Set<Square> emptySquareInZone = StrategyHelper.getAllEmptySquareInZone(zone);

    // for each value left to get
    Set<Integer> missingValues = zone.getMissingValues();

    for (Integer value : missingValues) {
      List<Square> squares = emptySquareInZone.parallelStream()
          .filter(square -> StrategyHelper.valuesNotEliminated(square).contains(value))
          .collect(Collectors.toList());
      // if value is is contained within the only one of the
      // squares "StrategyHelper.valuesNotEliminated()"
      // set values
      if (squares.size() == 1 && StrategyHelper.canValueGoInSquare(value, squares.get(0))) {
        squares.get(0).setValue(value, colour);

      }

    }

  }
}
