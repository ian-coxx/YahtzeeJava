/**
 * Die.java
 * A class for a single die.
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;
import java.util.*;

public class Die {
    private int value;
    private final int SIDES = 6; //check this constant
    private Random r; // random num generator all die share

    /**
     * Initialize value to a random number between 1
     * and SIDES
     */
    public Die () {
        r = new Random();
        value = r.nextInt(SIDES - 1) + 1;
    }

    /**
     * Changes the value on the die to a random value
     * between 1 and SIDES
     */
    public void roll () {
        value = r.nextInt(SIDES - 1) + 1;
    }

    /**
     * Returns value on die
     * @return int  This returns the value gotten
     */
    public int getValue () {
        return value;
    }

    /**
     * A String containing single integer value
     * representing the value on the die
     * @return String   This returns a statement telling the value on the die
     */
    @Override
    public String toString () {
        return "The value on the die is: " + getValue();
    }

}
