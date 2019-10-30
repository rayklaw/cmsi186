/**
* <P>A class a Player in the SliceNDice game.
* <P>Each player has a set of dice made for the game as well as a health total.
*
* @author Raymond Law
*/

public class Player {
    /**
     * The initial health given for a player if no other health total is
     * specified.
     */
    public static final int DEFAULT_STARTING_HEALTH = 50;
    private int health;
    private CombatDie[] dice;

    /**
     * Constructs a Player with the given health and an array of dice of the
     * given length. Of those dice, the number of dice that are "risky" dice
     * should be equal to the given number of risky dice, with the remaining
     * dice as "safe" dice.
     *
     * @param startingHealth              the player's initial health value
     * @param numberOfDice                the number of the dice in the player's
     *                                    array of combatDie
     * @param numberOfRiskyDice           the number of RiskyDie in the player's
     *                                    array of combatDie
     * @throws IllegalArgumentException   if numberOfRiskyDice is greater than
     *                                    numberOfDice
     */
    public Player(int startingHealth, int numberOfDice, int numberOfRiskyDice) {
        dice = new CombatDie[numberOfDice];
        health = startingHealth;

        if (numberOfRiskyDice > numberOfDice || numberOfDice < 1 || numberOfRiskyDice < 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < numberOfRiskyDice; i++) {
                dice[i] = new RiskyDie();
            }
            for (int g = numberOfRiskyDice; g < numberOfDice; g++) {
                dice[g] = new SafeDie();
            }
        }
    }

    /**
     * Constructs a Player with the default health of 50 and an array of dice
     * of the given length. Of those dice, the number of dice that are "risky"
     * dice should be equal to the given number of risky dice, with the
     * remaining dice as "safe" dice.
     *
     * @param numberOfDice                the number of the dice in the player's
     *                                    array of combatDie
     * @param numberOfRiskyDice           the number of RiskyDie in the player's
     *                                    array of combatDie
     * @throws IllegalArgumentException   if numberOfRiskyDice is greater than
     *                                    numberOfDice
     */
    public Player(int numberOfDice, int numberOfRiskyDice) {
        dice = new CombatDie[numberOfDice];
        health = DEFAULT_STARTING_HEALTH;

        if (numberOfRiskyDice > numberOfDice || numberOfDice < 1 || numberOfRiskyDice < 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < numberOfRiskyDice; i++) {
                dice[i] = new RiskyDie();
            }
            for (int g = numberOfRiskyDice; g < numberOfDice; g++) {
                dice[g] = new SafeDie();
            }
        }
    }

    /**
     * Returns this Player's current health.
     *
     * @return this Player's health value.
     */
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int setHealth) {
        health = setHealth;
    }

    /**
     * Returns the CombatDie at the given index in the Player's array of dice.
     *
     * @param index  the index of the die within the Player's arry of dice
     * @return       the CombatDie at the given index
     */
    public CombatDie getDieAtIndex(int index) {
        return this.dice[index];
    }

    /**
     * Rolls all dice belonging to this player, randomly changing the face-up
     * side of each die.
     */
    public void rollAllDice() {
        for (int i = 0; i < this.dice.length - 1; i++) {
            dice[i].roll();
        }
    }

    /**
     * Counts the total value of the given faceType among the face-up sides of
     * this Player's dice.
     *
     * @param faceType  the FaceType being searched for
     * @return          the total values of the face-up sides with the given
     *                  FaceType among the Player's CombatDie array
     */
    public int countOfFaceType(DiceFace.FaceType faceType) {
        int count = 0;
        for (int i = 0; i <= this.dice.length - 1; i++) {
            if (this.dice[i].getFaceUp().getFaceType().equals(faceType)) {
                count += this.dice[i].getFaceUp().getFaceValue();
            }
        }
        return count;
    }

    /**
     * Returns whether there is at least one face-up Broken Shield among the
     * Player's dice.
     *
     * @return <code>true</code> if at least one CombatDie among the player's
     *         dice has a Broken Shield DiceFace as it's face up side;
     *         <code>false</code> otherwise.
     */
    public boolean containsBrokenShield() {
        return (countOfFaceType(DiceFace.FaceType.BROKEN_SHIELD) > 0);
    }

    /**
     * Calculates the attack score of the Player's dice by totaling the values
     * of all face-up Sword faces among the player's dice.
     *
     * @return the attack score determined by totaling the values of all face-up
     *         Sword DiceFaces among the player's dice.
     */
    public int getAttackScore() {
        return countOfFaceType(DiceFace.FaceType.SWORD);
    }

    /**
     * Calculates the defense score of the Player's dice by totaling the values
     * of all face-up Shield faces among the player's dice. If any Broken Shield
     * faces are face-up among the Player's dice, the defense score instead
     * becomes 0.
     *
     * @return the defense score determined by totaling the values of all face-up
     *         Shield DiceFaces among the player's dice; if a Broken Shield face
     *         is face-up, then the returned score is instead 0.
     */
    public int getDefenseScore() {
        if (containsBrokenShield()) {
            return 0;
        } else {
            return countOfFaceType(DiceFace.FaceType.SHIELD);
        }
    }

    /**
     * Calculates the heal score of the Player's dice by totaling the values
     * of all face-up Heal faces among the player's dice.
     *
     * @return the heal score determined by totaling the values of all face-up
     *         Heal DiceFaces among the player's dice.
     */
    public int getHealScore() {
        return countOfFaceType(DiceFace.FaceType.HEAL);
    }

     public int getTotalAmountOfDice() {
         return this.dice.length;
     }

     public String getFaceUpSides() {
         String faceUpSides = "";
         for (int i = 0; i <= this.dice.length - 1; i++) {
             if (this.dice.length - 1 == i) {
                 faceUpSides = faceUpSides + this.dice[i].getFaceUp();
                 break;
             }
             faceUpSides = faceUpSides + this.dice[i].getFaceUp() + ", ";
         }
         return "{ " + faceUpSides + " }";
     }

    /**
     * Returns a string representation of the Player, including health, face-up
     * sides of the dice, and the scored attack, defense, and heal values based
     * upon those dice.
     *
     * @return  a String representation of the Player
     */
    @Override
    public String toString() {
        return "Health: " + health + '\n' +
            getFaceUpSides() + '\n' +
            "Attack: " + getAttackScore() + '\n' +
            "Defense: " + getDefenseScore() + '\n' +
            "Healing: " + getHealScore() + '\n';
    }
}
