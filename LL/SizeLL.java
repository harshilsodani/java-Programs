package LL;

public class SizeLL extends LinkedList {
    public int sizeLL() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
