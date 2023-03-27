package LL;

public class MergeSortedLL {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node sortedMerge(Node a, Node b) {

        Node result = null;

        if (a == null)
            return b;
        else if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    public static Node mergeKLists(Node arr[], int last) {

        while (last != 0) {
            int i = 0, j = last;

            while (i < j) {
                arr[i] = sortedMerge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }

            }

        }
        return arr[0];
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int k = 3;

        MergeSortedLL obj = new MergeSortedLL();
        MergeSortedLL.Node[] arr = new MergeSortedLL.Node[k];

        arr[0] = obj.new Node(1);
        arr[0].next = obj.new Node(3);
        arr[0].next.next = obj.new Node(5);
        arr[0].next.next.next = obj.new Node(7);

        arr[1] = obj.new Node(2);
        arr[1].next = obj.new Node(4);
        arr[1].next.next = obj.new Node(6);
        arr[1].next.next.next = obj.new Node(8);

        arr[2] = obj.new Node(0);
        arr[2].next = obj.new Node(9);
        arr[2].next.next = obj.new Node(10);
        arr[2].next.next.next = obj.new Node(11);
        
        Node head = mergeKLists(arr, k - 1);
        printList(head);
    }
}
