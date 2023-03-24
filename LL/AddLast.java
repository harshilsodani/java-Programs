package LL;

public class AddLast extends LinkedList {
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size = 1;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }
}
