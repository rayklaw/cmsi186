public class BigInteger {
    private int[] intArray;
    private boolean isNegative = false;

    public BigInteger (String val) {
        int[] tempIntArray;
        int valLength;

        try {
            double x = Double.parseDouble(val);
        } catch (Exception e) {
            throw new NumberFormatException();
        }
        val = val.trim();
        if (val.charAt(0) == '-') {
            isNegative = true;
            val = val.substring(1);
        }
        if (val.charAt(0) == '+') {
            val = val.substring(1);
        }
        valLength = val.length();
        for (int i = 0; i <= valLength - 1; i++) {
            if (val.charAt(0) == '0') {
                val = val.substring(1);
            }
        }
        tempIntArray = new int[val.length()];
        for (int i = 0; i <= val.length() - 1; i++) {
            tempIntArray[i] = Character.getNumericValue(val.charAt(i));
        }
        intArray = new int[val.length()];
        for (int i = 0; i <= tempIntArray.length - 1; i++) {
            intArray[tempIntArray.length - 1 - i] = tempIntArray[i];
        }
        if (intArray.length == 0) {
            intArray = new int[1];
            intArray[0] = 0;
        }
    }

    public String toString () {
        String digitString = "";
        for (int i = 0; i <= this.intArray.length - 1; i++) {
            digitString = digitString + this.intArray[this.intArray.length - 1 - i];
        }
        return isNegative ? '-' + digitString : digitString;
    }

    public BigInteger sum (BigInteger val) {
        int longerIntArray = this.intArray.length > val.intArray.length ? this.intArray.length : val.intArray.length;
        int[] carryOverArray = new int[longerIntArray + 1];
        int[] sumArray = new int[longerIntArray + 1];
        int[] extendedValArray = new int[longerIntArray + 1];
        int[] extendedThisArray = new int[longerIntArray + 1];
        String numberString = "";

        if (this.isNegative && !val.isNegative) {
            this.isNegative = false;
            return val.difference(this);
        }
        if (!this.isNegative && val.isNegative) {
            val.isNegative = false;
            return this.difference(val);
        }
        for (int i = 0; i <= this.intArray.length - 1; i++) {
            extendedThisArray[i] = this.intArray[i];
        }
        for (int i = this.intArray.length; i <= extendedThisArray.length - 1; i++) {
            extendedThisArray[i] = 0;
        }
        for (int i = 0; i <= val.intArray.length - 1; i++) {
            extendedValArray[i] = val.intArray[i];
        }
        for (int i = val.intArray.length; i <= extendedValArray.length - 1; i++) {
            extendedValArray[i] = 0;
        }
        for (int i = 0; i <= carryOverArray.length - 1; i++) {
            carryOverArray[i] = 0;
        }
        for (int i = 0; i <= sumArray.length - 1; i++) {
            sumArray[i] = extendedThisArray[i] + extendedValArray[i] + carryOverArray[i];
            if (sumArray[i] > 9) {
                sumArray[i] = sumArray[i] - 10;
                carryOverArray[i + 1] = 1;
            }
        }
        for (int i = 0; i <= sumArray.length - 1; i++) {
            numberString = numberString + sumArray[sumArray.length - 1 - i];
        }
        if (this.isNegative && val.isNegative) {
            numberString = '-' + numberString;
        }
        return new BigInteger(numberString);
    }

    public BigInteger difference (BigInteger val) {
        int longerIntArray = this.intArray.length > val.intArray.length ? this.intArray.length : val.intArray.length;
        int[] differenceArray = new int[longerIntArray];
        int[] extendedMinuendArray = new int[longerIntArray];
        int[] extendedSubtrahendArray = new int[longerIntArray];
        String numberString = "";
        BigInteger tempBigInteger;
        BigInteger minuend = this;
        BigInteger subtrahend = val;

        if (minuend.isNegative && !subtrahend.isNegative) {
            subtrahend.isNegative = true;
            return minuend.sum(subtrahend);
        }
        if (!minuend.isNegative && subtrahend.isNegative || minuend.isNegative && subtrahend.isNegative) {
            subtrahend.isNegative = false;
            return minuend.sum(subtrahend);
        }
        if (subtrahend.compareWith(minuend) == 1) {
            tempBigInteger = minuend;
            minuend = subtrahend;
            subtrahend = tempBigInteger;
            numberString = "-";
        }
        for (int i = 0; i <= minuend.intArray.length - 1; i++) {
            extendedMinuendArray[i] = minuend.intArray[i];
        }
        for (int i = minuend.intArray.length; i <= extendedMinuendArray.length - 1; i++) {
            extendedMinuendArray[i] = 0;
        }
        for (int i = 0; i <= subtrahend.intArray.length - 1; i++) {
            extendedSubtrahendArray[i] = subtrahend.intArray[i];
        }
        for (int i = subtrahend.intArray.length; i <= extendedSubtrahendArray.length - 1; i++) {
            extendedSubtrahendArray[i] = 0;
        }
        for (int i = 0; i <= differenceArray.length - 1; i++) {
            if (extendedMinuendArray[i] >= extendedSubtrahendArray[i]) {
                differenceArray[i] = extendedMinuendArray[i] - extendedSubtrahendArray[i];
            } else {
                extendedMinuendArray[i+1] = extendedMinuendArray[i+1] - 1;
                extendedMinuendArray[i] = extendedMinuendArray[i] + 10;
                differenceArray[i] = extendedMinuendArray[i] - extendedSubtrahendArray[i];
            }
        }
        for (int i = 0; i <= differenceArray.length - 1; i++) {
            numberString = numberString + differenceArray[differenceArray.length - 1 - i];
        }
        return new BigInteger(numberString);
    }

    public BigInteger product (BigInteger val) {
        int negativeCount = 0;
        BigInteger product = ZERO;

        if (val.isNegative) {
            negativeCount++;
            val.isNegative = false;
        }
        if (this.isNegative) {
            negativeCount++;
            this.isNegative = false;
        }
        for (BigInteger i = ZERO; i.compareWith(val) == -1; i = i.sum(ONE)) {
            product = product.sum(this);
        }
        if (negativeCount == 0 || negativeCount == 2) {
            return product;
        } else {
            product.isNegative = true;
            return product;
        }
    }

    public BigInteger quotient (BigInteger val) {
        throw new UnsupportedOperationException();
    }

    public BigInteger remainder (BigInteger val) {
        throw new UnsupportedOperationException();
    }

    public int compareWith (BigInteger val) {
        if (this.isNegative == true && val.isNegative == false) {
            return -1;
        } else if (this.isNegative == false && val.isNegative == true) {
            return 1;
        }
        if (this.isNegative == true && this.isNegative == true) {
            if (this.intArray.length < val.intArray.length) {
                return 1;
            } else if (this.intArray.length > val.intArray.length) {
                return -1;
            }
            if (this.intArray.length == val.intArray.length) {
                for (int i = val.intArray.length - 1; i >= 0; i--) {
                    if (val.intArray[i] > this.intArray[i]) {
                        return 1;
                    } else if (this.intArray[i] > val.intArray[i]) {
                        return -1;
                    }
                }
            }
        }
        if (this.isNegative == false && this.isNegative == false) {
            if (this.intArray.length > val.intArray.length) {
                return 1;
            } else if (this.intArray.length < val.intArray.length) {
                return -1;
            }
            if (this.intArray.length == val.intArray.length) {
                for (int i = val.intArray.length - 1; i >= 0; i--) {
                    if (val.intArray[i] < this.intArray[i]) {
                        return 1;
                    } else if (this.intArray[i] < val.intArray[i]) {
                        return -1;
                    }
                }
            }
        }
        if (this.equals(val)) {
            return 0;
        }
        return 0;
    }

    public boolean equals (Object x) {
        if (this == x) {
            return true;
        }

        if (x == null) {
            return false;
        }
        if (getClass() != x.getClass()) {
            return false;
        }

        BigInteger other = (BigInteger)x;

        return other.toString().equals(this.toString());
    }

    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");
    public static final BigInteger TEN = new BigInteger("10");

    public static BigInteger valueOf (long val) {
        String valString = Long.toString(val);
        return new BigInteger(valString);
    }
}
