package LL;

public class AddFirst extends LinkedList {
    public void addFirst(int data) {

        // step 1 - create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size = 1;
            return;
        }

        // step 2- newNode next=head
        newNode.next = head;

        // step 3 - head=newNode
        head = newNode;
        size++;
    }
}
