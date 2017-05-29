import java.util.Set;

/**
 * Created by 
 * @author luke on 29/05/2017.
 */
public class ZoneWiseElimination implements PuzzleStrategy {

  @Override
  public void solve(Puzzle puzzle) {
    // TODO: 29/05/2017
// consider each zone in turn
// get the empty position
// for each value left to get
// if value is is contained within the only one of the
    // squares "StrategyHelper.valuesNotEliminated()"
    // set values

  }

  private void zoneWiseElimination(Zone zone){

    // TODO: 29/05/2017  
    // get the empty position
    Set<Square> emptySquareInZone = StrategyHelper.getAllEmptySquareInZone(zone);

    // for each value left to get
    Set<Integer> missingValues = zone.getMissingValues();
    
    for (Integer value : missingValues){
//      emptySquareInZone.parallelStream().filter(square -> StrategyHelper.)
    }

    // if value is is contained within the only one of the
    // squares "StrategyHelper.valuesNotEliminated()"
    // set values


  }
}
