
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by
 * @author luke on 21/05/2017.
 */
public abstract class Zone {

  /**
   * field and values
   */
  protected Map<Integer, Square> map = new HashMap<>();

  protected boolean containsValue(Integer value) {
    return map.values().stream().map(Square:: getValue).collect(Collectors.toList())
        .contains(value);
  }

  protected abstract void addSquare(Square square);

  public boolean hasOneSquareLeft() {
    return getValues().size() == 8;
  }

  public Integer getMissingValue() {
    for (Integer i = 1; i <= 9; i++) {
      if (!map.values().stream().map(Square:: getValue).collect(Collectors.toList()).contains(i)) {
        return i;
      }
    }
    return null;
  }

  public Set<Integer> getMissingValues() {
    Set<Integer> missingValues = new HashSet<>();
    for (Integer i = 1; i <= 9; i++) {
      if (!map.values().stream().map(Square:: getValue).collect(Collectors.toList()).contains(i)) {
        missingValues.add(i);
      }
    }
    return missingValues;
  }

  public Set<Integer> getValues() {
    Set<Integer> values = new HashSet<>();
    for (Integer i = 1; i <= 9; i++) {
      if (map.values().stream().map(Square:: getValue).collect(Collectors.toList()).contains(i)) {
        values.add(i);
      }
    }
    return values;
  }

  public Set<Square> getOtherSquaresInThisZone(Square square) {
    Set<Square> values = new HashSet<>(map.values());
    values.remove(square);
    return values;
  }

  public Set<Square> getOtherSquaresInGroup(Group group, Square square) {
    Set<Square> squaresInGroup = getSquaresInGroup(group);
    squaresInGroup.remove(square);
    return squaresInGroup;
  }

  public Set<Square> getSquaresInGroup(Group group) {
    Set<Square> squares = new HashSet<>();
    for (Square square : map.values()) {
      if (group.contains(square)) {
        squares.add(square);
      }
    }
    return squares;
  }

  public Set<Square> getSquares(){
    return Sets.newHashSet(map.values());
  }

  public Set<Square> getEmptySquares() {
    return map.values().stream().filter(square -> square.getValue() == null)
        .collect(Collectors.toSet());
  }

}
