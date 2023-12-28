package cs3500.v2.src;

/**
 * Represents the state of the game of set that is currently in progress.
 * @param <C> the type of card used in a particular game.
 */
public interface SetGameModelState<C> extends Card{
  /**
   * gets the width of the game board.
   * @return width of the board.
   */
  int getWidth();
  /**
   * gets the height of the game board.
   * @return height of the board.
   */
  int getHeight();
  /**
   * gets the score of the game.
   * @return score of the game.
   */
  int getScore();

  /**
   * checks if there any sets present in the game board.
   * @return true if there is atleast one set otherwise false.
   */
  boolean anySetsPresent();

  /**
   * returns a card at a particular row and column location.
   * @param row row coordinate of the card on the game board.
   * @param col col coordinate of the card on the game board.
   * @return the card at the specific coordinate.
   * @throws IllegalArgumentException if coordinate is out of location.
   */
  C getCardAtCoord(int row, int col) throws IllegalArgumentException;


  /**
   * returns a card at a particular row and column location.
   * @param coord coordinate of card.
   * @return card at the specific coordinate.
   * @throws IllegalArgumentException if cards are not valid.
   */
  C getCardAtCoord(Coord coord) throws IllegalArgumentException;

  /**
   * checks if the game is over.
   * @return true if the game is over otherwise false.
   */
  boolean isGameOver();
}
