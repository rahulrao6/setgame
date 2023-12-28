package cs3500.set.model.hw03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs3500.set.model.hw02.Cards;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.Count;
import cs3500.set.model.hw02.Filling;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.Shape;
import cs3500.set.view.SetGameTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * First test class of SetThreeGame.
 */
public class GeneralSetGameModelTest {
  GeneralSetGameModel s = new GeneralSetGameModel();
  List<Cards> deck = s.getCompleteDeck();

  @Test
  public void testGameBoard() {
    try {

      GeneralSetGameModel s = new GeneralSetGameModel();
      s.startGameWithDeck(deck, 4, 3);
      assertEquals(4, s.getHeight());

    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }


  @Test
  public void claimSet() {
    try {

      Coord c1 = new Coord(0, 0);
      Coord c2 = new Coord(0, 1);
      Coord c3 = new Coord(0, 2);

      GeneralSetGameModel s = new GeneralSetGameModel();
      List<Cards> deck = s.getCompleteDeck();
      s.startGameWithDeck(deck, 4, 4);
      assertTrue(s.isValidSet(c1, c2, c3));
      s.claimSet(c1, c2, c3);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test
  public void claimSet2() {

    try {
      Appendable a = new StringBuilder("");
      Coord c1 = new Coord(0, 0);
      Coord c2 = new Coord(0, 1);
      Coord c3 = new Coord(0, 2);

      SetGameModel s = new GeneralSetGameModel();
      SetGameTextView view = new SetGameTextView(s, a);
      List<Cards> deck = s.getCompleteDeck();
      s.startGameWithDeck(deck, 5, 3);
      assertEquals("1EO 1EQ 1ED\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED\n" +
              "1SO 1SQ 1SD\n" +
              "2SO 2SQ 2SD", view.toString());
      assertTrue(s.isValidSet(c1, c2, c3));
      assertEquals(false, s.isGameOver());
      assertEquals(true, s.anySetsPresent());
      s.claimSet(c1, c2, c3);
      assertEquals("3SO 3SQ 3SD\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED\n" +
              "1SO 1SQ 1SD\n" +
              "2SO 2SQ 2SD", view.toString());
      assertEquals(1, s.getScore());
      s.claimSet(c1, c2, c3);
      assertEquals("1FO 1FQ 1FD\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED\n" +
              "1SO 1SQ 1SD\n" +
              "2SO 2SQ 2SD", view.toString());
      assertEquals(false, s.isGameOver());
      assertEquals(true, s.anySetsPresent());
      assertEquals(2, s.getScore());
      s.claimSet(c1, c2, c3);
      assertEquals(false, s.isGameOver());
      assertEquals(true, s.anySetsPresent());
      assertEquals(3, s.getScore());
      s.claimSet(c1, c2, c3);
      assertEquals("3FO 3FQ 3FD\n" +
              "2EO 2EQ 2ED\n" +
              "3EO 3EQ 3ED\n" +
              "1SO 1SQ 1SD\n" +
              "2SO 2SQ 2SD", view.toString());
      assertEquals(false, s.isGameOver());
      assertEquals(true, s.anySetsPresent());
      assertEquals(4, s.getScore());
      s.claimSet(c1, c2, c3);
      assertEquals("", a.toString());
      //check board and find last claim set
      // claim the set
      assertEquals(true, s.isGameOver());
      assertEquals(true, s.anySetsPresent());
      assertEquals(5, s.getScore());


    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test
  public void startGameWithDeck() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      List<Cards> deck = s.getCompleteDeck();
      s.startGameWithDeck(deck, 3, 3);
      // after first set of cards are removed fromt the deck, the next coordinate.
      assertEquals("1SO", deck.get(0).toString());
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test
  public void getWidth() {
    SetGameModel s = new GeneralSetGameModel();
    s.startGameWithDeck(deck, 3, 7);
    int width = s.getWidth();
    assertEquals(7, width);
  }

  @Test
  public void getHeight2() {
    SetGameModel s = new GeneralSetGameModel();
    s.startGameWithDeck(deck, 4, 3);
    int height = s.getHeight();
    assertEquals(4, height);
  }

  @Test
  public void getHeight() {
    try {
      List<Cards> l1 = new ArrayList<>();

      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.DIAMOND));
      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.DIAMOND));
      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.SQUIGGLE));

      l1.add(new Cards(Count.TWO, Filling.STRIPED, Shape.OVAL));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.OVAL));

      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.DIAMOND));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));


      GeneralSetGameModel s = new GeneralSetGameModel();
      Appendable a = new StringBuilder("");
      SetGameTextView view = new SetGameTextView(s, a);
      s.startGameWithDeck(l1, 1, 3);
      assertEquals(false, s.anySetsPresent());
      // s.claimSet(new Coord(0,0),new Coord(0,2),new Coord(1,0));
      System.out.print(view.toString());
    } catch (IndexOutOfBoundsException e) {
      //ignore
    }

  }


  @Test
  public void anySetsPresent() {
    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = s.getCompleteDeck();
    try {
      s.startGameWithDeck(deck, 3, 3);
      s.anySetsPresent();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid");
    }
    assertTrue(s.anySetsPresent());
  }

  @Test(expected = IllegalArgumentException.class)
  public void anySetsPresentNone() {
    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = null;
    try {
      s.startGameWithDeck(deck, 3, 3);
      s.anySetsPresent();
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid");
    }
    assertTrue(s.anySetsPresent());
  }

  @Test
  public void anySetsPresent3() {
    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);
    assertTrue(s.anySetsPresent());

    // assertEquals(true, s.anySetsPresent());
  }


  @Test(expected = IllegalArgumentException.class)
  public void anySetsNotPresent() {
    SetGameModel s = new GeneralSetGameModel();
    List<Cards> l1 = new ArrayList<>();
    l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.OVAL));
    l1.add(new Cards(Count.THREE, Filling.EMPTY, Shape.OVAL));

    s.startGameWithDeck(l1, 3, 3);
    assertTrue(s.anySetsPresent());
  }


  @Test
  public void isValidSet() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(0, 2);

    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);

    assertTrue(s.isValidSet(c1, c2, c3));
  }

  @Test
  public void isNotValidSet() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(2, 1);
    Coord c3 = new Coord(0, 2);


    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);

    assertFalse(s.isValidSet(c1, c2, c3));

  }

  @Test(expected = IllegalArgumentException.class)
  public void isNotValidSet2() {
    Coord c1 = new Coord(4, 0);
    Coord c2 = new Coord(2, 1);
    Coord c3 = new Coord(0, 2);


    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);

    assertFalse(s.isValidSet(c1, c2, c3));

  }

  @Test
  public void getCardAtCoord() {
    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);
    assertEquals("1EO", s.getCardAtCoord(0, 0).toString());

  }

  @Test
  public void testGetCardAtCoord() {
    SetGameModel s = new GeneralSetGameModel();
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);
    assertEquals("1EO", s.getCardAtCoord(new Coord(0, 0)).toString());

  }


  @Test
  public void isGameOver() {
    SetGameModel s = new GeneralSetGameModel();
    // view
    SetGameTextView v = new SetGameTextView(s);
    List<Cards> l1 = new ArrayList<>();
    l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.OVAL));
    l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.SQUIGGLE));
    l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.DIAMOND));

    l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.OVAL));
    l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.SQUIGGLE));
    l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.DIAMOND));

    l1.add(new Cards(Count.THREE, Filling.EMPTY, Shape.OVAL));
    l1.add(new Cards(Count.THREE, Filling.EMPTY, Shape.SQUIGGLE));
    l1.add(new Cards(Count.THREE, Filling.EMPTY, Shape.DIAMOND));

    // adding with all empty striped
    l1.add(new Cards(Count.ONE, Filling.STRIPED, Shape.OVAL));
    l1.add(new Cards(Count.ONE, Filling.STRIPED, Shape.SQUIGGLE));
    l1.add(new Cards(Count.ONE, Filling.STRIPED, Shape.DIAMOND));
    s.startGameWithDeck(l1, 3, 3);

    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(1, 0);
    Coord c3 = new Coord(2, 0);
    System.out.println(v);
    assertFalse(s.isGameOver());
    s.claimSet(c1, c2, c3);
    assertFalse(s.isGameOver());
    System.out.print(v.toString());
    Coord c4 = new Coord(0, 0);
    Coord c5 = new Coord(1, 0);
    Coord c6 = new Coord(2, 0);
    s.claimSet(c4, c5, c6);
    assertEquals(true, s.isGameOver());
    System.out.print(v.toString());
    Coord c7 = new Coord(0, 1);
    Coord c8 = new Coord(1, 1);
    Coord c9 = new Coord(2, 1);
    s.claimSet(c7, c8, c9);
    assertEquals(true, s.isGameOver());
    System.out.println(l1.size());


  }


  @Test
  public void practiceGame() {

    SetGameModel s = new GeneralSetGameModel();
    // view
    SetGameTextView v = new SetGameTextView(s);
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 4, 3);
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(1, 0);
    Coord c3 = new Coord(2, 0);
    System.out.println(v);
    s.claimSet(c1, c2, c3);
    assertEquals(1, s.getScore());
    System.out.println(v);
    Coord c4 = new Coord(0, 0);
    Coord c5 = new Coord(1, 0);
    Coord c6 = new Coord(2, 0);
    assertTrue(s.anySetsPresent());
    //code is failing after running setClaim more than once
    s.claimSet(c4, c5, c6);
    System.out.println(v.toString());
    Coord c7 = new Coord(3, 0);
    Coord c8 = new Coord(1, 0);
    Coord c9 = new Coord(2, 0);
    Coord c10 = new Coord(0, 0);
    try {
      s.claimSet(c7, c8, c9);
    } catch (Exception e) {
      //ignore
    }
    s.claimSet(c10, c8, c9);
    System.out.print(s.getScore());
    assertEquals(3, s.getScore());


  }


}