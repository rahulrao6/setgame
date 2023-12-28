package cs3500.set.model.hw03;

import java.util.List;

import cs3500.set.model.AbstractSet;
import cs3500.set.model.hw02.Cards;
import cs3500.set.model.hw02.Coord;

/**
 * Class that represents the general game, it can have any size of board and should claim sets
 * of three. The game will end when: there are no sets on the board, the card deck doesnt have
 * enough cards, or the deck/some value is null.
 */
public class GeneralSetGameModel extends AbstractSet {

  /**
   * represents the constructor for the general set game model. Sets the deck to a arraylist.
   */
  public GeneralSetGameModel() {
    super();
  }


  /**
   * claims the set when given three coordinates.
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
        if (cardList.size() >= 3 && !anySetsPresent()) {
          this.height++;
          for (row = row - 1; row < this.board.length; row++) {
            for (col = 0; col < this.board.length; col++) {
              Coord c = new Coord(this.row, this.col);
              board[c.row][c.col] = cardList.get(0);
              cardList.remove(0);
            }
          }
        }
        //   else if (cardList.size() < 3 && !anySetsPresent()) {
        //    throw new IllegalStateException("Game is Over");
        //    }

      }

    }
  }

  /**
   * starts the game with the given parameters.
   *
   * @param deck   the list of cards in the order they will be played
   * @param height the height of the board for this game
   * @param width  the width of the board for this game
   * @throws IllegalArgumentException if the arguments are not valid.
   */
  @Override
  public void startGameWithDeck(List<Cards> deck, int height, int width)
          throws IllegalArgumentException {

    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Grid is negative");
    } else if (deck.size() < 3) {
      throw new IllegalArgumentException("Not enough cards to start game");
    } else if (deck == null) {
      throw new IllegalArgumentException("Invalid input.");
    } else if (deck.size() < (height * width)) {
      throw new IllegalArgumentException("Not enough cards to fill given grid");
    } else if ((height * width) < 3) {
      throw new IllegalArgumentException("Game has less than enough cards to claim.");
    }

    this.height = height;
    this.width = width;
    this.hasStarted = true;
    this.cardList = deck;
    this.board = new Cards[height][width];
    //cardList = getCompleteDeck();
    for (row = 0; row < this.height; row++) {
      for (col = 0; col < this.width; col++) {
        Coord c = new Coord(this.row, this.col);
        board[c.row][c.col] = deck.get(0);
        deck.remove(0);
      }
    }
    if ((cardList.size() >= 3) && (!anySetsPresent())) {
      this.height++;
      this.board = new Cards[height][width];
      //cardList = getCompleteDeck();
      for (row = 0; row < this.height; row++) {
        for (col = 0; col < this.width; col++) {
          Coord c = new Coord(this.row, this.col);
          board[c.row][c.col] = deck.get(0);
          deck.remove(0);
        }
      }
    }
  }

  /**
   * checks the game board if there are any sets present on the current grid.
   *
   * @return boolean value whether there ARE sets on the board.
   */
  @Override
  public boolean anySetsPresent() {
    if (!hasStarted) {
      throw new IllegalStateException("Game has not started");
    }
    Coord[] coordBoard = new Coord[this.height * this.width];
    int k = 0;
    // create single dimension array to assign to board
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        coordBoard[k] = new Coord(i, j);
        k++;
      }
    }
    if (coordBoard.length == 3) {
      return isValidSet(coordBoard[0], coordBoard[1], coordBoard[2]);
    }

    //checks to see if valid set returns true
    for (int i = 0; i < coordBoard.length; i++) {
      for (int j = i + 1; j < coordBoard.length; j++) {
        for (int x = j + 1; x < coordBoard.length; x++) {
          if (isValidSet(coordBoard[i], coordBoard[j], coordBoard[x])) {
            return true;
          }

        }
      }
    }
    return false;
  }

  /**
   * checks to see if the game is over at any point in time.
   *
   * @return boolean: true or false depending if the game is over.
   */
  @Override
  public boolean isGameOver() {
    if (cardList == null) {
      this.isOver = true;
    }
    if (cardList.size() < 3 && !anySetsPresent()) {
      this.isOver = true;
    }

    return this.isOver;
  }
}
