public class Clock {

    public static final double DEFAULT_TIMESLICE = 60.0;
    public static final double SECONDS_PER_MINUTE = 60.0;
    public static final int MINUTES_PER_HOUR = 60;
    public static final double TOTAL_DEGREES_IN_CIRCLE = 360.0;
    private int hours;
    private int minutes;
    private double seconds;
    private double angleDifference;
    private double timeslice;
    private String secondString;
    private String minuteString;
    private String hourString;

    public Clock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        angleDifference = 0;
        timeslice = DEFAULT_TIMESLICE;
    }

    public Clock(double timesliceInput) {
        hours = 0;
        minutes = 0;
        seconds = 0;
        angleDifference = 0;
        timeslice = timesliceInput;

        if (timeslice > 1800 || timeslice <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getHoursPassed() {
        return this.hours;
    }

    public int getMinutesPassed() {
        return this.minutes;
    }

    public double getSecondsPassed() {
        return this.seconds;
    }

    public double getTimeslice() {
        return this.timeslice;
    }

    public double getAngleDifference() {
        return this.angleDifference;
    }

    public void setAngleDifference(double angle) {
        this.angleDifference = angle;
    }

    public double getComplementaryAngle() {
        return TOTAL_DEGREES_IN_CIRCLE - this.angleDifference;
    }

    public void tick() {
        this.seconds += this.timeslice;
        if (this.seconds >= SECONDS_PER_MINUTE) {
            this.minutes += (int)Math.floor(this.seconds / SECONDS_PER_MINUTE);
            this.seconds = this.seconds % SECONDS_PER_MINUTE;
        }
        if (this.minutes >= MINUTES_PER_HOUR) {
            this.hours += Math.floor(this.minutes / MINUTES_PER_HOUR);
            this.minutes = this.minutes % MINUTES_PER_HOUR;
        }
    }

    public void greaterThanTen() {
        secondString = (this.seconds < 10) ? "0" + this.seconds : Double.toString(this.seconds);
        minuteString = (this.minutes < 10) ? "0" + this.minutes : Integer.toString(this.minutes);
        hourString = (this.hours < 10) ? "0" + this.hours : Integer.toString(this.hours);
    }

    public String toString() {
        this.greaterThanTen();
        return hourString + ":" + minuteString + ":" + secondString;
    }
}

