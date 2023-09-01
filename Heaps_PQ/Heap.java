package Heaps_PQ;

import java.util.*;

public class Heap {

    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) {
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

    public int peek() {
        return arr.get(0);
    }

    private void heapifyMin(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i; // index of minimum element in heap

        if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
            minIdx = left;
        }

        if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
            minIdx = right;
        }

        if (minIdx != i) {
            // swap minIdx and i
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            heapifyMin(minIdx);
        }
    }

    public int remove() {
        int data = arr.get(0);

        // step 1 - swap first and last
        int temp = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, temp);

        // step 2 - delete last
        arr.remove(arr.size() - 1);

        // step 3 - heapify
        heapifyMin(0);

        return data;
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
