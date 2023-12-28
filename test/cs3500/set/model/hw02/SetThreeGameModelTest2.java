package cs3500.set.model.hw02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs3500.set.model.hw03.GeneralSetGameModel;
import cs3500.set.view.SetGameTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Second testing class for SetThreeGame.
 */
public class SetThreeGameModelTest2 {


  @Test
  public void testGrid() {
    GeneralSetGameModel s = new GeneralSetGameModel();
    // view
    SetGameTextView v = new SetGameTextView(s);
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);
    // 1EO 1EQ 1ED
    // 2EO 2EQ 2ED
    // 3EO 3EQ 3ED
    String expected = "1EO 1EQ 1ED\n2EO 2EQ 2ED" +
            "\n3EO 3EQ 3ED";

    String str = v.toString();
    // check to make sure grid placed cards properly
    assertEquals(expected, str);
    // check to make sure first card is the 0,0 coordinate.
    assertEquals("1EO", s.getCardAtCoord(0, 0).toString());
    // check to see 9th card is 2,2 coordinate
    assertEquals("3ED", s.getCardAtCoord(2, 2).toString());

  }

  @Test
  public void testDeckWithTen() {

    GeneralSetGameModel s = new GeneralSetGameModel();
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
    s.startGameWithDeck(l1, 3, 3);
    assertEquals(false, s.isGameOver());


  }

  @Test(expected = IllegalArgumentException.class)
  public void testDeckWithSix() {
    try {
      GeneralSetGameModel s = new GeneralSetGameModel();
      // view
      SetGameTextView v = new SetGameTextView(s);
      List<Cards> l1 = new ArrayList<>();
      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.OVAL));
      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.SQUIGGLE));
      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.DIAMOND));

      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.OVAL));
      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.SQUIGGLE));
      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.DIAMOND));

      s.startGameWithDeck(l1, 3, 3);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDeckEmpty() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      // view
      SetGameTextView v = new SetGameTextView(s);
      List<Cards> l1 = new ArrayList<>();
      s.startGameWithDeck(l1, 3, 3);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void testDeckNull() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      // view
      SetGameTextView v = new SetGameTextView(s);
      List<Cards> l1 = null;
      s.startGameWithDeck(l1, 3, 3);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test
  public void testConstruct() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      s.startGameWithDeck(s.getCompleteDeck(), 3, 3);
      assertEquals(3, s.getHeight());
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test
  public void getHeight() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      List<Cards> deck = s.getCompleteDeck();
      s.startGameWithDeck(deck, 3, 3);
      int x = s.getHeight();
      assertEquals(3, x);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void getInvalidHeight() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      List<Cards> deck = s.getCompleteDeck();
      int x = s.getHeight();
      assertEquals(3, x);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test
  public void getWidth() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      List<Cards> deck = s.getCompleteDeck();
      s.startGameWithDeck(deck, 3, 3);
      int x = s.getWidth();
      assertEquals(3, x);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void getInvalidWidth() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      List<Cards> deck = s.getCompleteDeck();
      int x = s.getWidth();
      assertEquals(3, x);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  //
  @Test
  public void getScore() {
    SetGameModel s = new GeneralSetGameModel();
    // view
    SetGameTextView v = new SetGameTextView(s);
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);
    assertEquals(0, s.getScore());
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
    System.out.println(v);
    assertEquals(2, s.getScore());
    Coord c7 = new Coord(0, 2);
    Coord c8 = new Coord(1, 2);
    Coord c9 = new Coord(2, 2);
    s.claimSet(c7, c8, c9);
    assertEquals(3, s.getScore());
    // System.out.print(v.toString());
    //assertEquals(2, s.getScore());
    //assertEquals(2,s.getScore());
    // after first set of cards are removed fromt the deck, the next coordinate.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidScore() {
    try {
      SetGameModel s = new GeneralSetGameModel();
      // view
      SetGameTextView v = new SetGameTextView(s);
      List<Cards> deck = s.getCompleteDeck();
      s.getScore();
      s.startGameWithDeck(deck, 3, 3);

    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Test
  public void testIsGameOver() {
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
    s.startGameWithDeck(l1, 3, 3);
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(1, 0);
    Coord c3 = new Coord(2, 0);
    System.out.println(v);
    s.claimSet(c1, c2, c3);
    assertTrue(s.isGameOver());
  }

  @Test
  public void testGameOverEmpty() {
    SetGameModel s = new GeneralSetGameModel();
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


    l1.add(new Cards(Count.TWO, Filling.STRIPED, Shape.OVAL));
    l1.add(new Cards(Count.TWO, Filling.STRIPED, Shape.SQUIGGLE));
    l1.add(new Cards(Count.TWO, Filling.STRIPED, Shape.DIAMOND));

    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(1, 0);
    Coord c3 = new Coord(2, 0);
    s.startGameWithDeck(l1, 3, 3);
    System.out.println(v);
    s.claimSet(c1, c2, c3);
    assertEquals(3, l1.size());
    assertFalse(s.isGameOver());

    // adding with all empty striped


  }

  @Test
  public void testGameOverEmpty2() {
    SetGameModel s = new GeneralSetGameModel();
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


    //l1.add(new Cards(Count.ONE, Filling.STRIPED, Shape.DIAMOND));

    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(1, 0);
    Coord c3 = new Coord(2, 0);
    s.startGameWithDeck(l1, 3, 3);
    System.out.println(v);
    //CHECK
    assertEquals(false, s.isGameOver());
    try {
      s.claimSet(c1, c2, c3);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
    System.out.print(s.getScore());
    assertEquals(0, l1.size());
    assertEquals(true, s.isGameOver());

  }

  /*
0. testIsValidSet - create three coordinates that is a valid set on the board and check
1. testIsValidSet - create three coordinates that are not valid set on the board and
check -> illegal
2. testIsValidSet 3- create three coordinates that is a valid set on the board,
 where the coordinates are invalid values (null) and check
3. testIsValidSet 3- create three coordinates that is a valid set on the board,
where the coordinates are invalid values (out of bounds vaalues) and check
4. testIsValidSet 4- create three coordinates that is a valid set on the board,
where it is not a set -> IllegalArgumentException
5. testIsValidSet - if game started before call -> illeglalStateException
6. testisValidSet -> make all of the coordinates the same value for example (0,0)
and make sure that is is FALSE not true when this happens -> false
*/

  @Test
  public void testIsValidSet() {
    SetGameModel s = new GeneralSetGameModel();
    SetGameTextView v = new SetGameTextView(s);
    List<Cards> l1 = new ArrayList<>();

    l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
    l1.add(new Cards(Count.ONE, Filling.FULL, Shape.SQUIGGLE));
    l1.add(new Cards(Count.ONE, Filling.FULL, Shape.DIAMOND));

    l1.add(new Cards(Count.TWO, Filling.FULL, Shape.OVAL));
    l1.add(new Cards(Count.TWO, Filling.FULL, Shape.SQUIGGLE));
    l1.add(new Cards(Count.TWO, Filling.FULL, Shape.DIAMOND));

    l1.add(new Cards(Count.THREE, Filling.FULL, Shape.OVAL));
    l1.add(new Cards(Count.THREE, Filling.FULL, Shape.SQUIGGLE));
    l1.add(new Cards(Count.THREE, Filling.FULL, Shape.DIAMOND));

    s.startGameWithDeck(l1, 3, 3);
    System.out.println(v.toString());
    assertEquals(true, s.isValidSet(new Coord(0, 2),
            new Coord(1, 2),
            new Coord(2, 2)));
    s.claimSet(new Coord(0, 2),
            new Coord(1, 2),
            new Coord(2, 2));
    assertEquals(1, s.getScore());
  }

  @Test
  public void testIsInValidSet() {
    SetGameModel s = new GeneralSetGameModel();
    SetGameTextView v = new SetGameTextView(s);
    List<Cards> l1 = new ArrayList<>();

    l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
    l1.add(new Cards(Count.ONE, Filling.FULL, Shape.SQUIGGLE));
    l1.add(new Cards(Count.ONE, Filling.FULL, Shape.DIAMOND));

    l1.add(new Cards(Count.TWO, Filling.FULL, Shape.OVAL));
    l1.add(new Cards(Count.TWO, Filling.FULL, Shape.SQUIGGLE));
    l1.add(new Cards(Count.TWO, Filling.FULL, Shape.DIAMOND));

    l1.add(new Cards(Count.THREE, Filling.FULL, Shape.OVAL));
    l1.add(new Cards(Count.THREE, Filling.FULL, Shape.SQUIGGLE));
    l1.add(new Cards(Count.THREE, Filling.FULL, Shape.DIAMOND));

    s.startGameWithDeck(l1, 3, 3);
    System.out.println(v.toString());
    assertEquals(false, s.isValidSet(new Coord(0, 2),
            new Coord(1, 1),
            new Coord(2, 2)));

  }

}




