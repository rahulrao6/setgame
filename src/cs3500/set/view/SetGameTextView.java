package cs3500.set.view;


import java.io.IOException;

import cs3500.set.model.hw02.SetGameModelState;

/**
 * Represents the view of the gameboard of the SetThreeGame.
 */
public class SetGameTextView implements SetGameView {
  SetGameModelState state;
  Appendable view;

  /**
   * constructor for the view method.
   *
   * @param s type ModelState for view purposes
   */
  public SetGameTextView(SetGameModelState s, Appendable view) {
    if (s == null || view == null) {
      throw new IllegalArgumentException("Null value given");
    }
    this.state = s;
    this.view = view;
  }

  /**
   * Represents the constructor for only modelstate.
   *
   * @param s state of the model for view.
   */
  public SetGameTextView(SetGameModelState s) {
    if (s == null) {
      throw new IllegalArgumentException("Null value given");
    }
    this.state = s;
  }

  /**
   * returns toString version of cards.
   *
   * @return String of cards.
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    //Cards boardView[][] = new Cards[3][3];
    for (int i = 0; i < state.getHeight(); i++) {
      for (int j = 0; j < state.getWidth(); j++) {
        str.append(state.getCardAtCoord(i, j).toString());
        if (j < state.getWidth() - 1) {
          str.append(" ");
        }
      }
      if (i < state.getHeight() - 1) {
        str.append("\n");
      }

    }
    return str.toString();
  }

  @Override
  public void renderGrid() throws IOException {
    view.append(toString());


  }

  @Override
  public void renderMessage(String message) throws IOException {
    view.append(message);


  }

}
