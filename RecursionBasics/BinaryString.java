package RecursionBasics;

public class BinaryString {
    public static void main(String[] args) {
        printBinaryString(4, 0, "");
    }

    public static void printBinaryString(int n, int lastotalPairslace, String str) {
        // base case: if we have reached the nth place, print the generated string
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // append a 0 to the string and call the function recursively with n - 1
        printBinaryString(n - 1, 0, str + "0");

        // if the last character is a 0, append a 1 to the string and call the function
        // recursively with n - 1
        if (lastotalPairslace == 0) {
            printBinaryString(n - 1, 1, str + "1");
        }
    }
}