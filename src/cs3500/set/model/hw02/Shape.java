package cs3500.set.model.hw02;

/**
 * Represents the type of Shape on each card.
 */
public enum Shape {
  OVAL {
    @Override
    public String toString() {
      return "O";
    }
  },
  SQUIGGLE {
    @Override
    public String toString() {
      return "Q";
    }
  },
  DIAMOND {
    @Override
    public String toString() {
      return "D";
    }
  },
}
