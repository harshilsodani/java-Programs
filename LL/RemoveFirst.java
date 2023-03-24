package LL;

public class RemoveFirst extends LinkedList {
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }
}
