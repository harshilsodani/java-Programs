package Heaps_PQ;

import java.util.ArrayList;

public class InsertHeap {
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void add(int data) {

        // add at last idx
        arr.add(data);

        int child = arr.size() - 1; // child index
        int par = (child - 1) / 2; // parent index

        while (arr.get(child) < arr.get(par)) { // O(logn)

            // swap
            int temp = arr.get(child);
            arr.set(child, arr.get(par));
            arr.set(par, temp);

            child = par;
            par = (child - 1) / 2;
        }
    }
}
