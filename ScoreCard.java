/**
 * ScoreCard.java
 * The collection of categories, as well as scores of top/bottom and total.
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

import java.util.ArrayList;

public class ScoreCard {
    private ArrayList<Category> scorecard;
    private int yahtzeeBonus = 0;
    private int NUM_CATS = 13;

    /**
     * Create all Category objects and add to the
     * ArrayList.
     */
    public ScoreCard () {
        scorecard = new ArrayList<Category>();
        scorecard.add(new Ones());
        scorecard.add(new Twos());
        scorecard.add(new Threes());
        scorecard.add(new Fours());
        scorecard.add(new Fives());
        scorecard.add(new Sixes());
        scorecard.add(new ThreeOfAKind());
        scorecard.add(new FourOfAKind());
        scorecard.add(new FullHouse());
        scorecard.add(new SmStraight());
        scorecard.add(new LgStraight());
        scorecard.add(new FiveOfAKind());
        scorecard.add(new Chance());
    }

    /**
     * Use cv to get the appropriate Category and
     * score that category. Set appropriate scored
     * element to true, indicating it has been
     * used.
     * @param cv
     * @param d
     */
    public void choose (CategoryValue cv, Dice d) {
        findCategoryValue(cv).addValue(d);
        if (cv == CategoryValue.YAHTZEE && findCategoryValue(cv).getUsed()) {
            yahtzeeBonus += 100;
        }

    }

    /**
     * Return the score that would be achieved in
     * this category with the provided Dice object.
     * @param cv
     * @param d
     * @return int
     */
    public int getEvaluation (CategoryValue cv, Dice d) {
        return findCategoryValue(cv).evaluate(d);
    }

    /**
     * Return true if Category has been used, false
     * otherwise.
     * @param cv
     * @return boolean
     */
    public boolean checkScored (CategoryValue cv) {
        return findCategoryValue(cv).getUsed();
    }

    /**
     * Return the current score for the specified
     * Category.
     * @param cv
     * @return int
     */
    public int getCategoryScore (CategoryValue cv) {
        return findCategoryValue(cv).getScore();
    }

    /**
     * Return the total score for the top of the
     * scorecard.
     * @return int
     */
    public int scoreTop () {
        int total = 0;
        for (int i=0; i<6; i++) {
            total += scorecard.get(i).getScore();
        }
        if (total > 63) {
            total += 35;
        }
        return total;
    }

    /**
     * Return the total score for the bottom of the
     * scorecard.
     * @return int
     */
    public int scoreBottom () {
        int total = yahtzeeBonus; // start total at whatever the bonus is or zero
        for (int i=6; i<NUM_CATS; i++) {
            total += scorecard.get(i).getScore();
        }
        return total;
    }

    /**
     * Return the total score for the scorecard.
     * @return int
     */
    public int score () {
        return scoreTop() + scoreBottom();
    }

    /**
     * Prints out a string version of the scorecard.
     * @return String
     */
    @Override
    public String toString() {
        String write = "Current scorecard: \n";
        for (CategoryValue cv : CategoryValue.values()) {
            write = write + String.format("%15s: %d\n", cv, findCategoryValue(cv).getScore());
        }
        write = write + String.format("%15s %d\n", "Upper Total", scoreTop());
        write = write + String.format("%15s %d\n", "Lower Total", scoreBottom());
        write = write + String.format("%15s %d\n", "Total", score());

        return write;
    }

    /**
     * Finds the category from the index in the scorecard array.
     * @param cv
     * @return
     */
    private Category findCategoryValue (CategoryValue cv) {
        if (cv == CategoryValue.ONES) {
            return scorecard.get(0);
        }
        if (cv == CategoryValue.TWOS) {
            return scorecard.get(1);
        }
        if (cv == CategoryValue.THREES) {
            return scorecard.get(2);
        }
        if (cv == CategoryValue.FOURS) {
            return scorecard.get(3);
        }
        if (cv == CategoryValue.FIVES) {
            return scorecard.get(4);
        }
        if (cv == CategoryValue.SIXES) {
            return scorecard.get(5);
        }
        if (cv == CategoryValue.THREE_OF_A_KIND) {
            return scorecard.get(6);
        }
        if (cv == CategoryValue.FOUR_OF_A_KIND) {
            return scorecard.get(7);
        }
        if (cv == CategoryValue.FULL_HOUSE) {
            return scorecard.get(8);
        }
        if (cv == CategoryValue.SM_STRAIGHT) {
            return scorecard.get(9);
        }
        if (cv == CategoryValue.LG_STRAIGHT) {
            return scorecard.get(10);
        }
        if (cv == CategoryValue.YAHTZEE) {
            return scorecard.get(11);
        }
        if (cv == CategoryValue.CHANCE) {
            return scorecard.get(12);
        }
        return null;
    }

}
