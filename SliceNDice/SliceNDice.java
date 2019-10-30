/**
@author Raymond Law
**/

public class SliceNDice {
    private static Player Player1;
    private static Player Player2;

    public static String usageInstructions = "Usage Instructions: " + '\n' + "java SliceNDice *no arguments*" +
        '\n' + "java SliceNDice <total number of dice>" +
        '\n' + "java SliceNDice <total number of dice> <number of riskyDice>" +
        '\n' + "java SliceNDce <total number of dice> <number of riskyDice for Player1> <number of RiskyDice for Player2";

    public static String displayHealth(Player player1, Player player2) {
        return "Player 1: " + player1.getHealth() + "      Player 2: " + player2.getHealth();
    }

    public static String playerString(Player player) {
        return player.toString();
    }

    public static int getDamage(Player attacker, Player defender) {
        if ((attacker.getAttackScore() - defender.getDefenseScore()) > 0) {
            return attacker.getAttackScore() - defender.getDefenseScore();
        } else {
            return 0;
        }
    }

    public static String combatInformation(Player player1, Player player2) {
        return "\nPlayer 1 takes " + getDamage(player2, player1) + " damage and heals " + player1.getHealScore() +
            "!\nPlayer 2 takes " + getDamage(player1, player2) + " damage and heals " + player2.getHealScore() + "!";
    }

    public static boolean isDead(Player player) {
        return player.getHealth() <= 0;
    }

    public static boolean exceedsMaxHealth(Player player) {
        return player.getHealth() > 50;
    }
    
    public static void applyDamage(Player player1, Player player2) {
        player1.setHealth(player1.getHealth() - getDamage(player2, player1));
        player2.setHealth(player2.getHealth() - getDamage(player1, player2));
        if (isDead(player1)) {
            player1.setHealth(0);
        }
        if (isDead(player2)) {
            player2.setHealth(0);
        }
    }

    public static void applyHealing(Player player1, Player player2) {
        if (!isDead(player1)) {
            player1.setHealth(player1.getHealth() + player1.getHealScore());
        }
        if (!isDead(player2)) {
            player2.setHealth(player2.getHealth() + player2.getHealScore());
        }
        if (exceedsMaxHealth(player1)) {
            player1.setHealth(50);
        }
        if (exceedsMaxHealth(player2)) {
            player2.setHealth(50);
        }
    }

    public static boolean foundWinner(Player player1, Player player2, int rounds) {
        return player1.getHealth() == 0 || player2.getHealth() == 0 || rounds == 25;
    }

    public static void displayGameOverMessage(Player player1, Player player2, int rounds) {
        if (player1.getHealth() == 0 || player2.getHealth() == 0 || rounds == 25) {
            System.out.println("~~~~ GAME OVER ~~~~");
            if (player2.getHealth() == player1.getHealth() && player1.getHealth() == 0) {
                System.out.println("It is a tie! The Players are dead!");
            } else if (isDead(player1)) {
                System.out.println("Player 2 Wins " + player2.getHealth() + " to 0!");
            } else if (isDead(player2)) {
                System.out.println("Player 1 Wins " + player1.getHealth() + " to 0!");
            } else if (rounds == 25) {
                if (player1.getHealth() > player2.getHealth()) {
                    System.out.println("Player 1 Wins " + player1.getHealth() + " to " + player2.getHealth() + "!");
                } else if (player1.getHealth() < player2.getHealth()) {
                    System.out.println("Player 2 Wins " + player2.getHealth() + " to " + player1.getHealth() + "!");
                } else if (player2.getHealth() == player1.getHealth()) {
                    System.out.println("It is a tie! Both Players have " + player1.getHealth() + " health!");
                }
            }
        }
    }

    public static void playSliceNDice() {
        String roundString;
        String playerOneInformation;
        String playerTwoInformation;

        System.out.println('\n' + displayHealth(Player1, Player2));
        for (int i = 1; i <= 25; i++) {
            roundString = '\n' + "***ROUND " + i + "***" + '\n';
            System.out.println(roundString);
            Player1.rollAllDice();
            Player2.rollAllDice();
            playerOneInformation = "Player One" + '\n' + "-----------" + '\n' + playerString(Player1) + '\n';
            System.out.println(playerOneInformation);
            playerTwoInformation = "Player Two" + '\n' + "-----------" + '\n' + playerString(Player2);
            System.out.println(playerTwoInformation);
            System.out.println(combatInformation(Player1, Player2));
            applyDamage(Player1, Player2);
            applyHealing(Player1, Player2);
            System.out.println(displayHealth(Player1, Player2));
            displayGameOverMessage(Player1, Player2, i);
            if (foundWinner(Player1, Player2, i) == true) {
                break;
            }
        }
    }


    public static void main (String[] args) {
        try {
            if (args.length == 0) {
                Player1 = new Player(7, 1);
                Player2 = new Player(7, 1);
            } else if (args.length == 1) {
                int totalDice = Integer.parseInt(args[0]);
                Player1 = new Player(totalDice, 1);
                Player2 = new Player(totalDice, 1);
            } else if (args.length == 2) {
                int totalDice = Integer.parseInt(args[0]);
                int totalRiskyDice = Integer.parseInt(args[1]);
                Player1 = new Player(totalDice, totalRiskyDice);
                Player2 = new Player(totalDice, totalRiskyDice);
            } else if (args.length == 3) {
                int totalDice = Integer.parseInt(args[0]);
                int totalRiskyDice = Integer.parseInt(args[1]);
                int player2RiskyDice = Integer.parseInt(args[2]);
                Player1 = new Player(totalDice, totalRiskyDice);
                Player2 = new Player(totalDice, player2RiskyDice);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println(usageInstructions);
            return;
        }
        playSliceNDice();
    }
}
