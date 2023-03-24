package ArrayList;

import java.util.ArrayList;

public class FollowingKey {

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int result[] = new int[1000];
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int maxOccur = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                maxOccur = i + 1; 
            }
        }
        return maxOccur;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);
        int key = 1;
        System.out.println(mostFrequent(nums, key));
    }
}
