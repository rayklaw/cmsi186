public class ClockSolverLine {

    public static final double ANGLE_CHANGE_PER_SECOND = 5.5/60;
    public static final double SECONDS_PER_MINUTE = 60.0;
    public static final int MINUTES_PER_HOUR = 60;
    public static final double TOTAL_DEGREES_IN_CIRCLE = 360.0;
    private static Clock clock;
    private static final double angleOfLine = 180.0;

    public static void incrementAngle() {
        clock.setAngleDifference(clock.getAngleDifference() + ANGLE_CHANGE_PER_SECOND * clock.getTimeslice());
        if (clock.getAngleDifference() >= TOTAL_DEGREES_IN_CIRCLE) {
            clock.setAngleDifference(clock.getAngleDifference() % TOTAL_DEGREES_IN_CIRCLE);
        }
    }

    public static boolean reportConditionsMet() {
        return ((angleOfLine - ANGLE_CHANGE_PER_SECOND * clock.getTimeslice() / 2) < clock.getAngleDifference()) && (clock.getAngleDifference() < (angleOfLine + ANGLE_CHANGE_PER_SECOND * clock.getTimeslice() / 2));
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
            if (args.length == 0) {
                clock = new Clock();
            } else if (args.length == 1) {
                double timesliceImput = Double.parseDouble(args[0]);
                clock = new Clock(timesliceImput);
            } else {
                throw new IllegalArgumentException();
            }
            simulateTime();
        } catch (Exception e) {
            System.out.println("Usage Instructions:" + "\nClockSolverLine *no arguments (default timeslice 60.0 seconds)*" +
                "\nClockSolverLine <desired timeSlice between 0 and 1800>");
        }
    }
}
