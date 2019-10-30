public class Factorial {

    public static BigInteger NthFactorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        if (n == 0) {
            return BigInteger.ONE;
        }
        for (int i = n; i > 0; i--) {
            factorial = factorial.product(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static void main (String[] args) {
        try {
            if (args.length == 1) {
                int n = Integer.parseInt(args[0]);
                if (n < 0) {
                    throw new IllegalArgumentException();
                }
                System.out.println(n + "! = " + NthFactorial(n).toString());
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("java Factorial <positive integer>");
        }
    }
}
