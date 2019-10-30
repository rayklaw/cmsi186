public class PiEstimator {
    public static final int RADIUS_OF_CIRCLE = 1;
    public static final int AREA_OF_SQUARE = 4;
    public static double[] dart = {0, 0};
    public static long dartsToThrow = 1000000;
    public static long dartsInCircle = 0;
    public static double piApproximation = 0.0;

    public static void generateDart() {
        dart[0] = Math.random() * 2 - 1;
        dart[1] = Math.random() * 2 - 1;
    }

    public static double distanceFormula(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static boolean inCircle(double x, double y) {
        return distanceFormula(x, y) <= RADIUS_OF_CIRCLE;
    }

    public static void tallyInCircle() {
        if (inCircle(dart[0], dart[1])) {
            dartsInCircle++;
        }
    }

    public static String printInOrOut() {
        return inCircle(dart[0], dart[1]) ? "in" : "out";
    }

    public static void estimatePi() {
        piApproximation = (double)dartsInCircle / (double)dartsToThrow * (double)AREA_OF_SQUARE;
    }

    private static void printUsage() {
        System.out.println("Usage: java PiEstimator <number (greater than 0) of darts to throw>");
    }

    public static void main(String[] args) {
        long dartsThrown = 0;

        try {
            if (args.length > 1) {
                throw new IllegalArgumentException();
            } else if (args.length == 1) {
                dartsToThrow = Integer.parseInt(args[0]);
                if (dartsToThrow <= 0) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (Exception e) {
             printUsage();
             return;
        }

        try {
            System.out.println("start");
            while (dartsThrown < dartsToThrow) {
                generateDart();
                tallyInCircle();
                System.out.println(dart[0] + " " + dart[1] + " " + printInOrOut());
                dartsThrown++;
            }
            System.out.println("end");
            estimatePi();
            System.out.println("Pi is approximately: " + piApproximation);
        } catch (Exception e) {
            printUsage();
            return;
        }
    }
 }
