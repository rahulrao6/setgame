package cs3500.v2.src;

import java.util.List;

/**
 * Represents a card in a game of Set. Each card has a list of attributes and can be of a different
 * type.
 */
public interface Card {

  /**
   * gets the list of attributes for a particular card.
   * @return the list of attributes for a card.
   */
  List<Attribute<?>> getAttributes();


}
