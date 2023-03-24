package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {

    // Brute Forece - O(n^2)
    // public static int containerwithMostWater(ArrayList<Integer> height) {

    // int maxWater = 0;

    // for (int i = 0; i < height.size(); i++) {
    // for (int j = i + 1; j < height.size(); j++) {

    // int width = j - i; // base
    // int length = Math.min(height.get(i), height.get(j)); // height
    // int water = width * length; // area
    // maxWater = Math.max(maxWater, water);
    // }
    // }

    // return maxWater;
    // }

    // 2 pointer approach - O(n)
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            // calculate water area
            int base = rp - lp;
            int ht = Math.min(height.get(lp), height.get(rp));
            int currWater = base * ht;
            maxWater = Math.max(maxWater, currWater);

            // update pointer
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
        System.out.println(storeWater(height));

    }
}
