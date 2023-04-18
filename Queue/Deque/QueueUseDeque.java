package Queue.Deque;

import java.util.*;

public class QueueUseDeque {
    static public class MyQueue {

        Deque<Integer> deque = new LinkedList<>();

        public boolean isEmpty() {
            return deque.isEmpty();

        }

        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            if (deque.isEmpty()) {
                return -1;
            }

            return deque.removeFirst();
        }

        public int peek() {
            if (deque.isEmpty()) {
                return -1;
            }

            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());

        while (!q.isEmpty()) {
        System.out.print(q.remove()+" ");
        }
    }
}