package Queue.Deque;

import java.util.*;

public class StackUseDeque {
    static class MyStack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            if (deque.isEmpty()) {
                return -1;
            }

            return deque.removeLast();
        }

        public int peek() {
            if (deque.isEmpty()) {
                return -1;
            }

            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek = " + s.peek());
    }
}
