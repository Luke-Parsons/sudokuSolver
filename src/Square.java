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

    public Integer getPosition() {
        return Position;
    }

    public Group getMyQuod() {
        return myQuod;
    }

    public Group getMyColunm() {
        return myColunm;
    }

    public Group getMyRow() {
        return myRow;
    }

    public boolean islockedIn(){
        return this.lockedIn;
    }

    public void lockedInValue(Integer X){

        this.myPuzzzle.UpDateSquares();

        if(this.camGoHere(X)) {
            System.out.println("\nin lockedInValue(" + X + "): " + Position);
            this.PotentialValues.clear();
            this.lockedIn = true;
            this.Value = X;

            //this.myPuzzzle.upDate();
            this.myColunm.LockedInValue(this);
            this.myRow.LockedInValue(this);
            this.myQuod.LockedInValue(this);
        }

    }

    private boolean camGoHere(Integer X){
        if(this.islockedIn()){return false;}
        if(this.Value!=null){return false;}
        System.out.print(" - Square ("+Position+") :Value = "+Value+" : PotentialValues =  "+PotentialValues+ ": X = "+ X  +": this.PotentialValues.contains(X) + "+this.PotentialValues.contains(X) );
        if(!this.PotentialValues.contains(X)){return false;}
        return true;
    }
    public void upDateMe(){
        PotentialValues.removeAll(myRow.getValuesLockedIn());
        PotentialValues.removeAll(myColunm.getValuesLockedIn());
        PotentialValues.removeAll(myQuod.getValuesLockedIn());
    }

    public void update(Group g) {
       /*for(Integer i: g.getValuesLockedIn()){
            if(this.PotentialValues.contains(i)){
                this.PotentialValues.remove(PotentialValues.indexOf(i));
            }
        }*/
        PotentialValues.removeAll(g.getValuesLockedIn());
        upDateMe();
        if(this.PotentialValues.size()==1){
            Integer ThisSquaresValue = this.PotentialValues.get(0);
            this.lockedInValue(ThisSquaresValue);
        }

    }

    @Override
    public String toString() {
        if(islockedIn()){return String.valueOf(this.Value);}
        else {return " ";}

    }
}
