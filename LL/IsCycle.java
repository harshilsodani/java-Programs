package LL;

public class IsCycle extends LinkedList {
    public boolean isCycle() {
        // Floyd's cycle finding algo - slow-fast approach
        // if slow and fast meet at a node other than head node then there is a cycle in
        // the LL.

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // cycle detected
                return true;
            }
        }
        return false;
    }

}
