// CountMultiplesBelow.java

public class CountMultiplesBelow {
    public static void main(String[] args) {
        try {
            int maxInteger = Integer.parseInt(args[1]);
            int startingInteger = Integer.parseInt(args[0]);
            int argsLength = args.length;
            if (startingInteger == 0) {
                System.out.println("Enter a starting integer that isn't 0!");
            } else if (maxInteger < 0) {
                System.out.println("Max integer is a negative number");
            } else if (maxInteger <= startingInteger) {
                System.out.println("Starting integer is less than or equal to max integer");
            } else {
                for (int i = 1; (Math.abs(startingInteger) * i) < maxInteger; i++) {
                    System.out.println(Math.abs(startingInteger) * i);
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Please only input integers");
        } catch (ArrayIndexOutOfBoundsException aibe) {
            System.out.println("Less than 2 arguments found, input 2 integers where the first argument is less than the second");
        }
    }
}
