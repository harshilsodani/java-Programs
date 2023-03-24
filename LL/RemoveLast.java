package LL;

public class RemoveLast extends LinkedList {
    public int removeLast() {

        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data;
        Node prev = head;

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
}
