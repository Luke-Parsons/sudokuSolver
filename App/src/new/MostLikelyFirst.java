/**
 * Created by 
 * @author luke on 27/05/2017.
 *
 * the same as BruteForce but the Set squares are sorted by valuesNotEliminated()
 * in this way the puzzle is traversed by most likely Square next, not just by square number
 *
 */
public class MostLikelyFirst implements PuzzleStrategy {

  @Override
  public void solve(Puzzle puzzle) {
    // less guess, but generally slows things down because of all of the sorting
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
