package cs3500.set.controller;


import java.io.IOException;

/**
 * Controller mock.
 */
public class ControllerMock implements SetGameController {


  @Override
  public void playGame() throws IllegalStateException {
    Appendable v = new StringBuilder();
    try {
      v.append("Game began");
    } catch (IOException e) {
      //do nothing
    }


  }
}
