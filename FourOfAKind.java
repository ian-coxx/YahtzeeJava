/**
 * FourOfAKind.java
 * Category for scoring a four dye of the same kind.
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class FourOfAKind extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        int counter = 6;
        while (counter > 0) {
            if (d.count(counter) == 4)
                return 4 * counter;

            counter--;
        }
        return 0;
    }
}
