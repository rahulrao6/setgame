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
import static org.junit.Assert.assertTrue;

/**
 * Third testing class of the generalsetGame.
 */
public class SetGeneralThree {

  @Test(expected = IllegalArgumentException.class)
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
      s.claimSet(new Coord(10, 3), c2, c3);
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

  @Test(expected = IllegalArgumentException.class)
  public void claimSet3() {

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
      s.claimSet(c1, new Coord(10, 5), c3);
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

  @Test(expected = IllegalArgumentException.class)
  public void claimSet4() {

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
      s.claimSet(c1, c2, new Coord(10, 5));
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
  public void getHeight() {
    try {
      List<Cards> l1 = new ArrayList<>();

      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.OVAL));
      l1.add(new Cards(Count.TWO, Filling.FULL, Shape.DIAMOND));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));

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
      s.claimSet(new Coord(0, 0), new Coord(0, 1), new Coord(0, 2));
      assertEquals(" ", view.toString());
      System.out.print(view.toString());
      assertEquals(1, s.getScore());
    } catch (IndexOutOfBoundsException e) {
      //ignore
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
    assertEquals("1EO 1EQ 1ED\n" +
            "2EO 2EQ 2ED\n" +
            "3EO 3EQ 3ED", v.toString());
    assertTrue(s.isGameOver());
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkIllegal() {
    try {
      List<Cards> l1 = new ArrayList<>();

      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.OVAL));
      l1.add(new Cards(Count.TWO, Filling.FULL, Shape.DIAMOND));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));

      l1.add(new Cards(Count.TWO, Filling.STRIPED, Shape.OVAL));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.OVAL));

      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.DIAMOND));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));


      GeneralSetGameModel s = new GeneralSetGameModel();
      Appendable a = new StringBuilder("");
      SetGameTextView view = new SetGameTextView(s, a);
      s.startGameWithDeck(l1, 2, 3);
      s.claimSet(new Coord(1, 1), new Coord(0, 1), new Coord(1, 2));
      System.out.print(view.toString());
      assertEquals(1, s.getScore());
    } catch (IndexOutOfBoundsException e) {
      //ignore
    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void checkIllegalView() {
    try {
      List<Cards> l1 = new ArrayList<>();

      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.OVAL));
      l1.add(new Cards(Count.TWO, Filling.FULL, Shape.DIAMOND));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));

      l1.add(new Cards(Count.TWO, Filling.STRIPED, Shape.OVAL));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.OVAL));

      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.DIAMOND));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));


      GeneralSetGameModel s = null;
      Appendable a = new StringBuilder("");
      SetGameTextView view = new SetGameTextView(s, a);
      s.startGameWithDeck(l1, 2, 3);
      //  s.claimSet(new Coord(1,1),new Coord(0,1),new Coord(1,2));
      System.out.print(view.toString());
      assertEquals(1, s.getScore());
    } catch (IndexOutOfBoundsException e) {
      //ignore
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkIllegalView2() {
    try {
      List<Cards> l1 = new ArrayList<>();

      l1.add(new Cards(Count.ONE, Filling.EMPTY, Shape.OVAL));
      l1.add(new Cards(Count.TWO, Filling.FULL, Shape.DIAMOND));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));

      l1.add(new Cards(Count.TWO, Filling.STRIPED, Shape.OVAL));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.OVAL));

      l1.add(new Cards(Count.TWO, Filling.EMPTY, Shape.DIAMOND));
      l1.add(new Cards(Count.ONE, Filling.FULL, Shape.OVAL));
      l1.add(new Cards(Count.THREE, Filling.STRIPED, Shape.SQUIGGLE));


      GeneralSetGameModel s = new GeneralSetGameModel();
      Appendable a = null;
      SetGameTextView view = new SetGameTextView(s, a);
      s.startGameWithDeck(l1, 2, 3);
      //  s.claimSet(new Coord(1,1),new Coord(0,1),new Coord(1,2));
      System.out.print(view.toString());
      assertEquals(1, s.getScore());
    } catch (IndexOutOfBoundsException e) {
      //ignore
    }

  }
}
