/**
 * Twos.java
 * Deals with scoring multiple 2's.
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class Twos extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        //recieve one point for each one rolled
        return 2 * (d.count(2));
    }
}
