package RecursionBasics;

public class PrintNumInIncOrder {
    public static void main(String[] args) {
        printInc(10);
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n+" ");
            return;
        }
        printInc(n - 1);
        System.out.print(n+" ");
    }
}
