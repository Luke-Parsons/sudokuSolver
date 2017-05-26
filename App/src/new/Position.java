
/**
 * Created by 
 * @author luke on 21/05/2017.
 */
public class Position {

  private Integer positionInPuzzle;

  private Integer positionInRow;
  private Integer positionInColumn;
  private Integer positionInGroup;

  public Position(Integer positionInPuzzle, Integer positionInRow, Integer positionInColumn,
      Integer positionInGroup) {
    this.positionInPuzzle = positionInPuzzle;
    this.positionInRow = positionInRow;
    this.positionInColumn = positionInColumn;
    this.positionInGroup = positionInGroup;
  }

  public Integer getPositionInPuzzle() {
    return positionInPuzzle;
  }

  public Integer getPositionInRow() {
    return positionInRow;
  }

  public Integer getPositionInColumn() {
    return positionInColumn;
  }

  public Integer getPositionInGroup() {
    return positionInGroup;
  }
}
