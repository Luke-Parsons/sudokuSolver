import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Luke Parsons on 14/12/2015.
 */
public interface strategy {
    public void SolvePuzzle(puzzle p);
}

class logicalInference implements  strategy{


    @Override
    public void SolvePuzzle(puzzle puzzle) {
        for (Square s: puzzle.getMySquare().values()){
            HashBlockOut(s);
        }
    }

    private void HashBlockOut(Square square){
        Square s = square;
        Group sQuod = s.getMyQuod();

        HashMap<Integer,Vector<Square>> NumbersCanGoHere = new HashMap<>();
        for (Integer i : sQuod.getValuesToGet()){
            Vector<Square> SquareWhereICanGo = new Vector<>();
            for (Square S : sQuod.getMySquares()){
                if(S.getPotentialValues().contains(i)){
                    SquareWhereICanGo.add(S);
                }
            }
            NumbersCanGoHere.put(i,SquareWhereICanGo);
        }

        for (Integer i: NumbersCanGoHere.keySet()){
            if(NumbersCanGoHere.get(i).size()==1){
                NumbersCanGoHere.get(i).remove(0).lockedInValue(i);
            }
        }
    }



    private Square GetNextEmptySquare(puzzle puzzle){
        for (Integer i:puzzle.getMySquare().keySet()){
            Square s = puzzle.getMySquare().get(i);
            if(!s.islockedIn()){return s;}
        }
        return null;
    }

}


class BruteForce implements  strategy{

    @Override
    public void SolvePuzzle(puzzle p) {// TODO

    }

}
