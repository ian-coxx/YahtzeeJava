/**
 * SmStraight.java
 * Deals with scoring a small straight (4 consecutive dye values).
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class SmStraight extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        if ( (d.count(1)>0 && d.count(2)>0 && d.count(3)>0 && d.count(4)>0) ||
                (d.count(2)>0 && d.count(3)>0 && d.count(4)>0 && d.count(5)>0) ||
                (d.count(3)>0 && d.count(4)>0 && d.count(5)>0 && d.count(6)>0)) {
            return 30;
        } else {
            return 0;
        }
    }
}
