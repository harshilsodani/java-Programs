package ArraysCC;

public class TripletSum {
    public static void main(String args[]) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        int arr[][] = triplets(nums);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] triplets(int nums[]) { // O(n^3) , we can optimize it using Linked List and HashMaps

        int arr[][] = new int[3][3];
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != j && i != k && j != k && nums[i] + nums[j] + nums[k] == 0) {

                        arr[p][0] = nums[i];
                        arr[p][1] = nums[j];
                        arr[p][2] = nums[k];
                        p++;
                    }
                }
            }
        }

        return arr;

    }
}
