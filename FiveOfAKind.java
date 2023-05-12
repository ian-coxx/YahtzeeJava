/**
 * FiveOfAKind.java
 * Category for scoring a yahtzee (five of the same dye).
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class FiveOfAKind extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        int counter = 6;
        while (counter > 0) {
            if (d.count(counter) == 5)
                return 50;

            counter--;
        }
        return 0;
    }
}
