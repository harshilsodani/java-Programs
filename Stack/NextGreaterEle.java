package Stack;

import java.util.Stack;

public class NextGreaterEle {

    // BruteForce Approach - Nested Loop O(n2)

    // Optimize Approach - using Stack O(n)
    public static void nextGreaterElement(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i] /* if value at s.peek() index of arr */ ) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()]; // assigned value stored at s.peek() index of arr
            }

            s.push(i); // pushed index of element
        }
    }

    public static void main(String args[]) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextGreater[] = new int[arr.length];
        nextGreaterElement(arr, nextGreater);

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }
}
