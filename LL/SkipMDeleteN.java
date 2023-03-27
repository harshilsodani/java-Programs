package LL;

public class SkipMDeleteN extends LinkedList {
    public void skipMDeleteN(Node head, int M, int N) {
        Node curr = head;
        Node t;

        while (curr != null) {

            // skipping M nodes
            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }

            t = curr.next;
            // deleting N nodes 
            for (int i = 1; i < N && t != null; i++) {
                Node temp = t;
                t = t.next;
            }

            curr.next = t;
            curr = t;
        }
    }
}
