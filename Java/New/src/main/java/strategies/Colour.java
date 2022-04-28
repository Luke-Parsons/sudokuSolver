package strategies;

/**
 * Created by 
 * @author luke on 27/05/2017.
 */
public enum Colour {

  BLANK("\033[0m"),

  UNDERLINED("\033[4m"),

  HIGHLIGHTED("\033[7m"),

  BOLD("\033[30m"),

  RED("\033[31m"),

  YELLOW("\033[32m"),

  BLUE("\033[34m"),

  VIOLET("\033[35m"),

  TURQUOISE("\033[36m");

  private String colourString;

  Colour(String colourString) {
    this.colourString = colourString;
  }

  public String getColourString() {
    return colourString;
  }
}
