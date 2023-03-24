package RecursionBasics;

public class PrintNumInDecOrder {
    public static void main(String[] args) {
        printDec(10);
    }

    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }
}
