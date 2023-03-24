package LL;

public class IterativeSearch extends LinkedList {
    public int itrSearch(int key) {
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == key) {
                return idx;
            }
            temp = temp.next;
            idx++;

        }
        return -1;
    }
}
