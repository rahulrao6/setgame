package cs3500.set.model.hw02;

import java.util.List;

import cs3500.set.model.AbstractSet;


/**
 * represents the game: 3 Set Game Variation. This class contains the model for the set Three
 * implementation. It only allows for games with a 3 by 3 grid and no other grid sizes.
 */
public class SetThreeGameModel extends AbstractSet {
  /**
   * represents the constructor for the setthree model, and also intializes
   * the cards to a board of 3 by 3.
   */
  public SetThreeGameModel() {
    super();
    this.board = new Cards[3][3];

  }

  /**
   * attempts to claim the cards if card makes a Set.
   *
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   */
  @Override
  public void claimSet(Coord coord1, Coord coord2, Coord coord3) {
    if (!hasStarted) {
      throw new IllegalStateException("Game has not started");
    }
    if (!coordinateCheck(coord1, coord2, coord3)) {
      throw new IllegalArgumentException("Not valid coordinates");
    }
    if (!isValidSet(coord1, coord2, coord3)) {
      throw new IllegalArgumentException("Not valid Set");
    }

    if (isValidSet(coord1, coord2, coord3)) {
      this.score++;
      if (!isGameOver()) {
        if (cardList.size() < 3) {
          this.isOver = true;
        } else {
          this.board[coord1.row][coord1.col] = cardList.get(0);
          cardList.remove(0);
          this.board[coord2.row][coord2.col] = cardList.get(0);
          cardList.remove(0);
          this.board[coord3.row][coord3.col] = cardList.get(0);
          cardList.remove(0);
        }
      } else if (isGameOver()) {
        throw new IllegalStateException("Game is Over");
      }

    }

  }

  /**
   * starts the game with the given parameters.
   *
   * @param deck   the list of cards in the order they will be played
   * @param height the height of the board for this game
   * @param width  the width of the board for this game
   * @throws IllegalArgumentException if the parameters are invalid.
   */
  @Override
  public void startGameWithDeck(List<Cards> deck, int height, int width)
          throws IllegalArgumentException {
    if (width != 3 || height != 3) {
      throw new IllegalArgumentException("Grid is not 3 high and wide");
    } else if (deck.size() < 9) {
      throw new IllegalArgumentException("Not enough cards to start game");
    } else if (deck == null) {
      throw new IllegalArgumentException("Invalid input.");
    }
    this.height = height;
    this.width = width;

    this.hasStarted = true;
    this.cardList = deck;
    this.board = new Cards[this.width][this.height];
    //cardList = getCompleteDeck();
    for (row = 0; row < this.height; row++) {
      for (col = 0; col < this.width; col++) {
        Coord c = new Coord(this.row, this.col);
        board[c.row][c.col] = deck.get(0);
        deck.remove(0);
      }
    }
    if (!anySetsPresent()) {
      throw new IllegalArgumentException("No Sets present in deck");
    }

  }

  /**
   * check to see if there are any sets present on the board.
   *
   * @return true or false if there are any sets.
   */
  @Override
  public boolean anySetsPresent() {
    if (!hasStarted) {
      throw new IllegalStateException("Game has not started");
    }
    Coord[] coordBoard = new Coord[9];
    int k = 0;
    // create single dimension array to assign to board
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        coordBoard[k] = new Coord(i, j);
        k++;
      }
    }
    //checks to see if valid set returns true
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        for (int x = 0; x < board.length; x++) {
          if (isValidSet(coordBoard[i], coordBoard[j], coordBoard[x])) {
            return true;
          }

        }
      }
    }
    return false;

  }


  /**
   * checks to see if the game is over.
   *
   * @return true or false if the game ends.
   */
  @Override
  public boolean isGameOver() {

    if (cardList == null) {
      this.isOver = true;
    }
    if (!anySetsPresent()) {
      this.isOver = true;
    }

    return this.isOver;
  }


}

