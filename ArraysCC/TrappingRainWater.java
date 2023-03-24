package ArraysCC;

public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = { 4, 1, 23, 10, 6 };
        System.out.println(trappedRainwater(arr));
    }

    // TRAPING RAINWATER PROBLEM
    public static int trappedRainwater(int height[]) {

        int n = height.length;

        // max left boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // max right boundary - array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            // water level for each bar - min(left max,right max)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            // water trapped for each bar - waterTrapped = waterlevel-height
            waterTrapped += waterLevel - height[i];
        }

        return waterTrapped;
    }
}
