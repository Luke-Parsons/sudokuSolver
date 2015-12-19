import java.util.*;

/**
 * Created by Luke Parsons on 14/12/2015.
 */
public class puzzle {

    private strategy TheStrategy;
    private boolean Solved;
    private Vector<Group> myGroups;
    private HashMap<Integer,Square> mySquare;
    private Vector<Group> CompleteGroups;

    public puzzle(strategy theStrategy, String PuzzleString) {
        this.mySquare = new HashMap<>();
        this.myGroups = new Vector<>();
        this.CompleteGroups = new Vector<>();
        this.TheStrategy = theStrategy;

        this.makeSquares();
        this.AllocateGroups();
        this.AllocateSquares(PuzzleString);

        this.Solved=false;
        this.upDate();
    }

    public HashMap<Integer, Square> getMySquare() {
        return mySquare;
    }

    private void makeSquares(){
        for (int i = 0; i < 9*9 ;i++ ){
            Square s = new Square(i,this);
            mySquare.put(i,s);
        }
    }


    private void AllocateSquares(String PuzzleString){
        PuzzleString = PuzzleString.replace("0"," ").replace("|","").replace(",","").replace("+","").replace("\n","").replace("-","").replace(" ","X");
        char[] SquaresCharacters = PuzzleString.toCharArray();

        for (int i = 0; i < 9*9 ;i++ ){
            Square s = mySquare.get(i);
            if(SquaresCharacters[i]!='X'){s.lockedInValue(Integer.parseInt(SquaresCharacters[i]+""));}
            this.mySquare.put(i,s);
        }

    }

    private void AllocateGroups(){
        for (int x = 0; x<9; x++) {

            Group Colunm = new Group(this,GroupType.Colunm,x);
            for (int c = 0+x; c<9 * 9; c += 9) {
                  Colunm.register(mySquare.get(c));
                  Square s = mySquare.get(c);
                  s.setMyColunm(Colunm);
                  if(s.islockedIn()){Colunm.LockedInValue(s);}
            }
            register(Colunm);

            Group Row = new Group(this,GroupType.Row,x);
            for(int r = x*9; r<(x*9)+9; r++){
                  Row.register(mySquare.get(r));
                  Square s = mySquare.get(r);
                  s.setMyRow(Row);
                  if(s.islockedIn()){Row.LockedInValue(s);}
            }
            register(Row);

        }

        Vector<Integer> g = new Vector<>(Arrays.asList(new Integer[]{0,3,6,27,30,33,60,63,66}));
        for(int i: g){
            Group quod = new Group(this,GroupType.Quod,i);
            for (int Index: getBoxIndexs(i)){
                quod.register(mySquare.get(Index));
                Square s = mySquare.get(Index);
                s.setMyQuod(quod);
                if(s.islockedIn()){quod.LockedInValue(s);}
            }
           register(quod);
        }
    }


    private static Vector<Integer> getBoxIndexs(int Index){
        Vector<Integer> out = new Vector<>();
        int start = Index;
        start-=start%3;
        while (!(start==0||start==3||start==6||start==27||start==30||start==33||start==54||start==57||start==60)){start-=9;}
        for (int i = start, count = 0,a = 0  ; a<9; i++,count++,a++ ){
            if(count==3){count=0; i+= 6;}
            out.add(i);
        }
        return out;
    }


    public void register(Group g) {
        this.myGroups.add(g);
    }


    public void LockInGroup(Group g){
        CompleteGroups.add(g);
        if(CompleteGroups.size()==27){
            Solved = true;
        }
    }


    public puzzle Solve(){

        puzzle out = this.TheStrategy.SolvePuzzle(this);
       while (!out.isSolved()) {

           // out.upDate();
           System.out.println("out.isSolved() =" + out.isSolved());

           if (!out.isSolved()) {
               TheStrategy = new BruteForce();
               out = this.TheStrategy.SolvePuzzle(this);

           }
       }
        return out;
    }

    public boolean isSolved(){
        return this.Solved;
    }

    public void UpDateSquares(){
        for (Square s: mySquare.values()){
            s.upDateMe();
        }
    }

    public void upDate(){
        for(Group g : myGroups){
         g.updateSquares();
        }

    }


    @Override
    public String toString() {
        String out = "";
        for (Integer Position = 0; Position < (9*9); Position++ ){
            if(Position%9==0&&Position!=0){out = out +"-|";}
            if(Position%9==0){out = out +"\n-+---+---+---+---+---+---+---+---+---+\n";}
            out = out+"-|-"+mySquare.get(Position);
        }
        out = out +"-|\n-+---+---+---+---+---+---+---+---+---+";

        return out;
    }
}
