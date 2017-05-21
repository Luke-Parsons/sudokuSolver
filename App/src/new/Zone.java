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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by
 * @author luke on 21/05/2017.
 */
public abstract class Zone {

  /**
   * field and values
   */
  protected Map<Integer, Integer> map = new HashMap<>();

  protected boolean containsValue(Integer value) {
    return map.containsValue(value);
  }

  protected abstract void addValue(Position position, Integer value);

  public boolean hasOneSquareLeft() {
    return map.size() == 8;
  }

  public Integer getMissingValue() {
    for (Integer i = 1; i <= 9; i++) {
      if (!map.containsValue(i)) {
        return i;
      }
    }
    return null;
  }

  public Set<Integer> getMissingValues() {
    Set<Integer> missingValues = new HashSet<>();
    for (Integer i = 1; i <= 9; i++) {
      if (!map.containsValue(i)) {
        missingValues.add(i);
      }
    }
    return missingValues;
  }

}
