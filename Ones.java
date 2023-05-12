/**
 * Ones.java
 * Deals with scoring multiple 1's.
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;
import java.util.*;

public class Ones extends Category {

    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        // receive one point for each one rolled
        return d.count(1);
    }

}
