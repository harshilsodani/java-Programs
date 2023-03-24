package LL;

public class RemoveCycle extends LinkedList {
    // steps
    // 1. find last node
    // 2. lastNode.next=null

    // approach-
    // 1.detect cycle in LL
    // 2.(a)slow==head
    // (b) prev=null;
    // while(slow==fast){
    // slow++;
    // prev=fast;
    // fast++;
    // }
    // 3. prev.next==null;

    public void removeCycle() {

        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // remove cycle -> last.next==null
        prev.next = null;
    }

}
