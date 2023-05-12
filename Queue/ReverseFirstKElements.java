/**
 * The ReverseFirstKElements class reverses the first k elements of a queue using a stack and then
 * rotates the remaining elements to the end of the queue.
 */
package Queue;

import java.util.*;

public class ReverseFirstKElements {
    public static void main(String[] args) {

        int[] q = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int k = 5;

        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < q.length; i++) {
            Q.add(q[i]);
        }

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < k; i++) {
            s.push(Q.remove());
        }

        while (!s.isEmpty()) {
            Q.add(s.pop());
        }
        
        int queueSize = Q.size();
        for (int i = 0; i < queueSize - k; i++) {
            Q.add(Q.remove());
        }

        for (int i : Q) {
            System.out.print(i + " ");
        }
    }
}
