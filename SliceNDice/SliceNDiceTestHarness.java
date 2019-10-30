/**
* SliceNDiceTestHarness
*
* <P>A test harness for the classes associated with the SliceNDice game.
*
* <P>Several tests have been added for DiceFace and CombatDie, but additional
* tests are needed for the classes Player and SliceNDice game.
*
* @author Don Murphy
* @author Yourname Here
*/
public class SliceNDiceTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static final long ROLL_TEST_COUNT = 10000;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_DiceFaceConstructors();
        test_DiceFaceToString();
        test_DiceFaceSetFaceTypeAndValue();
        test_DiceFaceEquals();

        test_CombatDieConstructors();
        test_CombatDieToString();
        test_CombatDieSetFaceAtIndex();
        test_CombatDieGetSetFaceUp();
        test_CombatDieRoll();
        test_CombatDieFaceCount();
        test_SafeAndRiskyDieConstructors();

        //Tests for Player and SliceNDice

        test_PlayerConstructor();
        test_GetDieAtIndex();
        test_CountOfFaceType();
        test_ContainsBrokenShield();
        test_GetAttackScore();
        test_GetDefenseScore();
        test_GetHealScore();

        test_DisplayHealth();
        test_PlayerString();
        test_GetDamage();
        test_CombatInformation();
        test_IsDead();
        test_ExceedsMaxHealth();
        test_ApplyDamage();
        test_ApplyHealing();
        test_FoundWinner();

        System.out.println("-----OVERALL PERFORMANCE-----");
        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayUnimplementedMethodFailure() {
        attempts++;
        System.out.println("failure (NYI)");
    }

    private static void test_PlayerConstructor() {
        System.out.println("Testing Player constructor...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(50, 2, 1);
            displaySuccessIfTrue(testPlayer.getHealth() == 50);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(40, 4, 1);
            displaySuccessIfTrue(testPlayer.getTotalAmountOfDice() == 4);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(40, 4, 1);
            displaySuccessIfTrue(
                testPlayer.getDieAtIndex(0).equals(new RiskyDie()) &&
                testPlayer.getDieAtIndex(1).equals(new SafeDie()) &&
                testPlayer.getDieAtIndex(2).equals(new SafeDie()) &&
                testPlayer.getDieAtIndex(3).equals(new SafeDie())
                );
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(40, 4, 5);
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(true);
        }

        try {
            Player testPlayer = new Player(40, 0, 0);
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(true);
        }

        try {
            Player testPlayer = new Player(40, 4, -1);
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(true);
        }

        System.out.println("Player constructor: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_GetDieAtIndex() {
        System.out.println("Testing getDieAtIndex...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(5, 2);
            displaySuccessIfTrue(testPlayer.getDieAtIndex(1).equals(new RiskyDie()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(5, 2);
            displaySuccessIfTrue(testPlayer.getDieAtIndex(2).equals(new SafeDie()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(7, 1);
            displaySuccessIfTrue(testPlayer.getDieAtIndex(6).equals(new SafeDie()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(7, 1);
            displaySuccessIfTrue(testPlayer.getDieAtIndex(0).equals(new RiskyDie()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(7, 1);
            displaySuccessIfTrue(testPlayer.getDieAtIndex(7).equals(new RiskyDie()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

        System.out.println("getDieAtIndex: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CountOfFaceType() {
        System.out.println("Testing countOfFaceType...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(2, 1);
            displaySuccessIfTrue(testPlayer.countOfFaceType(DiceFace.FaceType.SWORD) == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(2, 1);
            displaySuccessIfTrue(testPlayer.countOfFaceType(DiceFace.FaceType.SHIELD) == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(5, 2);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(2).setFaceUpIndex(4);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(4);
            displaySuccessIfTrue(testPlayer.countOfFaceType(DiceFace.FaceType.SHIELD) == 4);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(5, 2);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(7);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(7);
            displaySuccessIfTrue(testPlayer.countOfFaceType(DiceFace.FaceType.BROKEN_SHIELD) == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(4, 3);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(5);
            displaySuccessIfTrue(testPlayer.countOfFaceType(DiceFace.FaceType.HEAL) == 4);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("countOfFaceType: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_ContainsBrokenShield() {
        System.out.println("Testing containsBrokenShield...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(2, 1);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(6);
            displaySuccessIfTrue(testPlayer.containsBrokenShield());
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(2, 1);
            displaySuccessIfTrue(!testPlayer.containsBrokenShield());
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("containsBrokenShield: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_GetAttackScore() {
        System.out.println("Testing GetAttackScore...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(4, 3);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(5);
            displaySuccessIfTrue(testPlayer.getAttackScore() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(2, 1);
            displaySuccessIfTrue(testPlayer.getAttackScore() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(4, 3);
            displaySuccessIfTrue(testPlayer.getAttackScore() == 7);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(10, 10);
            displaySuccessIfTrue(testPlayer.getAttackScore() == 20);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("getAttackScore: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_GetDefenseScore() {
        System.out.println("Testing getDefenseScore...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(2, 1);
            displaySuccessIfTrue(testPlayer.getDefenseScore() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(4, 3);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(4);
            displaySuccessIfTrue(testPlayer.getDefenseScore() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(8, 3);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(2).setFaceUpIndex(4);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(4).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(5).setFaceUpIndex(4);
            testPlayer.getDieAtIndex(6).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(7).setFaceUpIndex(3);
            displaySuccessIfTrue(testPlayer.getDefenseScore() == 8);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(4, 3);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer.getDieAtIndex(2).setFaceUpIndex(6);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(4);
            displaySuccessIfTrue(testPlayer.getDefenseScore() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("getDefenseScore: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_GetHealScore() {
        System.out.println("Testing getHealScore...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(2, 1);
            displaySuccessIfTrue(testPlayer.getHealScore() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(4, 3);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(5);
            displaySuccessIfTrue(testPlayer.getHealScore() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(6, 3);
            testPlayer.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(3).setFaceUpIndex(5);
            testPlayer.getDieAtIndex(4).setFaceUpIndex(5);
            displaySuccessIfTrue(testPlayer.getHealScore() == 5);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("getHealScore: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DisplayHealth() {
        System.out.println("Testing DisplayHealth...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer1 = new Player(7, 1);
            Player testPlayer2 = new Player(7, 1);
            displaySuccessIfTrue(SliceNDice.displayHealth(testPlayer1, testPlayer2).equals("Player 1: 50      Player 2: 50"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(7, 1);
            Player testPlayer2 = new Player(7, 1);
            testPlayer1.setHealth(20);
            testPlayer2.setHealth(18);
            displaySuccessIfTrue(SliceNDice.displayHealth(testPlayer1, testPlayer2).equals("Player 1: 20      Player 2: 18"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DisplayHealth: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_PlayerString() {
        System.out.println("Testing PlayerString...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer1 = new Player(7, 1);
            displaySuccessIfTrue(SliceNDice.playerString(testPlayer1).equals(testPlayer1.toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer2 = new Player(3, 2);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(3);
            displaySuccessIfTrue(SliceNDice.playerString(testPlayer2).equals(testPlayer2.toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("PlayerString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_GetDamage(){
        System.out.println("Testing GetDamage...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer1 = new Player(7, 1);
            Player testPlayer2 = new Player(7, 1);
            displaySuccessIfTrue(SliceNDice.getDamage(testPlayer1, testPlayer2) == 8);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(3, 2);
            Player testPlayer2 = new Player(3, 2);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(3);
            displaySuccessIfTrue(SliceNDice.getDamage(testPlayer1, testPlayer2) == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(3).setFaceUpIndex(5);
            displaySuccessIfTrue(SliceNDice.getDamage(testPlayer1, testPlayer2) == 8);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(7);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(3).setFaceUpIndex(3);
            displaySuccessIfTrue(SliceNDice.getDamage(testPlayer1, testPlayer2) == 8);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("GetDamage: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatInformation(){
        System.out.println("Testing combatInformation...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer1 = new Player(7, 1);
            Player testPlayer2 = new Player(7, 1);
            displaySuccessIfTrue(SliceNDice.combatInformation(testPlayer1, testPlayer2).equals(
                "\nPlayer 1 takes 8 damage and heals 0!\nPlayer 2 takes 8 damage and heals 0!"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(5);
            displaySuccessIfTrue(SliceNDice.combatInformation(testPlayer1, testPlayer2).equals(
                "\nPlayer 1 takes 1 damage and heals 0!\nPlayer 2 takes 6 damage and heals 1!"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("combatInformation: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_IsDead(){
        System.out.println("Testing isDead...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(7, 1);
            displaySuccessIfTrue(!SliceNDice.isDead(testPlayer));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(7, 1);
            testPlayer.setHealth(1);
            displaySuccessIfTrue(!SliceNDice.isDead(testPlayer));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(7, 1);
            testPlayer.setHealth(0);
            displaySuccessIfTrue(SliceNDice.isDead(testPlayer));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("IsDead: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_ExceedsMaxHealth(){
        System.out.println("Testing ExceedsMaxHealth...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer = new Player(7, 1);
            displaySuccessIfTrue(!SliceNDice.exceedsMaxHealth(testPlayer));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(7, 1);
            testPlayer.setHealth(0);
            displaySuccessIfTrue(!SliceNDice.exceedsMaxHealth(testPlayer));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer = new Player(7, 1);
            testPlayer.setHealth(69);
            displaySuccessIfTrue(SliceNDice.exceedsMaxHealth(testPlayer));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("ExceedsMaxHealth: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_ApplyDamage(){
        System.out.println("Testing ApplyDamage...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(5);
            SliceNDice.applyDamage(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 49 && testPlayer2.getHealth() == 44);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.getDieAtIndex(2).setFaceUpIndex(3);
            testPlayer1.getDieAtIndex(3).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(3).setFaceUpIndex(3);
            SliceNDice.applyDamage(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 50 && testPlayer2.getHealth() == 50);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer2.setHealth(1);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(3);
            testPlayer2.getDieAtIndex(3).setFaceUpIndex(3);
            SliceNDice.applyDamage(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 50 && testPlayer2.getHealth() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(1);
            testPlayer2.setHealth(1);
            SliceNDice.applyDamage(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 0 && testPlayer2.getHealth() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("ApplyDamage: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_ApplyHealing(){
        System.out.println("Testing ApplyHealing...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(25);
            testPlayer2.setHealth(25);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(3).setFaceUpIndex(5);
            SliceNDice.applyHealing(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 25 && testPlayer2.getHealth() == 29);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(25);
            testPlayer2.setHealth(25);
            testPlayer1.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer1.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer1.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer1.getDieAtIndex(3).setFaceUpIndex(5);
            SliceNDice.applyHealing(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 29 && testPlayer2.getHealth() == 25);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(47);
            testPlayer2.setHealth(47);
            testPlayer1.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer1.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer1.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer1.getDieAtIndex(3).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(3).setFaceUpIndex(5);
            SliceNDice.applyHealing(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 50 && testPlayer2.getHealth() == 50);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(47);
            testPlayer2.setHealth(47);
            SliceNDice.applyHealing(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 47 && testPlayer2.getHealth() == 47);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(25);
            testPlayer2.setHealth(0);
            testPlayer2.getDieAtIndex(0).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(1).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(2).setFaceUpIndex(5);
            testPlayer2.getDieAtIndex(3).setFaceUpIndex(5);
            SliceNDice.applyHealing(testPlayer1, testPlayer2);
            displaySuccessIfTrue(testPlayer1.getHealth() == 25 && testPlayer2.getHealth() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("ApplyHealing: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_FoundWinner() {
        System.out.println("Testing FoundWinner...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(25);
            testPlayer2.setHealth(25);
            displaySuccessIfTrue(!SliceNDice.foundWinner(testPlayer1, testPlayer2, 10));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(0);
            testPlayer2.setHealth(25);
            displaySuccessIfTrue(SliceNDice.foundWinner(testPlayer1, testPlayer2, 10));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(25);
            testPlayer2.setHealth(0);
            displaySuccessIfTrue(SliceNDice.foundWinner(testPlayer1, testPlayer2, 10));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(25);
            testPlayer2.setHealth(25);
            displaySuccessIfTrue(SliceNDice.foundWinner(testPlayer1, testPlayer2, 25));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Player testPlayer1 = new Player(4, 4);
            Player testPlayer2 = new Player(4, 2);
            testPlayer1.setHealth(0);
            testPlayer2.setHealth(0);
            displaySuccessIfTrue(SliceNDice.foundWinner(testPlayer1, testPlayer2, 10));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("FoundWinner: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DiceFaceConstructors() {
        System.out.println("Testing DiceFace constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            DiceFace testFace = new DiceFace();
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SWORD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SWORD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SHIELD, 2);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SHIELD
                    && testFace.getFaceValue() == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.HEAL
                    && testFace.getFaceValue() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.BROKEN_SHIELD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 2);
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DiceFaceToString() {
        System.out.println("Testing DiceFace toString...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            DiceFace testFace = new DiceFace();
            displaySuccessIfTrue(testFace.toString().equals("Sword 1"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            displaySuccessIfTrue(testFace.toString().equals("Sword 1"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SHIELD, 2);
            displaySuccessIfTrue(testFace.toString().equals("Shield 2"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(testFace.toString().equals("Heal 3"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            displaySuccessIfTrue(testFace.toString().equals("Broken Shield 1"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace toString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DiceFaceSetFaceTypeAndValue() {
        System.out.println("Testing DiceFace set methods...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        DiceFace testFace = new DiceFace();

        try {
            testFace.setFaceType(DiceFace.FaceType.SHIELD);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SHIELD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceValue(3);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SHIELD
                    && testFace.getFaceValue() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceType(DiceFace.FaceType.HEAL);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.HEAL
                    && testFace.getFaceValue() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceValue(2);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.HEAL
                    && testFace.getFaceValue() == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceType(DiceFace.FaceType.BROKEN_SHIELD);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.BROKEN_SHIELD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceValue(2);
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace set methods: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DiceFaceEquals() {
        System.out.println("Testing DiceFace equals...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            DiceFace testFace = new DiceFace();
            displaySuccessIfTrue(testFace.equals(testFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            displaySuccessIfTrue(testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SWORD, 2);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SHIELD, 1);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SHIELD, 2);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SHIELD, 1);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace equals: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieConstructors() {
        System.out.println("Testing CombatDie constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(testDie.getNumberOfFaces() == 4
                    && testDie.getFaceUpIndex() >= 0
                    && testDie.getFaceUpIndex() < 4);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)
                    };
            CombatDie otherDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.equals(otherDie));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.getNumberOfFaces() == 6
                    && testDie.getFaceUpIndex() >= 0
                    && testDie.getFaceUpIndex() < 6);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] firstFaceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            DiceFace[] secondFaceArray = {
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),};
            CombatDie firstDie = new CombatDie(firstFaceArray);
            CombatDie secondDie = new CombatDie(secondFaceArray);
            displaySuccessIfTrue(firstDie.equals(secondDie));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] firstFaceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            DiceFace[] secondFaceArray = {
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),};
            CombatDie firstDie = new CombatDie(firstFaceArray);
            CombatDie secondDie = new CombatDie(secondFaceArray);
            displaySuccessIfTrue(!firstDie.equals(secondDie));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {new DiceFace(DiceFace.FaceType.SWORD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException uoe) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieToString() {
        System.out.println("Testing CombatDie toString...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Sword 1, Shield 1, Heal 1, Broken Shield 1 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Sword 1, Sword 2, Shield 1, Shield 1, Heal 1, Broken Shield 1 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Broken Shield 1, Sword 2, Broken Shield 1 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Heal 1, Sword 2, Heal 3, Shield 4, Sword 5 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie toString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieSetFaceAtIndex() {
        System.out.println("Testing CombatDie setFaceAtIndex...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            DiceFace newFace = new DiceFace(DiceFace.FaceType.SHIELD, 6);
            testDie.setFaceAtIndex(newFace, 2);
            displaySuccessIfTrue(testDie.getFaceAtIndex(2).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5)};
            CombatDie testDie = new CombatDie(faceArray);
            DiceFace newFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            testDie.setFaceAtIndex(newFace, 0);
            displaySuccessIfTrue(testDie.getFaceAtIndex(0).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            DiceFace newFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            testDie.setFaceAtIndex(newFace, 8);
            displaySuccessIfTrue(testDie.getFaceAtIndex(8).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            DiceFace newFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            testDie.setFaceAtIndex(newFace, 5);
            displaySuccessIfTrue(testDie.getFaceAtIndex(5).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie setFaceAtIndex: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieGetSetFaceUp() {
        System.out.println("Testing CombatDie get/set faceUp methods...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(testDie.getFaceUp().equals(
                    testDie.getFaceAtIndex(testDie.getFaceUpIndex())));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(2);
            displaySuccessIfTrue(testDie.getFaceUpIndex() == 2 &&
                    testDie.getFaceUp().equals(testDie.getFaceAtIndex(2)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(2);
            displaySuccessIfTrue(testDie.getFaceUpIndex() == 2 &&
                    testDie.getFaceUp().equals(testDie.getFaceAtIndex(2)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(4);
            displaySuccessIfTrue(false);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException exc) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(-1);
            displaySuccessIfTrue(false);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException exc) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie get/set faceUp methods: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieFaceCount() {
        System.out.println("Testing CombatDie faceCount...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(
                    testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 1
                    && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 1
                    && testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1
                    && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                   testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 2
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SWORD, 3),
                    new DiceFace(DiceFace.FaceType.SWORD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                   testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 3)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 4)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 5)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SHIELD, 5),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                   testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 2
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 5)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 3)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 2)) == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie faceCount: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieRoll() {
        System.out.println("Testing CombatDie roll...");
        System.out.println("*****WARNING*****");
        System.out.println("* Due to randomization, these tests can fail when working normally.");
        System.out.println("* Use the printed percentages to confirm if any sides are being favored or ignored.");
        System.out.println("*****************");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();

            long[] tally = new long[testDie.getNumberOfFaces()];
            boolean weighted = false;
            for (int i = 0; i < ROLL_TEST_COUNT; i++) {
                testDie.roll();
                tally[testDie.getFaceUpIndex()]++;
            }

            for (int i = 0; i < tally.length; i++) {
                double percentage = ((double)tally[i] / ((double)ROLL_TEST_COUNT / 100.0));
                System.out.println(i + ": " + percentage + "%");
                if (percentage - (100.0 / (double)testDie.getNumberOfFaces()) > 1.0
                        || percentage - (100.0 / (double)testDie.getNumberOfFaces()) < -1.0) {
                    weighted = true;
                }
            }
            displaySuccessIfTrue(!weighted);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);

            long[] tally = new long[testDie.getNumberOfFaces()];
            boolean weighted = false;
            for (int i = 0; i < ROLL_TEST_COUNT; i++) {
                testDie.roll();
                tally[testDie.getFaceUpIndex()]++;
            }

            for (int i = 0; i < tally.length; i++) {
                double percentage = ((double)tally[i] / ((double)ROLL_TEST_COUNT / 100.0));
                System.out.println(i + ": " + percentage + "%");
                if (percentage - (100.0 / (double)testDie.getNumberOfFaces()) > 1.0
                        || percentage - (100.0 / (double)testDie.getNumberOfFaces()) < -1.0) {
                    weighted = true;
                }
            }
            displaySuccessIfTrue(!weighted);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4)};
            CombatDie testDie = new CombatDie(faceArray);

            long[] tally = new long[testDie.getNumberOfFaces()];
            boolean weighted = false;
            for (int i = 0; i < ROLL_TEST_COUNT; i++) {
                testDie.roll();
                tally[testDie.getFaceUpIndex()]++;
            }

            for (int i = 0; i < tally.length; i++) {
                double percentage = ((double)tally[i] / ((double)ROLL_TEST_COUNT / 100.0));
                System.out.println(i + ": " + percentage + "%");
                if (percentage - (100.0 / (double)testDie.getNumberOfFaces()) > 1.0
                        || percentage - (100.0 / (double)testDie.getNumberOfFaces()) < -1.0) {
                    weighted = true;
                }
            }
            displaySuccessIfTrue(!weighted);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie roll: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_SafeAndRiskyDieConstructors() {
        System.out.println("Testing SafeDie and RiskyDie constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie safeDie = new SafeDie();
            displaySuccessIfTrue(safeDie.getNumberOfFaces() == 6
                    && safeDie.getFaceUpIndex() >= 0
                    && safeDie.getFaceUpIndex() < 6);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie safeDie = new SafeDie();
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                    safeDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 3
                    && safeDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 2
                    && safeDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie riskyDie = new RiskyDie();
            displaySuccessIfTrue(riskyDie.getNumberOfFaces() == 8
                    && riskyDie.getFaceUpIndex() >= 0
                    && riskyDie.getFaceUpIndex() < 8);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie riskyDie = new RiskyDie();
            displaySuccessIfTrue(
                    riskyDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 3
                    && riskyDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 2
                    && riskyDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1
                    && riskyDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("SafeDie & RiskyDie constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }
}
