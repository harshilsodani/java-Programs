package Stack;

import java.util.Stack;

public class PrintStack {
    public static void printStack(Stack<Integer> s) {

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
