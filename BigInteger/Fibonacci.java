public class Fibonacci {

    public static BigInteger fibonacciSequence(int n) {
        BigInteger fibonacci0 = BigInteger.ZERO;
        BigInteger fibonacci1 = BigInteger.ONE;
        BigInteger fibonacciN = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fibonacciN = fibonacci0.sum(fibonacci1);
            fibonacci0 = fibonacci1;
            fibonacci1 = fibonacciN;
        }
        return fibonacciN;
    }

    public static void main (String[] args) {
        try {
            if (args.length == 1) {
                int n = Integer.parseInt(args[0]);
                if (n < 0) {
                    throw new IllegalArgumentException();
                }
                 System.out.println("Nth Fibonacci Number: " + fibonacciSequence(n).toString());
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("java Fibonacci <positive integer>");
        }
    }
}
