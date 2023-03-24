package BasicSorting;

import java.util.*;

// Any permutation of Arrays possible so that elements at a index in both arrays add up to given value K.

public class permuteArrays {
    public static void main(String args[]) {
        int arr1[] = { 1, 2, 2, 1 };
        int arr2[] = { 3, 3, 3, 4 };
        int k = 5;
        int n=arr1.length;
        System.out.println(permutationPossible(arr1, arr2, n,k));
    }

    public static boolean permutationPossible(int a[], int b[],int n, int k) {
        
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            if (a[i] + b[n-1-i] < k) {
                return false;
            }

        }
        return true;
    }
}
