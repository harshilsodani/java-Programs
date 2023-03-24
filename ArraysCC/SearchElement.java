package ArraysCC;

public class SearchElement {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        System.out.println(searchElement(arr, 23));
    }

    // ELEMENT SEARCH IN A SORTED AND ROTATED ARRAY
    public static int searchElement(int[] nums, int target) {

        // min contains the index of minimum element of array nums
        int min = minSearch(nums);

        // find in sorted right
        if (nums[min] <= target && target <= nums[nums.length - 1]) {
            return search(nums, min, nums.length - 1, target);
        }
        // find in sorted left
        else {
            return search(nums, 0, min - 1, target);
        }
    }

    // binary search to findtarget in left to right boundary
    public static int search(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        // System.out.println(left+" "+right);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // smallest element index
    public static int minSearch(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > left && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if ((nums[left] <= nums[mid] && nums[mid] > nums[right])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
