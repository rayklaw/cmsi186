public class DynamicChangeMakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        test_IMPOSSIBLE();
        test_Euros();
        test_SwissFrancs();
        test_Oofs();
        test_THROWERROR();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_USA() {
        System.out.println("\nTests for USA denominations {25,10,5,1}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominations, 99);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 3 == usaTest.getSolution().getElement(0)
                    && 2 == usaTest.getSolution().getElement(1)
                    && 0 == usaTest.getSolution().getElement(2)
                    && 4 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominations, 25);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 1 == usaTest.getSolution().getElement(0)
                    && 0 == usaTest.getSolution().getElement(1)
                    && 0 == usaTest.getSolution().getElement(2)
                    && 0 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominations, 49);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 1 == usaTest.getSolution().getElement(0)
                    && 2 == usaTest.getSolution().getElement(1)
                    && 0 == usaTest.getSolution().getElement(2)
                    && 4 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] usaDenominationsShuffled = new int[] { 5, 1, 25, 10 };

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominationsShuffled, 99);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 0 == usaTest.getSolution().getElement(0)
                    && 4 == usaTest.getSolution().getElement(1)
                    && 3 == usaTest.getSolution().getElement(2)
                    && 2 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominationsShuffled, 49);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 0 == usaTest.getSolution().getElement(0)
                    && 4 == usaTest.getSolution().getElement(1)
                    && 1 == usaTest.getSolution().getElement(2)
                    && 2 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominationsShuffled, 30);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 1 == usaTest.getSolution().getElement(0)
                    && 0 == usaTest.getSolution().getElement(1)
                    && 1 == usaTest.getSolution().getElement(2)
                    && 0 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        System.out.println("\nUSA denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_Euros() {
        System.out.println("\nTests for Euro denominations {1,2,5,10,20,50}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] euroDenominations = new int[] { 1, 2, 5, 10, 20, 50 };

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominations, 99);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 2 == euroTest.getSolution().getElement(1)
                    && 1 == euroTest.getSolution().getElement(2)
                    && 0 == euroTest.getSolution().getElement(3)
                    && 2 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominations, 124);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 2 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 0 == euroTest.getSolution().getElement(3)
                    && 1 == euroTest.getSolution().getElement(4)
                    && 2 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominations, 69);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 2 == euroTest.getSolution().getElement(1)
                    && 1 == euroTest.getSolution().getElement(2)
                    && 1 == euroTest.getSolution().getElement(3)
                    && 0 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] euroDenominationsShuffled = new int[] { 2, 50, 5, 10, 20, 1 };

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominationsShuffled, 63);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 1 == euroTest.getSolution().getElement(0)
                    && 1 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 1 == euroTest.getSolution().getElement(3)
                    && 0 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominationsShuffled, 113);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 1 == euroTest.getSolution().getElement(0)
                    && 2 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 1 == euroTest.getSolution().getElement(3)
                    && 0 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        System.out.println("\nEuro denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_SwissFrancs() {
        System.out.println("\nTests for SwissFrancs denominations {5,10,20,50}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] SwissFrancsDenominations = new int[] { 5, 10, 20, 50 };

        try {
            DynamicChangeMaker SwissFrancsTest = new DynamicChangeMaker(SwissFrancsDenominations, 95);
            SwissFrancsTest.solveTable();
            displaySuccessIfTrue(SwissFrancsTest.getSolution().length() == 4
                    && 1 == SwissFrancsTest.getSolution().getElement(0)
                    && 0 == SwissFrancsTest.getSolution().getElement(1)
                    && 2 == SwissFrancsTest.getSolution().getElement(2)
                    && 1 == SwissFrancsTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker SwissFrancsTest = new DynamicChangeMaker(SwissFrancsDenominations, 99);
            SwissFrancsTest.solveTable();
            displaySuccessIfTrue(DynamicChangeMaker.isImpossible(SwissFrancsTest.getSolution()));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker SwissFrancsTest = new DynamicChangeMaker(SwissFrancsDenominations, 25);
            SwissFrancsTest.solveTable();
            displaySuccessIfTrue(SwissFrancsTest.getSolution().length() == 4
                    && 1 == SwissFrancsTest.getSolution().getElement(0)
                    && 0 == SwissFrancsTest.getSolution().getElement(1)
                    && 1 == SwissFrancsTest.getSolution().getElement(2)
                    && 0 == SwissFrancsTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker SwissFrancsTest = new DynamicChangeMaker(SwissFrancsDenominations, 165);
            SwissFrancsTest.solveTable();
            displaySuccessIfTrue(SwissFrancsTest.getSolution().length() == 4
                    && 1 == SwissFrancsTest.getSolution().getElement(0)
                    && 1 == SwissFrancsTest.getSolution().getElement(1)
                    && 0 == SwissFrancsTest.getSolution().getElement(2)
                    && 3 == SwissFrancsTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] SwissFrancsDenominationsShuffled = new int[] { 50, 5, 20, 10 };

        try {
            DynamicChangeMaker SwissFrancsTest = new DynamicChangeMaker(SwissFrancsDenominationsShuffled, 120);
            SwissFrancsTest.solveTable();
            displaySuccessIfTrue(SwissFrancsTest.getSolution().length() == 4
                    && 2 == SwissFrancsTest.getSolution().getElement(0)
                    && 0 == SwissFrancsTest.getSolution().getElement(1)
                    && 1 == SwissFrancsTest.getSolution().getElement(2)
                    && 0 == SwissFrancsTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker SwissFrancsTest = new DynamicChangeMaker(SwissFrancsDenominationsShuffled, 85);
            SwissFrancsTest.solveTable();
            displaySuccessIfTrue(SwissFrancsTest.getSolution().length() == 4
                    && 1 == SwissFrancsTest.getSolution().getElement(0)
                    && 1 == SwissFrancsTest.getSolution().getElement(1)
                    && 1 == SwissFrancsTest.getSolution().getElement(2)
                    && 1 == SwissFrancsTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker SwissFrancsTest = new DynamicChangeMaker(SwissFrancsDenominationsShuffled, 25);
            SwissFrancsTest.solveTable();
            displaySuccessIfTrue(SwissFrancsTest.getSolution().length() == 4
                    && 0 == SwissFrancsTest.getSolution().getElement(0)
                    && 1 == SwissFrancsTest.getSolution().getElement(1)
                    && 1 == SwissFrancsTest.getSolution().getElement(2)
                    && 0 == SwissFrancsTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        System.out.println("\nSwissFrancs denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_Oofs() {
        System.out.println("\nTests for Oofs denominations {7,12,17,20}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] oofDenominations = new int[] { 7, 12, 17, 22 };

        try {
            DynamicChangeMaker oofTest = new DynamicChangeMaker(oofDenominations, 6);
            oofTest.solveTable();
            displaySuccessIfTrue(DynamicChangeMaker.isImpossible(oofTest.getSolution()));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker oofTest = new DynamicChangeMaker(oofDenominations, 121);
            oofTest.solveTable();
            displaySuccessIfTrue(oofTest.getSolution().length() == 4
                    && 3 == oofTest.getSolution().getElement(0)
                    && 1 == oofTest.getSolution().getElement(1)
                    && 0 == oofTest.getSolution().getElement(2)
                    && 4 == oofTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker oofTest = new DynamicChangeMaker(oofDenominations, 149);
            oofTest.solveTable();
            displaySuccessIfTrue(oofTest.getSolution().length() == 4
                    && 0 == oofTest.getSolution().getElement(0)
                    && 0 == oofTest.getSolution().getElement(1)
                    && 1 == oofTest.getSolution().getElement(2)
                    && 6 == oofTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] oofDenominationsShuffled = new int[] { 17, 7, 12, 22 };

        try {
            DynamicChangeMaker oofTest = new DynamicChangeMaker(oofDenominationsShuffled, 79);
            oofTest.solveTable();
            displaySuccessIfTrue(oofTest.getSolution().length() == 4
                    && 0 == oofTest.getSolution().getElement(0)
                    && 5 == oofTest.getSolution().getElement(1)
                    && 0 == oofTest.getSolution().getElement(2)
                    && 2 == oofTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker oofTest = new DynamicChangeMaker(oofDenominationsShuffled, 49);
            oofTest.solveTable();
            displaySuccessIfTrue(oofTest.getSolution().length() == 4
                    && 0 == oofTest.getSolution().getElement(0)
                    && 7 == oofTest.getSolution().getElement(1)
                    && 0 == oofTest.getSolution().getElement(2)
                    && 0 == oofTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker oofTest = new DynamicChangeMaker(oofDenominationsShuffled, 65);
            oofTest.solveTable();
            displaySuccessIfTrue(oofTest.getSolution().length() == 4
                    && 0 == oofTest.getSolution().getElement(0)
                    && 3 == oofTest.getSolution().getElement(1)
                    && 0 == oofTest.getSolution().getElement(2)
                    && 2 == oofTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        System.out.println("\noof denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }


        public static void test_IMPOSSIBLE() {
            System.out.println("\nTests for IMPOSSIBLE denominations {3, 13, 17}:\n");

            int initialSuccesses = successes;
            int initialAttempts = attempts;

            int[] impossibleDenominations = new int[] { 3, 13, 17 };

            try {
                DynamicChangeMaker impossibleTest = new DynamicChangeMaker(impossibleDenominations, 14);
                impossibleTest.solveTable();
                displaySuccessIfTrue(impossibleTest.getSolution().length() == 0
                        && DynamicChangeMaker.IMPOSSIBLE.equals(impossibleTest.getSolution()));
            } catch (Exception e) {
                e.printStackTrace();
                displayFailure();
            }

            try {
                DynamicChangeMaker impossibleTest = new DynamicChangeMaker(impossibleDenominations, 2);
                impossibleTest.solveTable();
                displaySuccessIfTrue(impossibleTest.getSolution().length() == 0
                        && DynamicChangeMaker.IMPOSSIBLE.equals(impossibleTest.getSolution()));
            } catch (Exception e) {
                e.printStackTrace();
                displayFailure();
            }

            System.out.println("\nTests for IMPOSSIBLE denominations {2, 4, 6}:\n");

            impossibleDenominations = new int[] { 2, 4, 6 };

            try {
                DynamicChangeMaker impossibleTest = new DynamicChangeMaker(impossibleDenominations, 1);
                impossibleTest.solveTable();
                displaySuccessIfTrue(impossibleTest.getSolution().length() == 0
                        && DynamicChangeMaker.IMPOSSIBLE.equals(impossibleTest.getSolution()));
            } catch (Exception e) {
                e.printStackTrace();
                displayFailure();
            }

            try {
                DynamicChangeMaker impossibleTest = new DynamicChangeMaker(impossibleDenominations, 99);
                impossibleTest.solveTable();
                displaySuccessIfTrue(impossibleTest.getSolution().length() == 0
                        && DynamicChangeMaker.IMPOSSIBLE.equals(impossibleTest.getSolution()));
            } catch (Exception e) {
                e.printStackTrace();
                displayFailure();
            }

        System.out.println("\nIMPOSSIBLE denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    public static void test_THROWERROR() {
        System.out.println("\nTests for THROWERROR:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] errorInput = new int[] {0, 1, 2, 3, 5};

        try {
            DynamicChangeMaker x = new DynamicChangeMaker(errorInput, 5);
            displayFailure();
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        }

        errorInput = new int[] {1, 1, 2, 2, 5};

        try {
            DynamicChangeMaker x = new DynamicChangeMaker(errorInput, 5);
            displayFailure();
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        }

        errorInput = new int[] {1, 5, 10, -25, -10};

        try {
            DynamicChangeMaker x = new DynamicChangeMaker(errorInput, 5);
            displayFailure();
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        }


        int[] input = new int[] {1, 5, 10, 25};

        try {
            DynamicChangeMaker x = new DynamicChangeMaker(input, -25);
            displayFailure();
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        }

        try {
            DynamicChangeMaker x = new DynamicChangeMaker(input, -100);
            displayFailure();
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        }


        System.out.println("\nTHROWERROR: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

}
