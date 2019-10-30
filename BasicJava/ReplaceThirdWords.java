// ReplaceThirdWords.java

public class ReplaceThirdWords {
    public static void main(String[] args) {
        int argsLength = args.length;
        for (int i = 0; i < argsLength; i++) {
            if ((i+1) % 3 == 0) {
            args[i] = "um";
            }
        }
        for (int i = 0; i < argsLength; i++) {
            System.out.print(args[i] + " ");
        }
        if (argsLength == 0) {
            System.out.println("No arguments found, enter a sentence with more than 3 words");
        }
    }
}
