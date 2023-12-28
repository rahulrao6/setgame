package cs3500.v2.src;

import java.util.List;

/**
 * This is the model interface for any version of the Game Set. This interface allows for the
 * game to be played: Starting a game of Set, Making moves, mutating grid, checking for sets in
 * the game.
 * @param <C> The type of card that is going to be used for the present game.
 */
public interface SetGameModel<C> extends SetGameModelState<C> {

  /**
   * starts a particular game with the given configuration. As configurations can easily be
   * changed through the interface and future class design, able to change the rules of game.
   * @param gameConfiguration the game configuration for the new game.
   */
  void startGame(gameConfig<C> gameConfiguration);

  /**
   * claims a particular set on the board based on the given coordinates. This method can take
   * in a flexible amount of cards and based on the gameConfiguration that was used when the
   * game was started, this method will work accordingly.
   * @param coords list of coordinates that should be checked(can be of flexible size)
   */
  void claimSet(List<Coord> coords);

  /**
   * gets the current state of the game from the SetGameModelState interface.
   * @return the current state of the game.
   */
  SetGameModelState<C> getCurrentState();

}
