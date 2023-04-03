package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValidParenthesis(String str) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {

                    return false;

                } else if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {

                    s.pop();
                }
            }
        }

        return s.isEmpty();
    }

    public static void main(String args[]) {
        String str = "(()[]{})";
        System.out.println(isValidParenthesis(str));
    }
}
