package cs3500.set.controller;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.view.SetGameTextView;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * tests the controller class.
 */
public class SetGameControllerImplTest {


  /**
   * mock for controller.
   */
  class ControllerMock implements SetGameController {
    private final Appendable log;

    ControllerMock(Appendable log) {
      this.log = log;
    }


    @Override
    public void playGame() throws IllegalStateException {
      try {
        log.append("Game began");
      } catch (IOException e) {
        //do nothing
      }
      assertEquals("Game began", log);


    }
  }


  SetThreeGameModel game = new SetThreeGameModel();
  Readable read = new StringReader("");
  StringBuilder out = new StringBuilder();
  SetGameTextView view = new SetGameTextView(game, out);

  SetGameController controller = new SetGameControllerImpl(game, view, read);
  Readable r;
  Appendable a;


  protected String s = "    O O O    \n" +
          "    O O O    \n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O    \n"
          + "    O O O    ";


  @Test
  public void testGame() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 1 1 1 1");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testGameInvalid() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("33");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testGameImmediateQuit() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("q");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      controller.playGame();
    } catch (IllegalStateException e) {
      //assertTrue(true);
    }
    //check a quit imemdiately and see what happens
    assertEquals("Enter Height\n" +
            "Game quit!\n" +
            "Score: 0", a.toString());

  }


  @Test
  public void testGame2() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 q");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      //test to see if plays with two inputs & quit
      controller.playGame();
      //check grid
      assertEquals("1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED", view.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameInvalid3() {
    game = new SetThreeGameModel();
    a = null;
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 q");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      //test to see if plays with two inputs & quit
      controller.playGame();
      //check grid
      assertEquals("1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED", view.toString());
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameInvalid4() {
    game = null;
    a = null;
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 q");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      //test to see if plays with two inputs & quit
      controller.playGame();
      //check grid
      assertEquals("1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED", view.toString());
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameInvalid5() {
    game = null;
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 q");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      //test to see if plays with two inputs & quit
      controller.playGame();
      //check grid
      assertEquals("1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED", view.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameInvalid6() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = null;
    read = new StringReader("3 3 q");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      //test to see if plays with two inputs & quit
      controller.playGame();
      //check grid
      assertEquals("1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED", view.toString());
    } catch (IllegalStateException e) {
      //do nothing
    }
  }


  @Test
  public void testGame3() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 q");
    controller = new SetGameControllerImpl(game, view, read);
    try {
      controller.playGame();
      // test to see if appendable output is correct if quit.
      assertEquals("Enter Height\n" +
              "Enter Width\n" +
              "1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED\n" +
              "Score: 0\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED\n" +
              "Score: 0", a.toString());
    } catch (IllegalStateException e) {
      //do nothing
    }
    //test if height is 3
    assertEquals(3, game.getHeight());
    // test if width is 3
    assertEquals(3, game.getWidth());
  }

  @Test
  public void testGame4() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 1 1 1 1 1");
    try {
      controller = new SetGameControllerImpl(game, view, read);
      game.startGameWithDeck(game.getCompleteDeck(), 3, 3);
      System.out.print((game.getScore()));
      controller.playGame();
    } catch (IllegalStateException e) {
      //ignore

    }
    assertEquals(3, game.getHeight());
    assertEquals(0, game.getScore());
  }

  @Test
  public void testGame6() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 1 1 1 1 1 1");
    try {
      controller = new SetGameControllerImpl(game, view, read);
      game.startGameWithDeck(game.getCompleteDeck(), 3, 3);
      System.out.print((game.getScore()));
      controller.playGame();
    } catch (IllegalStateException e) {
      //ignore

    }
    assertEquals(3, game.getHeight());
    //score becomes one with one correct claim set
    assertEquals(1, game.getScore());
  }


  @Test
  public void testGame5() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 1 1 1 1 1");
    try {
      controller = new SetGameControllerImpl(game, view, read);
      game.startGameWithDeck(game.getCompleteDeck(), 3, 3);
      System.out.print((game.getScore()));
      controller.playGame();
    } catch (IllegalStateException e) {
      //ignore

    }
    assertEquals(3, game.getHeight());

  }

  //full game
  @Test
  public void testGame7() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1" +
            "1 1 1 1 1 1 1 1 1 1 1 1");
    try {
      controller = new SetGameControllerImpl(game, view, read);
      game.startGameWithDeck(game.getCompleteDeck(), 3, 3);
      System.out.print((game.getScore()));
      controller.playGame();
    } catch (IllegalStateException e) {
      //ignore

    }
    assertEquals(7, game.getScore());
    // check gameboard
    assertEquals("3FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED", view.toString());

    //check to see if each input and score is as required
    // also check to see if end of game is stated properly.
    assertEquals("Enter Height\n" +
            "Enter Width\n" +
            "1EO 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 0\n" +
            "1SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 1\n" +
            "2SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 2\n" +
            "3SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 3\n" +
            "1FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 4\n" +
            "2FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 5\n" +
            "Invalid Input. Please Try again\n" +
            "3FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 6\n" +
            "Game over!\n" +
            "Score: 7", a.toString());
    //check if game is over (7 score is highest)
    assertEquals(true, game.isGameOver());
  }

  @Test
  public void testGame8() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1" +
            "1 1 1 1 1 1 1 1 1 1 1 q");
    try {
      controller = new SetGameControllerImpl(game, view, read);
      game.startGameWithDeck(game.getCompleteDeck(), 3, 3);
      System.out.print((game.getScore()));
      controller.playGame();
    } catch (IllegalStateException e) {
      //ignore

    }
    assertEquals(6, game.getScore());
    assertEquals("3FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED", view.toString());
    assertEquals("Enter Height\n" +
            "Enter Width\n" +
            "1EO 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 0\n" +
            "1SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 1\n" +
            "2SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 2\n" +
            "3SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 3\n" +
            "1FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 4\n" +
            "2FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 5\n" +
            "Invalid Input. Please Try again\n" +
            "3FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 6\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "3FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 6", a.toString());


    assertEquals(false, game.isGameOver());
  }

  @Test
  public void testGame9() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    //
    read = new StringReader("3 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1x1 1 1 1 1 1 1 1 1 1 1 1 1" +
            "1 1 1 1 1 1 1 1 1 1 1 q");
    try {
      controller = new SetGameControllerImpl(game, view, read);
      game.startGameWithDeck(game.getCompleteDeck(), 3, 3);
      System.out.print((game.getScore()));
      controller.playGame();
    } catch (IllegalStateException e) {
      //ignore

    }
    assertEquals(5, game.getScore());
    assertEquals("2FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED", view.toString());
    //check to see if game handles the invalid values put in
    assertEquals("Enter Height\n" +
            "Enter Width\n" +
            "1EO 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 0\n" +
            "1SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 1\n" +
            "2SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 2\n" +
            "Invalid Input. Please Try again\n" +
            "3SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 3\n" +
            "1FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 4\n" +
            "Invalid Input. Please Try again\n" +
            "2FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 5\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "2FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 5", a.toString());


    assertEquals(false, game.isGameOver());
  }

  @Test
  public void testGame10() {
    game = new SetThreeGameModel();
    a = new StringBuilder();
    view = new SetGameTextView(game, a);
    read = new StringReader("3 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1" +
            "1 1 1 1 1 1 1 1 1 1 1 1 q");
    try {
      controller = new SetGameControllerImpl(game, view, read);
      game.startGameWithDeck(game.getCompleteDeck(), 3, 3);
      System.out.print((game.getScore()));
      controller.playGame();
    } catch (IllegalStateException e) {
      //ignore

    }
    assertEquals(7, game.getScore());
    //check gameboard
    assertEquals("3FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED", view.toString());

    //check to see if each input and score is as required
    // also check to see if end of game is stated properly.
    assertEquals("Enter Height\n" +
            "Enter Width\n" +
            "1EO 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 0\n" +
            "1SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 1\n" +
            "2SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 2\n" +
            "3SD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 3\n" +
            "1FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 4\n" +
            "2FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 5\n" +
            "Invalid Input. Please Try again\n" +
            "3FD 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED\n" +
            "Score: 6\n" +
            "Game over!\n" +
            "Score: 7", a.toString());
    //check if game is over (7 score is highest)
    assertEquals(true, game.isGameOver());
  }


}
