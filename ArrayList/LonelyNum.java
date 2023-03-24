package ArrayList;

import java.util.*;

public class LonelyNum {
    public static ArrayList<Integer> lonelyNum(ArrayList<Integer> nums) {
        ArrayList<Integer> lonely = new ArrayList<>();

        Collections.sort(nums);

        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) < nums.get(i + 1) - 1) {
                lonely.add(nums.get(i));
            }
        }
        // single element in arraylist
        if (nums.size() == 1) {
            lonely.add(nums.get(0));
        }

        // more than 1 element in arraylist
        if (nums.size() > 1) {
            // condition for 0th element
            if (nums.get(0) + 1 < nums.get(1)) {
                lonely.add(nums.get(0));
            }
            // condition for last element
            if (nums.get(nums.size() - 2) < nums.get(nums.size() - 1) - 1) {
                lonely.add(nums.get(nums.size() - 1));
            }
        }

        return lonely;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);

        ArrayList<Integer> lonely = lonelyNum(nums);
        System.out.println(lonely);
    }
}
