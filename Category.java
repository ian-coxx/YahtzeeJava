/**
 * Category.java
 * An abstract base class for all categories on the score card.
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public abstract class Category {

    private int score;
    private boolean used;

    /**
     * abstract method evaluates the die in the dice object
     * and returns a score.
     * @param d
     * @return
     */
    public abstract int evaluate (Dice d);
        //evaluate the die in the dice object and return a score

    /**
     * Add the value the Dice would produce to the
     * score (calls evaluate).
     * @param d
     */
    public void addValue (Dice d) {
        used = true;
        score = evaluate(d); //equal or add?
    }

    /**
     * Return current score for this category.
     * @return
     */
    public int getScore () {
        return score;
    }

    /**
     * Returns value of used indicating if category has
     * been used.
     * @return
     */
    public boolean getUsed () {
        // indicates if a category has been used
        return used;
    }


}
