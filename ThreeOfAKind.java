/**
 * ThreeOfAKind.java
 * Deals with scoring 3 dye of the same values.
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class ThreeOfAKind extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        int counter = 6;
        while (counter > 0) {
            if (d.count(counter) == 3)
                return 3 * counter;

            counter--;
        }
        return 0;
    }
}
