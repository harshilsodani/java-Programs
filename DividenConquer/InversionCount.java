package DividenConquer;

public class InversionCount {

    // bruteforece approach - O(n^2)
    // public static int inversionCount(int arr[]) {
    // int count = 0;

    // for (int i = 0; i < arr.length; i++) {
    // for (int j = i+1; j < arr.length; j++) {
    // if (arr[i] > arr[j] ) {
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    // optimized approach - modified merge sort(n * logn)

    public static int merge(int arr[], int lo, int mid, int hi) {
        int temp[] = new int[hi - lo + 1];
        int invCount = 0;
        int i = lo;
        int j = mid;
        int k = 0;

        while (i < mid && j <= hi) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                invCount += (mid - i);
                j++;
                k++;
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j <= hi) {
            temp[k++] = arr[j++];
        }

        return invCount;
    }

    public static int getInversionCount(int arr[], int lo, int hi) {

        int invCount = 0;

        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            invCount += getInversionCount(arr, lo, mid);
            invCount += getInversionCount(arr, mid + 1, hi);
            invCount += merge(arr, lo, mid, hi);
        }

        return invCount;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6 };
        System.out.println(getInversionCount(arr, 0, arr.length - 1));
    }
}
