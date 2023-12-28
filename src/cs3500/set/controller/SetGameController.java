package cs3500.set.controller;

/**
 * Represents the controller of the game.
 */
public interface SetGameController {

  /**
   * plays the game.
   *
   * @throws IllegalStateException if controller is unable to read input or transmit output.
   */
  void playGame() throws IllegalStateException;

}
