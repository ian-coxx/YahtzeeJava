/**
 * Threes.java
 * Deals with scoring multiple 3's.
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class Threes extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        //recieve one point for each one rolled
        return 3 * (d.count(3));
    }
}
