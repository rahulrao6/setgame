package cs3500.set.model.hw02;

/**
 * Represents Cards object with three different values within each card.
 */
public class Cards {
  private Count c1;
  private Filling f1;
  private Shape s1;


  /**
   * constructs the cards.
   *
   * @param c Count.
   * @param f Filling.
   * @param s Shape.
   */
  public Cards(Count c, Filling f, Shape s) {
    if (c == Count.ONE) {
      c1 = Count.ONE;
    } else if (c == Count.TWO) {
      c1 = Count.TWO;
    } else if (c == Count.THREE) {
      c1 = Count.THREE;
    } else if (c == null) {
      throw new IllegalArgumentException("Null Value");
    } else {
      throw new IllegalArgumentException("Invalid Count");
    }

    if (f == Filling.EMPTY) {
      f1 = Filling.EMPTY;
    } else if (f == Filling.STRIPED) {
      f1 = Filling.STRIPED;
    } else if (f == Filling.FULL) {
      f1 = Filling.FULL;
    } else if (f == null) {
      throw new IllegalArgumentException("Null Value");
    } else {
      throw new IllegalArgumentException("Invalid Filling");
    }

    if (s == Shape.OVAL) {
      s1 = Shape.OVAL;
    } else if (s == Shape.DIAMOND) {
      s1 = Shape.DIAMOND;
    } else if (s == Shape.SQUIGGLE) {
      s1 = Shape.SQUIGGLE;
    } else if (s == null) {
      throw new IllegalArgumentException("Null Value");
    } else {
      throw new IllegalArgumentException("Invalid Shape");
    }

  }

  /**
   * makes card value into a string value.
   *
   * @return string value of cards.
   */
  public String toString() {
    return c1.toString() + f1.toString() + s1.toString();
  }


}

