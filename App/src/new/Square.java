/**
 * ***********************************************************************
 *
 * ECHOBOX CONFIDENTIAL
 *
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of Echobox Ltd. and its
 * suppliers, if any. The intellectual and technical concepts contained herein are proprietary to
 * Echobox Ltd. and its suppliers and may be covered by Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information or reproduction of
 * this material, in any format, is strictly forbidden unless prior written permission is obtained
 * from Echobox Ltd.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Square {

  private Integer value = null;

  private Position position;
  private Strategy strategy;
  private Zone row;

  private Zone column;
  private Zone group;

  public Square(Integer value, Position position, Strategy strategy, Zone row, Zone column,
      Zone group) {
    this.value = value;
    this.position = position;
    this.strategy = strategy;
    this.row = row;
    this.column = column;
    this.group = group;
  }

  public void setValue(Integer value) {
    this.value = value;
    row.addValue(position, value);
    column.addValue(position, value);
    group.addValue(position, value);
  }

  public void update() {
    if (value != null) {
      return;
    }

    lastSquareLeft();

    if (value != null) {
      return;
    }
    strategy.solve(this);
  }

  private void lastSquareLeft() {
    if (row.hasOneSquareLeft()) {
      setValue(row.getMissingValue());
    }
    if (column.hasOneSquareLeft()) {
      setValue(column.getMissingValue());
    }
    if (group.hasOneSquareLeft()) {
      setValue(group.getMissingValue());
    }
  }

  public Set<Integer> getPotentialValues() {
    Set<Integer> values = new HashSet<>();
    values.addAll(row.getMissingValues());
    values.addAll(column.getMissingValues());
    values.addAll(group.getMissingValues());
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

  @Override
  public String toString() {
    return (value == null) ? "?" : value.toString();
  }
}
