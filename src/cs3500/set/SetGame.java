package cs3500.set;


import java.io.InputStreamReader;

import cs3500.set.controller.SetGameController;
import cs3500.set.controller.SetGameControllerImpl;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw03.GeneralSetGameModel;
import cs3500.set.view.SetGameTextView;

/**
 * class to run the main method and program using command line arguments.
 */
public final class SetGame {
  /**
   * main method that can run program and contains one of two arguments.
   *
   * @param args which will contain one of the run configurations, general or three.
   */
  public static void main(String[] args) {
    SetGameModel model;
    System.out.println(args[0]);
    if (args[0].equalsIgnoreCase("general")) {
      model = new GeneralSetGameModel();
    } else if (args[0].equalsIgnoreCase("three")) {
      model = new SetThreeGameModel();
    } else {
      System.out.println("Invalid input: Please enter 'general' or 'three'");
      return;
    }
    Appendable v = System.out;
    SetGameTextView view = new SetGameTextView(model, v);
    SetGameController controller = new SetGameControllerImpl(model,
            view, new InputStreamReader(System.in));


    controller.playGame();
  }
}
