import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by Luke Parsons on 14/12/2015.
 */
public class Square {

    private puzzle myPuzzzle;
    private boolean lockedIn;
    private Integer Position;
    private Integer Value;
    private Vector<Integer> PotentialValues;
    private Group myColunm;
    private Group myRow;
    private Group myQuod;


    public Square(Integer position, puzzle puzzle){
        this.myPuzzzle = puzzle;
        this.Position = position;
        this.lockedIn = false;

        Integer[] VTG = new Integer[]{1,2,3,4,5,6,7,8,9};
        this.PotentialValues = new Vector<>();
        PotentialValues.addAll(Arrays.asList(VTG));
    }


    public Vector<Integer> getPotentialValues() {
        return PotentialValues;
    }

    public void setMyRow(Group myRow) {
        this.myRow = myRow;
    }

    public void setMyColunm(Group myColunm) {
        this.myColunm = myColunm;
    }

    public void setMyQuod(Group myQuod) {
        this.myQuod = myQuod;
    }


    public Integer getValue() {
        return Value;
    }

    public Group getMyQuod() {
        return myQuod;
    }

    public boolean islockedIn(){
        return this.lockedIn;
    }

    public void lockedInValue(Integer X){
        if(this.lockedIn==false) {
            System.out.println("in lockedInValue(" + X + "): " + Position);
            this.PotentialValues.clear();
            this.lockedIn = true;
            this.Value = X;

            this.myColunm.LockedInValue(this);
            this.myRow.LockedInValue(this);
            this.myQuod.LockedInValue(this);
        }
    }


    public void update(Group g) {

        for(Integer i: g.getValuesLockedIn()){
            if(this.PotentialValues.contains(i)){
                this.PotentialValues.remove(i);
            }
        }

        if(this.PotentialValues.size()==1){
            Integer ThisSquaresValue = this.PotentialValues.remove(0);
            this.lockedInValue(ThisSquaresValue);
        }

    }

    @Override
    public String toString() {
        if(islockedIn()){return String.valueOf(this.Value);}
        else {return " ";}

    }
}
