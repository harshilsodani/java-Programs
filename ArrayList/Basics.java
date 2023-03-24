package ArrayList;

import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // add operation - O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // list.add(1,9); // O(n)
        // System.out.println(list);

        // size of Arraylist
        // System.out.println(list.size());

        // print the arraylist
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // get operation - O(1)
        // System.out.println(list.get(3));

        // remove operation - O(n)
        // list.remove(2);
        // System.out.println(list);

        // set operation - O(n)
        // list.set(1, 10);
        // System.out.println(list);

        // contain operartion - O(n)
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(11));
    }
}
