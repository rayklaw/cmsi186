public class DynamicChangeMaker {
    public static final Tuple IMPOSSIBLE = new Tuple(0);
    public static int changeWanted;
    public static int[] coinDenominations;
    public static Tuple[][] table;

    public DynamicChangeMaker(int[] denominations, int wantedChange) {
        for (int i = 0; i <= denominations.length - 1; i++) {
            for (int j = i + 1; j <= denominations.length - 1; j++) {
                if (denominations[i] == denominations[j] || denominations[i] < 1) {
                    throw new IllegalArgumentException();
                }
            }
        }
        if (wantedChange < 0) {
            throw new IllegalArgumentException();
        }
        changeWanted = wantedChange;
        coinDenominations = new int[denominations.length];
        for (int i = 0; i <= denominations.length - 1; i++) {
            coinDenominations[i] = denominations[i];
        }
        table = new Tuple[denominations.length][wantedChange + 1];
    }

    public static boolean isImpossible(Tuple tuple) {
        return tuple.equals(IMPOSSIBLE);
    }

    public void solveTable() {
        for (int row = 0; row <= table.length - 1; row++) {
            for (int column = 0; column <= table[row].length - 1; column++) {
                table[row][column] = new Tuple(coinDenominations.length);
                if (column > 0) {
                    if (column - coinDenominations[row] >= 0) {
                        table[row][column].setElement(row, 1);
                        if (!isImpossible(table[row][column - coinDenominations[row]])) {
                            table[row][column] = table[row][column].add(table[row][column - coinDenominations[row]]);
                        } else {
                            table[row][column] = IMPOSSIBLE;
                        }
                    } else if (column - coinDenominations[row] < 0) {
                        table[row][column] = IMPOSSIBLE;
                    }
                }
                if (row > 0) {
                    if (isImpossible(table[row][column])) {
                        table[row][column] = table[row-1][column];
                    } else if (table[row][column].sum() > table[row-1][column].sum() && !isImpossible(table[row-1][column])) {
                        table[row][column] = table[row-1][column];
                    }
                }
            }
        }
    }

    public Tuple getSolution() {
        return table[coinDenominations.length - 1][changeWanted];
    }

    public static void main (String args[]) {
        int[] denominationsInput;
        int wantedChangeInput;
        DynamicChangeMaker scenario;

        try {

            if (args.length < 2) {
                throw new IllegalArgumentException();
            }
            denominationsInput = new int[args.length - 1];
            wantedChangeInput = Integer.parseInt(args[args.length - 1]);
            for (int i = 0; i <= args.length - 2; i++) {
                denominationsInput[i] = Integer.parseInt(args[i]);
            }
            scenario = new DynamicChangeMaker(denominationsInput, wantedChangeInput);
            scenario.solveTable();
            if (isImpossible(scenario.getSolution())) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            for (int i = 0; i <= args.length - 2; i++) {
                System.out.println(scenario.getSolution().getElement(i) + " " + coinDenominations[i] + "-cent coins");
            }
            System.out.println("Total Coins: " + scenario.getSolution().sum());

        } catch (Exception e) {
            System.out.println("java DynamicChangeMaker <coin denomination one> ... <coin denomination N> <wanted change>"
                + "\n- Where coin denominations and wanted change are POSITIVE INTEGERS"
                + "\n- Where there are no duplicate coin denominations");
        }
    }
}
