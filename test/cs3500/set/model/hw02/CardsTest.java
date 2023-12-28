package cs3500.set.model.hw02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * test class for the cards in model.
 */
public class CardsTest {

  @Test
  public void testCreateCards() {
    Count c1 = Count.ONE;
    Filling f1 = Filling.EMPTY;
    Shape s1 = Shape.OVAL;

    Cards x = new Cards(c1, f1, s1);
    x.toString();
    assertEquals("1EO", x.toString());


  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstruct() {
    // should not be able to construct cards due to illegal count
    Count c1 = null;
    Filling f1 = Filling.STRIPED;
    Shape s1 = Shape.DIAMOND;

    Cards x = new Cards(c1, f1, s1);
    assertEquals("Illegal Argument", x.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstruct2() {
    // should not be able to construct cards due to illegal count
    Count c1 = Count.TWO;
    Filling f1 = null;
    Shape s1 = Shape.OVAL;

    Cards x = new Cards(c1, f1, s1);
    assertEquals("Illegal Argument", x.toString());
  }

  @Test
  public void testCreateCards2() {
    Count c1 = Count.TWO;
    Filling f1 = Filling.STRIPED;
    Shape s1 = Shape.DIAMOND;

    Cards x = new Cards(c1, f1, s1);
    x.toString();
    assertEquals("2SD", x.toString());


  }

  @Test
  public void testCreateCards3() {
    Count c1 = Count.THREE;
    Filling f1 = Filling.FULL;
    Shape s1 = Shape.SQUIGGLE;

    Cards x = new Cards(c1, f1, s1);
    x.toString();
    assertEquals("3FQ", x.toString());


  }


}