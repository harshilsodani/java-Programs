package LL;

public class AddAtIndex extends LinkedList{
    public void addAtIndex(int idx, int data) {
        Node newNode = new Node(data);
        Node temp = head;

        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }
}
