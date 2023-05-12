/**
 * CategoryValue.java
 * Category Value class that handles all categories in a yahtzee game.
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public enum CategoryValue {
    ONES(0, "Ones"), TWOS(1, "Twos"), THREES(2, "Threes"),
    FOURS(3, "Fours"), FIVES(4, "Fives"), SIXES(5, "Sixes"),
    THREE_OF_A_KIND(6, "Three of a Kind"), FOUR_OF_A_KIND(7, "Four of a Kind"),
    FULL_HOUSE(8, "Full House"), SM_STRAIGHT(9, "Small Straight"),
    LG_STRAIGHT(10, "Large Straight"), YAHTZEE(11, "Yahtzee"),
    CHANCE(12, "Chance");

    private final int value;
    private final String name;

    /**
     Constructor that specifies value and name
     @param v the value
     @param n the name
     */
    private CategoryValue(int v, String n) {
        value = v;
        name = n;
    }
    /**
     Get the value of the CategoryValue
     @return value of the CategoryValue
     */
    public int getValue() {
        return value;
    }
    /**
     return a String representation of CategoryValue
     @return the name (a String)
     */
    @Override
    public String toString() {
        return name;
    }
}

