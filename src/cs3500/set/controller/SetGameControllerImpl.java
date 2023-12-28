package cs3500.set.controller;

import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.view.SetGameTextView;
import cs3500.set.view.SetGameView;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Represents the controller of the Set Game.
 */
public class SetGameControllerImpl implements SetGameController {

  SetGameModel model;
  SetGameView view;
  Readable in;

  Appendable out = new StringBuilder();

  private boolean containsInputs = true;

  private String[] userInputs = new String[6];

  private String str;
  private boolean quit;


  /**
   * Main method used for testing.
   *
   * @param args argument for main.
   */
  public static void main(String[] args) {
    Appendable v = System.out;
    String s = "";

    SetGameModel model = new SetThreeGameModel();
    SetGameTextView view = new SetGameTextView(model, v);
    SetGameController controller = new SetGameControllerImpl(model,
            view, new InputStreamReader(System.in));


    controller.playGame();
  }

  /**
   * Represents the constructor for the controller.
   *
   * @param model all game operations.
   * @param view  shows view of game.
   * @param in    readable input.
   */
  public SetGameControllerImpl(SetGameModel model, SetGameView view, Readable in) {

    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Null Values");
    }
    this.model = model;
    this.view = view;
    this.in = in;


  }

  /**
   * plays the game.
   *
   * @throws IllegalStateException if invalid view.
   */
  @Override
  public void playGame() throws IllegalStateException {
    try {
      Scanner scanner = new Scanner(in);
      quit = false;
      int height;
      int width;
      // String s;
      view.renderMessage("Enter Height\n");
      str = scanner.next();
      if (str == null) {
        throw new IllegalStateException("Null Value for Height");
      }
      if (str.equals("q") || str.equals("Q")) {
        quit = true;
        view.renderMessage("Game quit!\n");
        view.renderMessage("Score: 0");
        return;
      }

      while (Integer.parseInt(str) < 0) {
        view.renderMessage("Invalid height/width. Try again.\n");
        str = scanner.next();
      }
      height = Integer.parseInt(str);
      view.renderMessage("Enter Width\n");
      str = scanner.next();
      if (str == null) {
        throw new IllegalStateException("Null Value for Width");
      }
      if (str.equals("q") || str.equals("Q")) {
        quit = true;
        view.renderMessage("Game quit!\n");
        view.renderMessage("Score: 0");
        return;
      }

      while (Integer.parseInt(str) < 0) {
        view.renderMessage("Invalid height/width. Try again.\n");
        str = scanner.next();
      }
      width = Integer.parseInt(str);
      try {
        model.startGameWithDeck(model.getCompleteDeck(), height, width);
      } catch (Exception e) {
        throw new IllegalArgumentException("illegal");
      }

      while (!model.isGameOver()) {
        view.renderGrid();
        view.renderMessage("\nScore: " + model.getScore());
        view.renderMessage("\n");

        //get row and column
        playGameHelper(scanner);

        if (quit) {
          break;
        }

        if (!containsInputs) {
          throw new IllegalStateException("Not enough inputs");
        }
        this.checkInputs(this.userInputs);


      }

      if (model.isGameOver()) {
        view.renderMessage("Game over!\n");
        view.renderMessage("Score: " + model.getScore());
      }


    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  private void playGameHelper(Scanner scanner) {
    try {
      this.containsInputs = true;
      for (int x = 0; x < userInputs.length; ++x) {
        if (!scanner.hasNext()) {
          this.containsInputs = false;
        }
        if (this.in == null) {
          throw new IllegalStateException("Null Value provided");
        }
        for (this.str = scanner.next(); !this.isValidInput(str); this.str = scanner.next()) {
          this.view.renderMessage("Invalid Input. Please Try again\n");
        }
        this.userInputs[x] = this.str;

        if (this.userInputs[x].equals("q") || this.userInputs[x].equals("Q")) {
          if (model.isGameOver()) {
            view.renderMessage("Game over!\n");
            view.renderMessage("Score: " + model.getScore());
            return;
          }
          quit = true;
          view.renderMessage("Game quit!\n");
          view.renderMessage("State of game when quit:\n");
          view.renderGrid();
          view.renderMessage("\nScore: " + model.getScore());
          break;
        }

      }

    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  private boolean isValidInput(String input) {
    if (input.equals("q") || input.equals("Q")) {
      return true;
    }
    return (Integer.parseInt(input) > 0);

  }

  private void checkInputs(String[] userInputs) throws IllegalStateException {
    try {
      int r1 = Integer.parseInt(userInputs[0]) - 1;
      int c1 = Integer.parseInt(userInputs[1]) - 1;
      int r2 = Integer.parseInt(userInputs[2]) - 1;
      int c2 = Integer.parseInt(userInputs[3]) - 1;
      int r3 = Integer.parseInt(userInputs[4]) - 1;
      int c3 = Integer.parseInt(userInputs[5]) - 1;

      this.model.claimSet(new Coord(r1, c1), new Coord(r2, c2), new Coord(r3, c3));

    } catch (Exception e) {
      // do nothing
    }
  }
}
