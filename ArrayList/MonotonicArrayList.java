package ArrayList;

import java.util.ArrayList;

public class MonotonicArrayList {
    public static boolean monotonic(ArrayList<Integer> list) {
        int incCount = 0, decCount = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1) || list.get(i) == list.get(i + 1)) {
                incCount++;
            }
            if (list.get(i) >= list.get(i + 1) || list.get(i) == list.get(i + 1)) {
                decCount++;
            }
        }

        if (incCount == list.size() - 1 || decCount == list.size() - 1) {
            return true;
        }
        return false;

        // boolean inc = true, dec = true;
        // for (int i = 0; i < list.size() - 1; i++) {
        // if (list.get(i) > list.get(i + 1)) {
        // inc = false;
        // }
        // if (list.get(i) < list.get(i + 1)) {
        // dec = false;
        // }
        // }

        // return (inc || dec);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);

        System.out.println(monotonic(list));
    }
}
