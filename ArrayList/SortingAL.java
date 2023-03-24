package ArrayList;

import java.util.*;

// here we can implement any sorting method such as bubble sort, selection sort, insertion sort etc from stratch 
public class SortingAL {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(8);
        list.add(10);
        list.add(4);
        list.add(2);
        System.out.println(list);

        // it is a inbuild method to sort an ArrayList 
        Collections.sort(list);
        System.out.println(list);
        
        Collections.sort(list, Collections.reverseOrder()); // to sort list in descending order
        // collections.reverseOrder() is a comperator
        // comperator can be considered as functions those define logic.
        System.out.println(list);
    }
}
