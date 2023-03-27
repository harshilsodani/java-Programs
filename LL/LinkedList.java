package LL;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

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

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

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

    public int sizeLL() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }

    public int removeLast() {

        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data;
        Node prev = head;

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

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

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1; // return idx;
        }
        return idx + 1;

    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverseLL() {
        Node curr = tail = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // find and remove nth node from last of LL
    public void removeNthFromEnd(int n) {
        // calculate size of LL
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            // revome head
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // use of slow-fast pointer
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isLLPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // 1) find Middle node
        Node midNode = findMid(head);

        // 2) reverse half LL
        Node curr = midNode;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // head for right half
        Node left = head;// head for left half

        // 3) check if 1st half(left half)==2nd half(right half)
        while (right != null) {
            if (left.data != right.data) { // not a palindrome
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

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

    public void removeCycle() {

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
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next==null
        prev.next = null;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {

        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) { // O(nlogn)

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find midNode
        Node mid = getMid(head);

        // left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge sorted halves
        return merge(newLeft, newRight);
    }

    public void zigZag() {
        // find Mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL;
        Node nextR;

        // alternate merge
        while (left != null && right != null) {

            // merging
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // updating right and left
            right = nextR;
            left = nextL;

        }
    }

    public Node getIntersectionNode(Node head1, Node head2) {

        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public void skipMDeleteN(Node head, int M, int N) {
        Node curr = head;
        Node t;

        while (curr != null) {

            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }

            t = curr.next;
            for (int i = 1; i <= N && t != null; i++) {
                Node temp = t;
                t = t.next;
            }

            curr.next = t;
            curr = t;
        }
    }

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

        while (curr2 != null && curr2.data != key2) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        if (curr1 == null || curr2 == null) {
            return;
        }

        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2;
        }

        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            head = curr1;
        }

        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

    }

    public void segregateEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;

        while (end.next != null)
            end = end.next;

        Node new_end = end;

        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if (curr.data % 2 == 0) {
            head = curr;

            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        } else
            prev = curr;
        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();

        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.printLL();
        // list.swapNodes(2, 4);
        list.printLL();

    }
}