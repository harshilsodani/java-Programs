/**
 * The IsPalindrome class checks if a linked list is a palindrome using a stack.
 */
package Stack;

import java.util.*;

public class IsPalindrome {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head) {
        
        Node slow = head;
        boolean isPalin = true;
        Stack<Integer> s = new Stack<>();

        while (slow != null) {
            s.push(slow.data);
            slow = slow.next;
        }

        // This code block is checking if the linked list is a palindrome by comparing the values of
        // the nodes in the linked list with the values in a stack. It starts by popping the top
        // element from the stack and comparing it with the value of the head node in the linked
        // list. If they are equal, the `isPalin` variable is set to true, and the head is updated
        // otherwise it is set to false and the loop is broken. The loop continues until all nodes 
        //in the linked list have been compared with the values in the stack.
        while (head != null) {
            int i = s.pop();
            if (head.data == i) {
                isPalin = true;
            } else {
                isPalin = false;
                break;
            }
            head = head.next;
        }

        return isPalin;
    }

    public static void main(String args[]) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        boolean condition = isPalindrome(one);
        System.out.println("Palindrome :" + condition);
    }
}
