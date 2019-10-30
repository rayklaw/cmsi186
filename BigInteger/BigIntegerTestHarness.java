public class BigIntegerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        // Feel free to add more cases to these.
        test_constructor();
        test_toString();
        test_constants();
        test_equals();
        test_sum();
        test_compareWith();
        test_difference();
        test_product();
        test_integerQuotient();
        test_remainder();
        test_valueOf();

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

    private static void test_constructor() {
        System.out.println("Testing constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue("1".equals(new BigInteger("1 ").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("1".equals(new BigInteger("  +1").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-1".equals(new BigInteger("-1  ").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInteger("0").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("314159265358979323846264338327950288"
                    .equals(new BigInteger("314159265358979323846264338327950288").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("314159265358979323846264338327950288"
                    .equals(new BigInteger("+314159265358979323846264338327950288").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-314159265358979323846264338327950288"
                    .equals(new BigInteger("-314159265358979323846264338327950288").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            new BigInteger("a");
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

        System.out.println("constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_toString() {
        System.out.println("Testing toString...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue("9234013274012419836418634983459547689126439817263478157836453178654"
                    .equals(new BigInteger("9234013274012419836418634983459547689126439817263478157836453178654").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("123456789123456789"
                    .equals(new BigInteger("123456789123456789").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("123456789123456789"
                    .equals(new BigInteger("000123456789123456789").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("toString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_equals() {
        System.out.println("Testing equals...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("123456789123456789")
                    .equals(new BigInteger("123456789123456789")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new BigInteger("123456789123456789")
                    .equals(new BigInteger("333"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new BigInteger("123456789123456789")
                    .equals(new BigInteger("-123456789123456789"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("123456789123456789")
                    .equals(new BigInteger("000123456789123456789")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("equals: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_constants() {
        System.out.println("Testing ZERO, ONE, and TEN constants...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(BigInteger.ZERO.equals(new BigInteger("0")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInteger.ONE.equals(new BigInteger("1")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInteger.TEN.equals(new BigInteger("10")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("constants: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_compareWith() {
        System.out.println("Testing compareWith...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            BigInteger x;
            x = new BigInteger("9");
            displaySuccessIfTrue(-1 == x.compareWith(new BigInteger("10")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("10");
            displaySuccessIfTrue(1 == x.compareWith(new BigInteger("9")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("10");
            displaySuccessIfTrue(0 == x.compareWith(new BigInteger("10")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("-10");
            displaySuccessIfTrue(-1 == x.compareWith(new BigInteger("1")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("10");
            displaySuccessIfTrue(1 == x.compareWith(new BigInteger("-10")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("-10");
            displaySuccessIfTrue(0 == x.compareWith(new BigInteger("-10")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("123456789");
            displaySuccessIfTrue(-1 == x.compareWith(new BigInteger("123456790")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("123456789");
            displaySuccessIfTrue(1 == x.compareWith(new BigInteger("123456788")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("-123456789");
            displaySuccessIfTrue(-1 == x.compareWith(new BigInteger("-123456788")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x;
            x = new BigInteger("-123456789");
            displaySuccessIfTrue(1 == x.compareWith(new BigInteger("-123456790")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("compareWith: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_sum() {
        System.out.println("Testing sum...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("0").sum(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("0").sum(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("1").sum(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("2").equals(new BigInteger("1").sum(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(new BigInteger("1").sum(new BigInteger("999"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(new BigInteger("123").sum(new BigInteger("877"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-999").equals(new BigInteger("-123").sum(new BigInteger("-876"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("-123").sum(new BigInteger("-877"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("-1").sum(new BigInteger("+1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("+1").sum(new BigInteger("-1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("-1").sum(new BigInteger("+11"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("+12").sum(new BigInteger("-2"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x = new BigInteger("+12354");
            displaySuccessIfTrue(new BigInteger("24708").equals(x.sum(x)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue((new java.math.BigInteger("123456789123456789")).toString()
                    .equals(new BigInteger("123456789123456789").sum(new BigInteger("0")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInteger("123456789123456789")
                    .sum(new BigInteger("-123456789123456789")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("2934097831972391728347612783641927841983569834695")
                    .add(new java.math.BigInteger("9234013274012419836418634983459547689126439817263478157836453178654"));
            displaySuccessIfTrue(expected.toString().equals(new BigInteger("2934097831972391728347612783641927841983569834695")
                    .sum(new BigInteger("9234013274012419836418634983459547689126439817263478157836453178654")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("000123456789123456789")
                    .add(new java.math.BigInteger("000123456789123456789"));
            displaySuccessIfTrue(expected.toString().equals(new BigInteger("000123456789123456789")
                    .sum(new BigInteger("000123456789123456789")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("+3000").sum(new BigInteger("-4000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("-4000").sum(new BigInteger("+3000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("888888888888888888")
                    .add(new java.math.BigInteger("-999999999999999999"));
            displaySuccessIfTrue(expected.toString().equals(new BigInteger("888888888888888888")
                    .sum(new BigInteger("-999999999999999999")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("sum: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_difference() {
        System.out.println("Testing difference...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("86742").equals(new BigInteger("1273981").difference(new BigInteger("1187239"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("0").difference(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("100").equals(new BigInteger("100").difference(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("999").equals(new BigInteger("1000").difference(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("11111").difference(new BigInteger("11110"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("300").equals(new BigInteger("1000").difference(new BigInteger("700"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("667").equals(new BigInteger("1000").difference(new BigInteger("333"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x = new BigInteger("12345");
            displaySuccessIfTrue(new BigInteger("0").equals(x.difference(x)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        try {
            displaySuccessIfTrue(new BigInteger("1200000000").equals(new BigInteger("1234567890").difference(new BigInteger("34567890"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("-12345").difference(new BigInteger("-12345"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        try {
            displaySuccessIfTrue(new BigInteger("-9000").equals(new BigInteger("1000").difference(new BigInteger("10000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-750908334").equals(new BigInteger("123456789").difference(new BigInteger("874365123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-700").equals(new BigInteger("-345").difference(new BigInteger("355"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("300").equals(new BigInteger("0").difference(new BigInteger("-300"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(new BigInteger("500").difference(new BigInteger("-500"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(new BigInteger("-1000").difference(new BigInteger("-2000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("10123123912831231231234123")
                    .subtract(new java.math.BigInteger("8989898"));
            displaySuccessIfTrue(expected.toString().equals((new BigInteger("10123123912831231231234123").difference(new BigInteger("8989898"))).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("difference: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_product () {
        System.out.println("Testing product...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("5").product(new BigInteger("2"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("5").equals(new BigInteger("1").product(new BigInteger("5"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("1").product(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("100000").product(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(new BigInteger("100").product(new BigInteger("10"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("11264").equals(new BigInteger("512").product(new BigInteger("22"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("5663497266").equals(new BigInteger("91919").product(new BigInteger("61614"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-81").equals(new BigInteger("9").product(new BigInteger("-9"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-7006652").equals(new BigInteger("1234").product(new BigInteger("-5678"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("69741").equals(new BigInteger("-567").product(new BigInteger("-123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("144").equals(new BigInteger("-12").product(new BigInteger("-12"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("99999999").multiply(new java.math.BigInteger("8989898"));
            displaySuccessIfTrue(expected.toString().equals((new BigInteger("99999999").product(new BigInteger("8989898"))).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("product: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_integerQuotient () {
        System.out.println("Testing quotient...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("9").equals(new BigInteger("81").quotient(new BigInteger("9"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("10").quotient(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("512").equals(new BigInteger("2048").quotient(new BigInteger("4"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("0").quotient(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("0").quotient(new BigInteger("3456789"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-512").equals(new BigInteger("2048").quotient(new BigInteger("-4"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-512").equals(new BigInteger("-2048").quotient(new BigInteger("4"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("37147").equals(new BigInteger("646840711").quotient(new BigInteger("17413"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-37147").equals(new BigInteger("-646840711").quotient(new BigInteger("17413"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-37147").equals(new BigInteger("646840711").quotient(new BigInteger("-17413"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("37147").equals(new BigInteger("-646840711").quotient(new BigInteger("-17413"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("9999999999").divide(new java.math.BigInteger("8989898"));
            displaySuccessIfTrue(expected.toString().equals((new BigInteger("9999999999").quotient(new BigInteger("8989898"))).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("quotient: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_remainder () {
        System.out.println("Testing remainder...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("9").remainder(new BigInteger("2"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("0").remainder(new BigInteger("9"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("25").remainder(new BigInteger("3"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(new BigInteger("6").equals(new BigInteger("6").remainder(new BigInteger("7"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("123123").equals(new BigInteger("123123").remainder(new BigInteger("1234567"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("3337").equals(new BigInteger("1234567").remainder(new BigInteger("123123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-119789").equals(new BigInteger("1234567").remainder(new BigInteger("-123123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("119789").equals(new BigInteger("-1234567").remainder(new BigInteger("123123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-3337").equals(new BigInteger("-1234567").remainder(new BigInteger("-123123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("3337").equals(new BigInteger("1234567").remainder(new BigInteger("123123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1111444").equals(new BigInteger("-123123").remainder(new BigInteger("1234567"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1111444").equals(new BigInteger("123123").remainder(new BigInteger("-1234567"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-123123").equals(new BigInteger("-123123").remainder(new BigInteger("-1234567"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("9999999999").remainder(new java.math.BigInteger("1238123"));
            displaySuccessIfTrue(expected.toString().equals((new BigInteger("9999999999").remainder(new BigInteger("1238123"))).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("remainder: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_valueOf () {
        System.out.println("Testing valueOf...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(BigInteger.valueOf(1000)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(BigInteger.valueOf(1)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(BigInteger.valueOf(0)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-19823719").equals(BigInteger.valueOf(-19823719)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("19823719").equals(BigInteger.valueOf(19823719)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("valueOf: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }
}
