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

       // ------|------|------
       // - 7 - |3 - 2 |- - -
       // 8 - - |- - - |1 - 4
       // 6 - - |- 1 - |- - -
       // ------|------|------
       // - - 8 |- 3 - |- 1 -
       // - 1 - |9 - 6 |- 5 -
       // - 4 - |- 7 - |3 - -
       // ------|------|------
       // - - - |- 2 - |- - 3
       // 9 - 2 |B - 3 |- - 7
       // - - - |- A 7 |2 8 1
       // ------|------|------

       // A = 9
       // B = 1
  }

  private void advanceBlockOut(Square square){


  }

  private void advanceBlockOutByRow(Square square){



  }

  private void advanceBlockOutByColumn(Square square){

  }

}
