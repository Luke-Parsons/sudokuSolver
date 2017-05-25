package sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Square {

  private Integer value = null;

  private Position position;
  private Set<Strategy> strategys;

  private Zone row;
  private Zone column;
  private Zone group;

  private boolean hasBeenSet = false;

  public Square(Integer value, Position position, Set<Strategy> strategys, Zone row, Zone column,
      Zone group) {
    this.value = value;
    this.position = position;
    this.strategys = strategys;
    this.row = row;
    this.column = column;
    this.group = group;
  }

  public void setValue(Integer value) {
    this.value = value;
    this.hasBeenSet = true;
  }

  public Position getPosition() {
    return position;
  }

  public Integer getValue() {
    return value;
  }

  public void update() {
   strategys.forEach(strategy -> strategy.solve(this));
  }

  public Set<Integer> getPotentialValues() {
    Set<Integer> values = new HashSet<>();
    values.add(1);
    values.add(2);
    values.add(3);
    values.add(4);
    values.add(5);
    values.add(6);
    values.add(7);
    values.add(8);
    values.add(9);

    values.removeAll(row.getValues());
    values.removeAll(column.getValues());
    values.removeAll(group.getValues());
    return values;
  }

  public Set<Integer> getRowPotentialValues() {
    return row.getMissingValues();
  }

  public Set<Integer> getColumnValues() {
    return column.getMissingValues();
  }

  public Set<Integer> getGroupValues() {
    return group.getMissingValues();
  }

  public Set<Strategy> getStrategys() {
    return strategys;
  }

  public Zone getRow() {
    return row;
  }

  public Zone getColumn() {
    return column;
  }

  public Group getGroup() {
    return (Group) group;
  }

  @Override
  public String toString() {
    return (value == null) ? "-"
        : ((hasBeenSet) ? "\033[31m" + value.toString() + "\033[0m" : value.toString());
  }
}
