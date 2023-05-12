/**
 * Player.java
 * Player class has-a ScoreCard and a name.
 * Yahtzee Project -- EXTRA CREDIT
 * By Ian Cox
 * CS110
 */

package Yahtzee;

public class Player {

    private String name;
    private ScoreCard scorecard;

    /**
     * Creates a player object, has-a scorecard and name.
     * @param n
     * @param sc
     */
    public Player (String n, ScoreCard sc) {
        name = n;
        scorecard = sc;
    }

    /**
     * Gets a scorecard.
     * @return scorecard
     */
    public ScoreCard getScoreCard () {
        return scorecard;
    }

    /**
     * Gets name.
     * @return name
     */
    public String getName () {
        return name;
    }

}
