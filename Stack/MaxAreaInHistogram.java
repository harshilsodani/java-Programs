package Stack;

import java.util.Stack;

public class MaxAreaInHistogram {
    public static void maxAreaHistogram(int arr[]) { // O(n)

        // Always put index of the element in the arr in nsl and nsr and push index in
        // stack as well
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        // cal. next smaller right - O(n)
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

        // cal. next smaller left - O(n)
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

        // cal. area for each bar and compare - O(n)
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
