package DividenConquer;

public class RotatedSortedArr {

    // By using recursion
    public static int search(int arr[], int si, int ei, int tar) {

        // base case
        if (si > ei) {
            return -1;
        }

        // kaam
        int mid = si + (ei - si) / 2;

        // case FOUND
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case a : left
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, si, mid - 1, tar);
            } else {
                // case b : right of mid
                return search(arr, mid + 1, ei, tar);
            }

        }

        // mid on L2
        if (arr[mid] <= arr[ei]) {
            // case c : right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, mid + 1, ei, tar);
            } else {
                // case d : left of mid
                return search(arr, si, mid - 1, tar);
            }
        }

        return 0;

    }

    // By using iteration
    public static int search1(int arr[], int si, int ei, int tar) {

        int mid = si + (ei - si) / 2;

        if (arr[mid] == tar) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid - 1]) {
                for (int i = si; i < mid - 1; i++) {
                    if (arr[i] == tar) {
                        return i;
                    }
                }
            } else {
                for (int i = mid + 1; i <= ei; i++) {
                    if (arr[i] == tar) {
                        return i;
                    }
                }
            }
        }

        if (arr[mid] <= arr[ei]) {
            if (arr[mid + 1] <= tar && tar <= arr[ei]) {
                for (int i = mid + 1; i <= ei; i++) {
                    if (arr[i] == tar) {
                        return i;
                    }
                }
            } else {
                for (int i = si; i < mid - 1; i++) {
                    if (arr[i] == tar) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {

        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int tarIdx = search1(arr, 0, arr.length - 1, target);
        System.out.println(tarIdx);
    }
}
