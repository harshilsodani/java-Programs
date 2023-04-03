package Stack;

import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean duplicateParenthesis(String str) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // closing
            if (ch == ')') {

                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true; // duplicate exists
                } else {
                    s.pop(); // poped opening parenthesis making pair with closing parenthesis
                }

            } else {
                // opening
                s.push(ch);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        // Valid String is always provided in the input
        String str1 = "((a+b))";
        String str2 = "(a+b)";

        System.out.println(duplicateParenthesis(str1));
        System.out.println(duplicateParenthesis(str2));

    }
}
