package LL;

public class SwappingNodes extends LinkedList {
    public void swapNodes(int key1, int key2) {
        if (key1 == key2) {
            return;
        }

        Node curr1 = head;
        Node prev1 = null;

        while (curr1 != null && curr1.data != key1) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        Node curr2 = head;
        Node prev2 = null;

        while (curr2 != null && curr1.data != key2) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        if (curr1 == null || curr2 == null) { // if any one of the key do not exist then there is no need to do swapping
            return;
        }

        if (prev1 != null) {
            prev1.next = curr2;
        } else { // if prev1 == null , then curr1==head therefore for swapping curr1 with curr2
                 // make head curr2
            head = curr2;
        }

        if (prev2 != null) {
            prev2.next = curr1;
        } else {// if prev2 == null , then curr2==head therefore for swapping curr1 with curr1
                // make head curr2
            head = curr1;
        }

        // swapping two nodes by changing links between them 
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

    }
}
