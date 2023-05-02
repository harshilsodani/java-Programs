/**
 * The GenerateBinaryNumber class generates and prints binary numbers up to a given limit using a queue
 * data structure.
 */
package Queue;

import java.util.Queue;
import java.util.LinkedList;

public class GenerateBinaryNumber {

    // This method generates and prints N binary numbers in ascending order
    public static void generatePrintNumber(int N) {

        // Create a queue to store binary numbers
        Queue<String> q = new LinkedList<>();
        // Add the initial binary number "1" to the queue
        q.add("1");

        // Generate and print binary numbers until N binary numbers have been generated
        // and printed
        while (N-- > 0) {
            // remove the first binary number from the queue
            String s1 = q.peek();
            q.remove();
            // Print the removed binary number
            System.out.print(s1 + " ");
            // Generate two new binary numbers by appending "0" and "1" to the removed
            // binary number
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }

    }

    public static void main(String[] args) {
        int N = 5;
        generatePrintNumber(N);

    }
}
