import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Luke Parsons on 14/12/2015.
 */
public interface strategy {
    puzzle SolvePuzzle(puzzle puzzle);
}

class logicalInference implements  strategy{


    @Override
    public puzzle SolvePuzzle(puzzle puzzle) {
        while (true){
            String oldPuzzle = puzzle.toString();
            puzzle.getMySquare().values().forEach(this::HashBlockOut);
            puzzle.getMySquare().values().forEach(this::ColumnBlockOut);
            puzzle.getMySquare().values().forEach(this::RowBlockOut);
            if(puzzle.toString().equals(oldPuzzle)){break;}
        }
        return puzzle;
    }

    private void HashBlockOut(Square square){
        BlockOut(square,square.getMyQuod());
    }

    private void ColumnBlockOut(Square square){
        BlockOut(square,square.getMyColunm());
    }

    private void RowBlockOut(Square square){
        BlockOut(square,square.getMyRow());
    }

    private void BlockOut(Square square, Group group){
        Square s = square;
        Group g = group;

        HashMap<Integer,Vector<Square>> NumbersCanGoHere = new HashMap<>();
        for (Integer i : g.getValuesToGet()){
            Vector<Square> SquareWhereICanGo = new Vector<>();
            for (Square S : g.getMySquares()){
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


}



class BruteForce implements  strategy{
    public static Integer numOfProps = 0;
    public puzzle SolvePuzzle(puzzle p) {
        numOfProps++;
        p = new logicalInference().SolvePuzzle(p);
        //System.out.println("prop "+numOfProps+" "+p.toString());
        if(getNextEmptySquare(p)==null){return  p;}
        else if(getNextEmptySquare(p).getPotentialValues().size()==0){return p;}
        else {
            for (Integer i : getNextEmptySquare(p).getPotentialValues()){
             puzzle newPuzzle = new puzzle(new logicalInference(),p.toString()) ;
             Square s = getNextEmptySquare(newPuzzle);
             if(s != null){s.lockedInValue(i);}
             if(newPuzzle.isSolved()){//System.out.println("isSolved()");
                 return newPuzzle;}
             else{
                 puzzle X = SolvePuzzle(newPuzzle);
                 if(X.isSolved()){return X;}
             }

            }
           return p;
        }


    }

    private Square getRadodmEmptySquare(puzzle puzzle){
        Vector<Square> EmptySquare = new Vector<>();
        for(Square s: puzzle.getMySquare().values()){
            if(!s.islockedIn()){EmptySquare.add(s);}
        }
        Random r = new Random();
        return EmptySquare.get(r.nextInt(EmptySquare.size()-1));
    }

    private Square getNextEmptySquare(puzzle puzzle){
        for(Integer i: puzzle.getMySquare().keySet()){
            Square s = puzzle.getMySquare().get(i);
            if(!s.islockedIn()){
                //System.out.println("returning Square "+s.getValue()+" @ "+s.getPosition());
                return s;}
        }
        return null;
    }



}
