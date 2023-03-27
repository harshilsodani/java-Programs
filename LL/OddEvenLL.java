package LL;

public class OddEvenLL extends LinkedList {
    public void segregateEvenOdd() {
        Node end = head; // Initialize 'end' as the head node
        Node prev = null; // 'prev' keeps track of the last even node
        Node curr = head; // Initialize 'curr' as the head node

        // Traverse to the end of the list
        while (end.next != null)
            end = end.next;

        Node new_end = end; // Initialize 'new_end' as the end node

        // Move all odd nodes to the end of the list
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr; // Append 'curr' to 'new_end'
            curr = curr.next; // Move 'curr' to the next node
            new_end.next.next = null; // Set 'new_end.next.next' to null
            new_end = new_end.next; // Update 'new_end'
        }

        // If the first node is even, update 'head'
        if (curr.data % 2 == 0) {
            head = curr;

            // Traverse the list again starting from 'curr'
            while (curr != end) {
                // If 'curr' is even, move to the next node
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                }
                // If 'curr' is odd, remove it from the list and append it to 'new_end'
                else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        }
        // If the last node is odd and hasn't been moved yet, append it to 'new_end'
        else
            prev = curr;
        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

}
