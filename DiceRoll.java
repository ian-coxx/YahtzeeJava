/**
 * DiceRoll.java
 * DiceRoll class is-a Dice, a specializatino of the Dice class that
 * allows tossing (rolling all the Die in the collection).
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;


public class DiceRoll extends Dice {

    private int NUM_DIE = 5;

    /**
     * Fill the super (Dice) object with NUM_DIE
     * random Die objects
     */
    public DiceRoll () {
        super();
      //  Dice d = new Dice(NUM_DIE);
        for (int i=0; i<NUM_DIE; i++) {
            Die newDie = new Die();
            super.addDie(newDie);
        }
    }

    /**
     * Rolls each of the Die in the Dice ArrayList
     */
    public void toss () {
        for (int i = 0; i<getNumDice(); i++) {
            super.getDie(i).roll();
        }
    }

}
