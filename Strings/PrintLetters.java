package Strings;

public class PrintLetters {
    public static void main(String[] args) {
        printLetters("lallantop");
    }

    // PRINT LETTERS
    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

}
