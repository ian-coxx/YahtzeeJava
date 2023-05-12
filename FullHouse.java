/**
 * FullHouse.java
 * Category for scoring 3 of one kind and 2 of another kind.
 * Extends Category
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class FullHouse extends Category {
    /**
     * Evaluates the Die in the Dice object and return
     * a score that would be achieved for this category.
     * @param d
     * @return int  Returns score
     */
    public int evaluate (Dice d) {
        int counter = 6;
        int secondCount = 6;
        while (counter > 0) {
            if (d.count(counter) == 3) {
                while (secondCount > 0) {
                    if (secondCount != counter && d.count(secondCount) == 2)
                        return 25;
                    secondCount --;
                }
            }

            counter--;
        }
        return 0;
    }
}
