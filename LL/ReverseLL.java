package LL;

public class ReverseLL extends LinkedList {
    public void reverseLL() {
        Node curr = tail = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

}
