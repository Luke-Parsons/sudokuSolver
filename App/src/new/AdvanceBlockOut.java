
/**
 * Created by 
 * @author luke on 25/05/2017.
 */
public class AdvanceBlockOut implements SquareStrategy {
  @Override
  public void solve(Square square) {
    //todo

    // X,X,X | +,+,X |  ,X,
    // X,8,X | X, ,X | X,X,X
    //  , ,X | X,?,X | X,X,X

    // so you know that "?" has to be "8"
    // Elimination and BlockOut would think that "8" could possibly go in "+" or "+"

  }
}
