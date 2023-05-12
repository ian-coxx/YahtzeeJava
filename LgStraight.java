/**
 * LgStraight.java
 * Deals with a large straight (5 consecutive dye).
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class LgStraight extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        if ( (d.count(1)>0 && d.count(2)>0 && d.count(3)>0 && d.count(4)>0 && d.count(5)>0) ||
                (d.count(2)>0 && d.count(3)>0 && d.count(4)>0 && d.count(5)>0 && d.count(6)>0)) {
            return 40;
        } else {
            return 0;
        }
    }
}
