/**
 * Game.java
 * Game class puts the methods and classes together to make a yahtzee game.
 * Yahtzee Project
 * By Ian Cox
 * CS110
 */

package Yahtzee;
import java.util.Scanner;

public class Game {

    private final static int MAX_ROLLS = 3;
    private final static int MAX_TURNS = 13;

    private ScoreCard scoreCardP1;
    private ScoreCard scoreCardP2;
    private int rollNumber;

    Scanner keyboard;

    // Extra credit : Declaring the players and names
    Player p1;
    Player p2;
    String name1;
    String name2;

    /**
     * Game object initializes keyboard, and scorecards for 
     * both players.
     */
    public Game() {
        keyboard = new Scanner(System.in);
        scoreCardP1 = new ScoreCard();
        scoreCardP2 = new ScoreCard();
    }

    /**
     * Plays the game and handles turns for each player.
     */
    public void play() {
        System.out.println("*******************************************************");
        System.out.println("                   WELCOME TO YAHTZEE                  ");
        System.out.println("*******************************************************");

        // EXTRA CREDIT: Player names
        System.out.println("Player 1... What is your name?: ");
        name1 = keyboard.nextLine();
        System.out.println("Player 2... What is your name?: ");
        name2 = keyboard.nextLine();

        // Extra Credit : Assigning the players
        p1 = new Player(name1, scoreCardP1);
        p2 = new Player(name2, scoreCardP2);

        for (int turn=0; turn<MAX_TURNS; turn++) {
            System.out.println("\nPlayer 1, " + p1.getName() + ": "); // gets name from player
            scoreCardShow(p1.getScoreCard()); // gets scorecard from player
            rollNumber = 1;
            finishRoll(new DiceRoll(), null, scoreCardP1);

            System.out.println("\nPlayer 2, " + p2.getName() + ": "); // gets name from player
            scoreCardShow(p2.getScoreCard()); // gets scorecard from player
            rollNumber = 1;
            finishRoll(new DiceRoll(), null, scoreCardP2);
        }

        totalPoints();

    }

    /**
     * Finishes the roll based on if the max amount of rolls
     * was hit yet.
     * @param reRollDice
     * @param saveDice
     * @param sc
     */
    private void finishRoll(Dice reRollDice, Dice saveDice, ScoreCard sc) {
        if (rollNumber < MAX_ROLLS) {
            rollDecide(reRollDice, saveDice, sc);
        } 
        else {
            System.out.println("Final roll:");
            reRollDice = diceAdd(reRollDice, saveDice);
            System.out.println(reRollDice);

            score(sc, reRollDice);
        }
    }

    /**
     * Rolls and allows player to decide if they want to
     * reroll or save certain dice.
     * @param reRollDice
     * @param saveDice
     * @param sc
     */
    private void rollDecide(Dice reRollDice, Dice saveDice, ScoreCard sc) {
        System.out.println("Dice to reroll: ");
        System.out.println(reRollDice);

        if (saveDice != null && saveDice.getNumDice() > 0) {
            System.out.println("Dice to save: ");
            System.out.println(saveDice);
        }

        System.out.println("Save dice with [ ] filled with index values separated by spaces\n" +
                "'roll' to reroll, 'score' to score");
        String input = keyboard.nextLine();

        if (input.equalsIgnoreCase("roll")) {
            scoreCardShow(sc);
            ((DiceRoll)reRollDice).toss();
            rollNumber++;
            finishRoll(reRollDice, saveDice, sc);

        } 
        else if (input.equalsIgnoreCase("score")) {
            reRollDice = diceAdd(reRollDice, saveDice);
            score(sc, reRollDice);

        } 
        else if (input.length() > 2 &&
                input.substring(0, 1).equals("[") &&
                input.substring(input.length()-1).equals("]")) {

            if (saveDice == null) {
                saveDice = new Dice();
            }
            listRead(input, reRollDice, saveDice, sc);
        } 
        else {
            System.out.println(input + " is not valid");
            rollDecide(reRollDice, saveDice, sc);
        }
    }

    /**
     * Tallies up the total points.
     */
    private void totalPoints() {
        int totalP1 = scoreCardP1.score();
        int totalP2 = scoreCardP2.score();

        if (totalP1 > totalP2) {
            System.out.printf("\nPlayer 1 wins with %d points!\nPlayer 2 had %d points", totalP1, totalP2);
        } else {
            System.out.printf("\nPlayer 2 wins with %d points!\nPlayer 1 had %d points", totalP2, totalP1);
        }
    }

    /**
     * Reads into the list of kept dice.
     * @param input
     * @param diceToReroll
     * @param diceToSave
     * @param scorecard
     */
    private void listRead(String input, Dice diceToReroll, Dice diceToSave, ScoreCard scorecard) {
        String old = input;
        boolean notValid = false;
        try {
            
            int[] indexes = new int[input.length() / 2];
            for (int i=0; i<indexes.length; i++) {
                int index = Integer.parseInt(input.substring(1, 2)) - 1;
                
                if (index < 0 || index >= diceToReroll.getNumDice() + diceToSave.getNumDice()) {
                    notValid = true;
                } 
                else {
                    indexes[i] = index;
                }

                if (input.length() > 3 && !input.substring(2, 3).equals(" ")) {
                    notValid = true;
                }

                input = input.substring(2);
            }

            if (notValid) {
                System.out.println(old + " is not valid");
                rollDecide(diceToReroll, diceToSave, scorecard);
            } 
            else if ((hasSame(indexes))) {
                System.out.println("Please provide a list of dice to save without duplicates");
                rollDecide(diceToReroll, diceToSave, scorecard);
            } 
            else {
                indexes = indexSorting(indexes);

                for (int i=0; i<indexes.length; i++) {
                    diceToSave.addDie(diceToReroll.getDie(indexes[i]));
                    diceToReroll.removeDie(indexes[i]);
                }
                rollDecide(diceToReroll, diceToSave, scorecard);
            }
        } catch (Exception e) {
            System.out.println(old + " is not valid");
            
            rollDecide(diceToReroll, diceToSave, scorecard);
        }
    }

    /**
     * Shows what categories are still available to use.
     * @param sc
     * @param d
     */
    private void categoriesAvailable(ScoreCard sc, Dice d) {
        for (CategoryValue cv : CategoryValue.values()) {
            if ( !sc.checkScored(cv) ||
                    (cv == CategoryValue.YAHTZEE && sc.getCategoryScore(cv) != 0) ) {
                System.out.printf("%d: %s, %d points\n", cv.getValue()+1, cv, sc.getEvaluation(cv, d));
            }
        }
    }

    /**
     * Displays the current scorecard.
     * @param sc
     */
    private void scoreCardShow(ScoreCard sc) {
        System.out.println(sc);
    }
    
    private boolean hasSame(int[] arr) {
        for (int check = 0; check < arr.length-1; check++) {
            for (int i = check + 1; i<arr.length; i++) {
                if (arr[check] == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sorts indexes (numbers) kept between brackets.
     * @param arr
     * @return
     */
    private int[] indexSorting(int[] arr) {
        int begin, index, maxInd, maxVal;

        for (begin = 0; begin < (arr.length-1); begin++)
        {
            maxInd = begin;
            maxVal = arr[begin];
            
            for(index = begin + 1; index < arr.length; index++)
            {
                if (arr[index] > maxVal)
                {
                    maxInd = index;
                    maxVal = arr[index];
                }
            }
            arr[maxInd] = arr[begin];
            arr[begin] = maxVal;
        }

        return arr;
    }

    /**
     * Adds up multiple dye.
     * @param d1
     * @param d2
     * @return
     */
    private Dice diceAdd(Dice d1, Dice d2) {
        if (d2 != null) {
            for (int i=0; i<d2.getNumDice(); i++) {
                d1.addDie(d2.getDie(i));
            }
        }
        return d1;
    }

    /**
     * Shows scores in categories.
     * @param scorecard
     * @param dice
     */
    private void score(ScoreCard scorecard, Dice dice) {
        System.out.println("Select a category that you have not scored in yet:");
        categoriesAvailable(scorecard, dice);
        try {
            int categoryNumber = keyboard.nextInt();
            keyboard.nextLine();
            boolean invalid = true;
            for (CategoryValue cv : CategoryValue.values()) {
                if (cv.getValue() == categoryNumber - 1 && !scorecard.checkScored(cv)) {
                    scorecard.choose(cv, dice);
                    System.out.printf("You scored %d points in %s\n", scorecard.getCategoryScore(cv), cv);
                    invalid = false;
                }
            }

            if (invalid) {
                System.out.println("Invalid category number");
                score(scorecard, dice);
            }
        } catch (Exception e) {
            keyboard.nextLine();
            System.out.println("Please enter a number");
            score(scorecard, dice);
        }
    }
    
    
}
