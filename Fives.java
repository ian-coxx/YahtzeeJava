/**
 * Fives.java
 * Category for scoring multiple 5's.
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class Fives extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        //recieve one point for each one rolled
        return 5 * (d.count(5));
    }
}
