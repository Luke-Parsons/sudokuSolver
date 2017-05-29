/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Square {

  private Integer value = null;

  private Position position;

  private Row row;
  private Column column;
  private Group group;

  private Colour colour = Colour.BLANK;

  public Square(Integer value, Position position, Row row, Column column, Group group) {
    this.value = value;
    this.position = position;
    this.row = row;
    this.column = column;
    this.group = group;
  }

  public void resetValue(Colour colour) {
    this.value = null;
    this.colour = colour;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public void setValue(Integer value, Colour colour) {

    if (!StrategyHelper.canValueGoInSquare(value, this)) {
      this.colour = Colour.HIGHLIGHTED;
      throw new IllegalArgumentException("strategy has made a mistake");
    }
    this.value = value;
    this.colour = colour;
  }

  public void setColour(Colour colour) {
    this.colour = colour;
  }

  public Colour getColour() {
    return colour;
  }

  public Position getPosition() {
    return position;
  }

  public Integer getValue() {
    return value;
  }

  public Row getRow() {
    return row;
  }

  public Column getColumn() {
    return column;
  }

  public Group getGroup() {
    return (Group) group;
  }

  public int theNumOfValuesNotEliminated() {
    return StrategyHelper.valuesNotEliminated(this).size();
  }

  @Override
  public String toString() {
    return colour.getColourString() + ((value == null) ? "-" : value.toString()) + Colour.BLANK
        .getColourString();
  }

  // for debugging ///////////////////////////////

  //  @Override
  //  public String toString() {
  //    return (value == null) ? "0" : value.toString();
  //  }

  //  @Override
  //  public String toString() {
  //    return theNumOfValuesNotEliminated() + "";
  //  }
}
