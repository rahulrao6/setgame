package cs3500.set.model.hw02;

/**
 * Represents the type of Filling in each specific card.
 */
public enum Filling {
  EMPTY {
    @Override
    public String toString() {
      return "E";
    }
  },
  STRIPED {
    @Override
    public String toString() {
      return "S";
    }
  },
  FULL {
    @Override
    public String toString() {
      return "F";
    }
  },
}
