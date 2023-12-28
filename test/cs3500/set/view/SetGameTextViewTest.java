package cs3500.set.view;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import cs3500.set.model.hw02.Cards;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetThreeGameModel;


/**
 * Represents textview testing.
 */
public class SetGameTextViewTest extends TestCase {
  // NEED MOCK
  @Test
  public void testTestToString() {
    SetThreeGameModel s = new SetThreeGameModel();
    Appendable ap = new StringBuilder();
    // view
    SetGameTextView v = new SetGameTextView(s, ap);
    List<Cards> deck = s.getCompleteDeck();
    s.startGameWithDeck(deck, 3, 3);

    assertEquals(0, s.getScore());
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(1, 0);
    Coord c3 = new Coord(2, 0);
    s.claimSet(c1, c2, c3);
    assertEquals(1, s.getScore());
    Coord c4 = new Coord(0, 0);
    Coord c5 = new Coord(1, 0);
    Coord c6 = new Coord(2, 0);
    assertTrue(s.anySetsPresent());
    //code is failing after running setClaim more than once
    s.claimSet(c4, c5, c6);
    assertEquals(2, s.getScore());
    try {
      v.renderGrid();
    } catch (IOException e) {
      //do nothing

    }
    Coord c7 = new Coord(0, 2);
    Coord c8 = new Coord(1, 2);
    Coord c9 = new Coord(2, 2);
    s.claimSet(c7, c8, c9);
    assertEquals(3, s.getScore());


  }

}