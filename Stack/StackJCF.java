package Stack;

import java.util.Stack;

public class StackJCF {

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        return;
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

    }

    public static void stocksSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];

            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }

    // Optimize Approach - using Stack O(n)
    public static void nextGreaterElement(int arr[], int nextGreater[]) { // O(n)
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i] /* if value at s.peek() index of arr */) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()]; // assigned value stored at s.peek() index of arr
            }

            s.push(i); // pushed index of element
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }

    public static boolean isValidParenthesis(String str) { // O(n)

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {

                    return false;

                } else if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {

                    s.pop();
                }
            }
        }

        return s.isEmpty();
    }

    public static boolean duplicateParenthesis(String str) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // closing
            if (ch == ')') {

                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true; // duplicate exists
                } else {
                    s.pop(); // poped opening parenthesis making pair with closing parenthesis
                }

            } else {
                // opening
                s.push(ch);
            }

        }
        return false;
    }

    public static void maxAreaHistogram(int arr[]) {

        // Always put index of the element in the arr in nsl and nsr and push index in
        // stack as well
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        // cal. next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        // cal. next smaller left
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        // cal. area for each bar and compare
        // width= j-i-1 = nsr[i] - nsl[i] -1

        for (int i = 0; i < arr.length; i++) {
            int currWidth = nsr[i] - nsl[i] - 1;
            int currHeight = arr[i];
            int currArea = currWidth * currHeight;

            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Max rectangular area in histogram is : " + maxArea);

    }

    public static void main(String args[]) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        maxAreaHistogram(heights);
    }
}
