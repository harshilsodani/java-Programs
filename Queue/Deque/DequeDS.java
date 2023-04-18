package Queue.Deque;

import java.util.*;

public class DequeDS {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);

        System.out.println("First ele: "+deque.getFirst());
        System.out.println("Last ele: "+deque.getLast());

    }

}