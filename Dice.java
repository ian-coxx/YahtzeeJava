/**
 * Dice.java
 * Dice class is an initially empty container to add Die objects to.
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;

import java.util.ArrayList;

public class Dice {

    private ArrayList<Die> dice;
    private int DEF_CAP = 5;

    /**
     * Creates the ArrayList with DEF_CAP capacity
     */
    public Dice () {
        dice = new ArrayList<>(DEF_CAP); // Yahtzee.Die ??
    }

    /**
     * Create the ArrayList with num capacity
     * @param num
     */
    public Dice (int num) {
        dice = new ArrayList<>(num);
    }

    /**
     * Add the d to the end of the ArrayList
     * @param d
     */
    public void addDie (Die d) {
        dice.add(d);
    }

    /**
     * Returns the number of Die in the ArrayList
     * @return int  Returns the size of dice arraylist
     */
    public int getNumDice () {
        return dice.size();
    }

    /**
     * Returns the Die at index i in the ArrayList.
     * @param i
     * @return Die  Returns a die at a certain index in dice arraylist
     */
    public Die getDie (int i) {
        return dice.get(i);
    }

    /**
     * Removes the Die at the index i in the ArrayList
     * @param i
     */
    public void removeDie (int i) {
        dice.remove(i);
    }

    /**
     * Returns the number of Die in the ArrayList that
     * have a value of the specified val
     * @param val
     * @return int  Returns count of die in dice arraylist with val
     */
    public int count (int val) {
        int ct = 0;
        for (int i = 0; i < dice.size(); i++) {
            int check = dice.get(i).getValue();
            if (check == val)
                ct ++;
        }
        return ct;
    }

    /**
     * Returns the sum of the Die values in the
     * ArrayList
     * @return int  Returns total amount of die in arraylist dice
     */
    public int sum () {
        int s = 0;
        for (int i = 0; i < dice.size(); i++) {
            int check = dice.get(i).getValue();
            s += check;
        }
        return s;
    }

    /**
     * Returns true if at least one Die in the ArrayList
     * has a value of val
     * @param val
     * @return boolean  Returns true or false depending on value occurence
     */
    public boolean contains (int val) {
        boolean contain;
        for (int i = 0; i < dice.size(); i++) {
            int check = dice.get(i).getValue();
            if (check == val)
                return true;
        }
        return false;
    }

    /**
     * For each Die in the ArrayList, returns index and value.
     * @return String   Returns a string called ret
     */
    @Override
    public String toString () { // make sure this is accepted
        String ret = "";
        for (int i = 0; i < dice.size(); i++) {
            int val = dice.get(i).getValue();
            ret = ret + (i+1);
            ret = ret + ":   value ";
            ret = ret + val;
            ret = ret + "\n";
        }
        return ret;
    }



}
