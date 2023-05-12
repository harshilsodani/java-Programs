package Stack;

import java.util.Stack;

public class TrappingRainwater {

    public static int trappedRainwater(int[] heights) {
        Stack<Integer> s = new Stack<>();

        int totalWaterTrapped = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            // This while loop is checking if the stack is not empty and the current height is greater
            // than the height at the top of the stack. If this condition is true, it pops the top
            // element from the stack and calculates the distance between the current index and the new
            // top of the stack. It then calculates the bounded height by taking the minimum of the
            // heights at the current index and the new top of the stack, and subtracting the height of
            // the popped element. Finally, it calculates the total water trapped by multiplying the
            // distance and bounded height and adds it to the running total. This loop continues until
            // the stack is empty or the height at the top of the stack is greater than or equal to the
            // current height.
            while (!s.isEmpty() && heights[s.peek()] < heights[i]) {

                int pop_height = s.peek();
                s.pop();

                if (s.isEmpty()) {
                    break;
                }

                int distance = i - s.peek() - 1;
                int boundedHeight = Math.min(heights[i], heights[s.peek()]) -
                        heights[pop_height];
                totalWaterTrapped += distance * boundedHeight;
            }

            s.push(i);
        }

        return totalWaterTrapped;

    }

    public static void main(String[] args) {
        int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 6 };
        System.out.println(trappedRainwater(heights));
    }
}
