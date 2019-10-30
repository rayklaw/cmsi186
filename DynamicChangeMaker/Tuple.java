public class Tuple {
    private int[] tuple;

    public Tuple (int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        tuple = new int[k];
        for (int i = 0; i <= tuple.length - 1; i++) {
            tuple[i] = 0;
        }
    }

    public Tuple (int[] data) {
        tuple = new int[data.length];
        for (int i = 0; i <= data.length - 1; i++) {
            tuple[i] = data[i];
        }
    }

    public static Tuple makeTupleFromData (int[] data) {
        return new Tuple(data);
    }

    public Tuple add (Tuple t) {
        int[] tupleArray;
        if (this.length() != t.length()) {
            throw new IllegalArgumentException();
        }
        tupleArray = new int[this.length()];
        for (int i = 0; i <= this.length() - 1; i++) {
            tupleArray[i] = this.tuple[i] + t.tuple[i];
        }
        return new Tuple(tupleArray);
    }

    public Tuple clone() {
        return new Tuple(this.tuple);
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

        Tuple other = (Tuple)x;

        return other.toString().equals(this.toString());
    }

    public int getElement (int i) {
        if (i < 0 || i > this.length() - 1) {
            throw new IllegalArgumentException();
        }
        return this.tuple[i];
    }

    public void setElement (int i, int value) {
        if (i < 0 || i > this.length() - 1) {
            throw new IllegalArgumentException();
        }
        this.tuple[i] = value;
    }

    public int length() {
        return this.tuple.length;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i <= this.length() - 1; i++) {
            sum = sum + this.tuple[i];
        }
        return sum;
    }

    public String toString() {
        String tupleString = "[";
        for (int i = 0; i <= this.length() - 1; i++) {
            tupleString = tupleString + this.tuple[i] + "";
            if (i < this.length() - 1) {
                tupleString = tupleString + ",";
            }
        }
        tupleString = tupleString + "]";
        return tupleString;
    }
}
