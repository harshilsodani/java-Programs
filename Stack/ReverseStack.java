package Stack;

import java.util.Stack;

public class ReverseStack extends StackJCF {
    public static void reverseStack(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
}
