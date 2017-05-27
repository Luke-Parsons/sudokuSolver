/**
 * Created by 
 * @author luke on 27/05/2017.
 *
 * the same as BruteForce but the Set squares are sorted by valuesNotEliminated()
 * in this way the puzzle is traversed by most likely Square next, not just by square number
 */
public class MostLikelyFirst implements SpeedFactor {

  @Override
  public void process(Puzzle puzzle) {
    puzzle.getSquares().sort((s1, s2) -> {
      if (s1.theNumOfValuesNotEliminated() < s2.theNumOfValuesNotEliminated()) {
        return -1;
      } else if (s1.theNumOfValuesNotEliminated() > s2.theNumOfValuesNotEliminated()) {
        return 1;
      } else {
        return 0;
      }
    });
  }

}
