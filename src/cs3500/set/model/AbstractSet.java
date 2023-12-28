package cs3500.set.model;

import java.util.ArrayList;
import java.util.List;

import cs3500.set.model.hw02.Cards;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.Shape;

/**
 * Represents the Abstract class that implements the SetGameModel.
 * This class is implemented currently by two different types of games:
 * SetThree and General where the size of gameboard and game will differ
 * depending on the model chosen.
 */
public abstract class AbstractSet implements SetGameModel<Cards> {

  protected Cards[][] board;
  protected int row;
  protected int col;
  protected int score;

  protected List<Cards> cardList;
  protected boolean hasStarted = false;
  protected boolean isOver = false;
  protected int height;
  protected int width;

  /**
   * constructor for abstract set; initializes the cardlist to a new arraylist.
   */
  public AbstractSet() {
    cardList = new ArrayList<>();

  }


  /**
   * claims the set when given three coordinates.
   *
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   */
  public abstract void claimSet(Coord coord1, Coord coord2, Coord coord3);

  /**
   * starts the game with the given parameters.
   *
   * @param deck   the list of cards in the order they will be played
   * @param height the height of the board for this game
   * @param width  the width of the board for this game
   * @throws IllegalArgumentException if the arguments are not valid.
   */
  public abstract void startGameWithDeck(List<Cards> deck, int height, int width) throws
          IllegalArgumentException;

  /**
   * gets the width of the board.
   *
   * @return width as int.
   * @throws IllegalStateException if the game hasnt started.
   */
  public int getWidth() throws IllegalStateException {
    if (!hasStarted) {
      throw new IllegalStateException("Game has not started");
    }
    return this.width;
  }

  /**
   * gets the height of the board.
   *
   * @return height as int.
   * @throws IllegalStateException if the game hasnt started.
   */
  public int getHeight() throws IllegalStateException {
    if (!hasStarted) {
      throw new IllegalStateException("Game has not started");
    }
    return this.height;
  }

  /**
   * gets the score of the game.
   *
   * @return score as int.
   * @throws IllegalStateException if the game hasnt started.
   */
  public int getScore() throws IllegalStateException {
    if (!hasStarted) {
      throw new IllegalStateException("Game has not started");
    }
    return score;
  }

  /**
   * checks the game board if there are any sets present on the current grid.
   *
   * @return boolean value whether there ARE sets on the board.
   */
  public abstract boolean anySetsPresent();

  /**
   * Checks to see if the given coordinates forms a valid set.
   *
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   * @return boolean, true or false if there is a valid set or not.
   * @throws IllegalArgumentException if the coordinates are invalid.
   */
  public boolean isValidSet(Coord coord1, Coord coord2, Coord coord3)
          throws IllegalArgumentException {
    if (!hasStarted) {
      throw new IllegalStateException("Game has not started");
    }
    coordinateCheck(coord1, coord2, coord3);
    Boolean valid = false;
    char[] card_one = new char[3];
    char[] card_two = new char[3];
    char[] card_three = new char[3];

    for (int i = 0; i < 3; i++) {
      card_one[i] = getCardAtCoord(coord1).toString().charAt(i);
      card_two[i] = getCardAtCoord(coord2).toString().charAt(i);
      card_three[i] = getCardAtCoord(coord3).toString().charAt(i);
    }

    if ((isCountValid(card_one, card_two, card_three)) &&
            (isFillingValid(card_one, card_two, card_three)) &&
            (isShapeValid(card_one, card_two, card_three))) {

      valid = true;
    }
    return valid;

  }

  /**
   * checks the coordinates to make sure they are valid arguments.
   *
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   * @return boolean, true or false if the coords are valid or not.
   * @throws IllegalArgumentException if the coordinates are invalid.
   */
  protected boolean coordinateCheck(Coord coord1, Coord coord2, Coord coord3)
          throws IllegalArgumentException {
    if ((coord1.row >= this.row) || coord1.row < 0) {
      throw new IllegalArgumentException("coordinate is out of grid");
    } else if ((coord1.col >= this.col) || coord1.col < 0) {
      throw new IllegalArgumentException("coordinate is out of grid");
    } else if (coord2.row >= this.row || coord2.row < 0) {
      throw new IllegalArgumentException("coordinate is out of grid");
    } else if ((coord3.col >= this.col) || coord3.col < 0) {
      throw new IllegalArgumentException("coordinate is out of grid");
    } else if (coord3.row >= this.row || coord3.row < 0) {
      throw new IllegalArgumentException("coordinate is out of grid");
    } else {
      return true;
    }
  }

  /**
   * checks to see if the Count attribute is the same between cards.
   *
   * @param c1 coordinate one.
   * @param c2 coordinate two.
   * @param c3 coordinate three.
   * @return if the coordinates are valid for that Count attribute.
   */
  protected boolean isCountValid(char[] c1, char[] c2, char[] c3) {
    if ((c1[0] == (c2[0])) && (c2[0] == c3[0])) {
      return true;
    } else if ((c1[0] != (c2[0])) && (c2[0] != c3[0]) &&
            (c1[0] != c3[0])) {
      return true;
    }
    return false;
  }

  /**
   * checks to see if the filling attribute is the same between cards.
   *
   * @param c1 coordinate one.
   * @param c2 coordinate two.
   * @param c3 coordinate three.
   * @return if the coordinates are valid for that filling attribute.
   */
  protected boolean isFillingValid(char[] c1, char[] c2, char[] c3) {
    if ((c1[1] == (c2[1])) && (c2[1] == c3[1])) {
      return true;
    } else {
      return ((c1[1] != (c2[1])) && (c2[1] != c3[1]) &&
              (c1[1] != c3[1]));
    }
  }

  /**
   * checks to see if the shape attribute is the same between cards.
   *
   * @param c1 coordinate one.
   * @param c2 coordinate two.
   * @param c3 coordinate three.
   * @return if the coordinates are valid for that shape attribute.
   */
  protected boolean isShapeValid(char[] c1, char[] c2, char[] c3) {
    if ((c1[2] == (c2[2])) && (c2[2] == c3[2])) {
      return true;
    } else {
      return ((c1[2] != (c2[2])) && (c2[2] != c3[2]) &&
              (c1[2] != c3[2]));
    }
  }


  /**
   * gets the card based on the row and column coordinate.
   *
   * @param row the row of the desired card
   * @param col the column of the desired card
   * @return the card of the coordinate desired.
   */
  public Cards getCardAtCoord(int row, int col) {
    return board[row][col];
  }

  /**
   * gets the card based on the coordinate location.
   *
   * @param coord the coordinates of the desired card
   * @return the card of the coordinate location.
   */
  public Cards getCardAtCoord(Coord coord) {
    int row = coord.row;
    int col = coord.col;

    return board[row][col];
  }

  /**
   * checks to see if the game is over at any point in time.
   *
   * @return boolean: true or false depending if the game is over.
   */
  public abstract boolean isGameOver();

  /**
   * gets the complete deck with all combinations of cards.
   *
   * @return the list of cards.
   */
  public List<Cards> getCompleteDeck() {
    List<Cards> l1 = new ArrayList<>();
    Filling.values();
    for (Filling filling : Filling.values()) {
      for (Count count : Count.values()) {
        for (Shape shape : Shape.values()) {
          l1.add(new Cards(count, filling, shape));

        }
      }
    }
    return l1;

  }
}
