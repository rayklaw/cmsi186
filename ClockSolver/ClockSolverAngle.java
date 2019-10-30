public class ClockSolverAngle {

    public static final double ANGLE_CHANGE_PER_SECOND = 5.5/60;
    public static final double SECONDS_PER_MINUTE = 60.0;
    public static final int MINUTES_PER_HOUR = 60;
    public static final double TOTAL_DEGREES_IN_CIRCLE = 360.0;
    private static Clock clock;
    private static double desiredAngle;

    public static void incrementAngle() {
        clock.setAngleDifference(clock.getAngleDifference() + ANGLE_CHANGE_PER_SECOND * clock.getTimeslice());
        if (clock.getAngleDifference() >= TOTAL_DEGREES_IN_CIRCLE) {
            clock.setAngleDifference(clock.getAngleDifference() % TOTAL_DEGREES_IN_CIRCLE);
        }
    }

    public static boolean reportConditionsMet() {
        return (desiredAngle - ANGLE_CHANGE_PER_SECOND * clock.getTimeslice() / 2) < clock.getAngleDifference() &&
            clock.getAngleDifference() < (desiredAngle + ANGLE_CHANGE_PER_SECOND * clock.getTimeslice() / 2) ||
            (desiredAngle - ANGLE_CHANGE_PER_SECOND * clock.getTimeslice() / 2) < clock.getComplementaryAngle() &&
            clock.getComplementaryAngle() < (desiredAngle + ANGLE_CHANGE_PER_SECOND * clock.getTimeslice() / 2);
    }

    public static void report() {
        if (reportConditionsMet()) {
            System.out.println(clock.toString());
        }
    }

    public static void simulateTime() {
        while (clock.getHoursPassed() < 12) {
            clock.tick();
            incrementAngle();
            report();
        }
    }

    public static void main (String[] args) {
        try {
            if (args.length == 1) {
                clock = new Clock();
                desiredAngle = Double.parseDouble(args[0]);
            } else if (args.length == 2) {
                clock = new Clock(Double.parseDouble(args[1]));
                desiredAngle = Double.parseDouble(args[0]);
                if (desiredAngle < 0 || desiredAngle > 360) {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IllegalArgumentException();
            }
            simulateTime();
        } catch (Exception e) {
            System.out.println("Usage Instructions:" + "\nClockSolverAngle <Desired Angle in Degrees between 0 and 360>" +
                "\nClockSolverAngle <Desired Angle in Degrees between 0 and 360> <Desired TimeSlice in seconds between 0 and 1800>");
        }
    }
}

