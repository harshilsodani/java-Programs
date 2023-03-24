package DividenConquer;

public class MajorityEle {

    // bruteforce approach - O(n^2)
    // public static int majEle(int arr[]) {
    // int majority = arr.length / 2;

    // for (int i = 0; i < arr.length; i++) {
    // int count = 0;

    // for (int j = 0; j < arr.length; j++) {
    // if (arr[j] == arr[i]) {
    // count++;
    // }
    // }

    // if (count > majority) {
    // return arr[i];
    // }
    // }
    // return -1;
    // }

    // divide and conquer approach

    public static int countInRange(int arr[], int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i < hi; i++) {
            if (arr[i] == num) {
                count++;
            }

        }
        return count;
    }

    public static int majorityElementRec(int arr[], int lo, int hi) {

        // single element in array
        if (lo == hi) {
            return arr[lo];
        }

        // kaam
        int mid = lo + (hi - lo) / 2;
        int left = majorityElementRec(arr, lo, mid);
        int right = majorityElementRec(arr, mid + 1, hi);

        // decide whether maj ele in left is equal to right or not
        if (left == right) {
            return left;
        }

        // if left and right maj ele are not equal
        int leftCount = countInRange(arr, left, lo, hi);
        int rightCount = countInRange(arr, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElement(int arr[]) {
        return majorityElementRec(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        // int ele = majEle(nums);
        int element = majorityElement(nums);
        System.out.println(element);
    }
}
