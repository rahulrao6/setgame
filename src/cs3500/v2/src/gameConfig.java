package cs3500.v2.src;

import java.util.List;

/**
 * Represents a configuration for a particular game of set. Each configuration has to specify
 * the deck of cards to use, the dimensions of the gane, the number or cards to make a set,
 * and the criteria for set validity and ending the game. This allow for more flexibility
 * in the type of game and cards you want to have.
 * @param <C> type of card to be used.
 */
public interface gameConfig<C> extends Card{
  /**
   * generates a deck of cards for this game to use that is particular to this configuration.
   * @return a deck of cards that can be used in this game.
   */
  List<C> generateDeck();

  /**
   * gets the height of the gameboard.
   * @return height of game board.
   */
  int getGridHeight();
  /**
   * gets the width of the gameboard.
   * @return width of game board.
   */
  int getGridWidth();

  /**
   * checks and sees if the game is over based on the specific criteria of this config.
   * @param deckRemaining whatever cards are remaining in a deck in a specific list.
   * @param gameBoard the entire gameBoard in a list of list.
   * @return whether or not the game is over.
   */
  boolean isGameOver(List<C> deckRemaining, List<List<C>> gameBoard);

  /**
   * deetermines whether a set is valid or not based on the criteria.
   * @param selectedCards Uses a list to get the selected cards for the claiming of a set.
   * @return whether the set that was selected is valid based on the config.
   */
  boolean isValidSet(List<C> selectedCards);

}
