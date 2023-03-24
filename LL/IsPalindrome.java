package LL;

public class IsPalindrome extends LinkedList {
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

}
