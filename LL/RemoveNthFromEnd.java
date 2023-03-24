package LL;

public class RemoveNthFromEnd extends LinkedList{
    // find and remove nth node from last of LL
    public void removeNthFromEnd(int n) {
        // calculate size of LL
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            // revome head
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }
}