// SumOfAbsolutes.java

public class SumOfAbsolutes {
    public static void main(String[] args) {
        try {
            int argsLength = args.length;
            int sum = 0;
            if (argsLength == 0) {
                System.out.println("No argument provided, input any amount of positive or negative integers as arguments");
            } else if (argsLength > 0) {
                for (int i = 0; i <= (argsLength - 1); i++) {
                    sum += Math.abs(Integer.parseInt(args[i]));
                }
            System.out.println(sum);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Please only insert negative or positive integers");
        }
    }
}
