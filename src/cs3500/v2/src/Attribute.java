package cs3500.v2.src;

/**
 * Represents an attribute of a card in a game of Set. Each attribute has a specific type value.
 * @param <T> type of value or card that this attribute holds.
 */
public interface Attribute<T> {
  /**
   * returns value of the attribute.
   * @return vakue of the particular attribute.
   */
  T getValue();

  /**
   * gets the type of card that represents the type of value that this attribute holds.
   * @return type of object that the attribute is.
   */
  T getType();
}
