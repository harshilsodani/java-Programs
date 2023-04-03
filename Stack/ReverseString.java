package Stack;

import java.util.Stack;

public class ReverseString {

    public static String reverseString(String str) {

        Stack<Character> s = new Stack<>();
        int idx = 0;
        
        while (idx < str.length()) {
            s.push(str.charAt(idx));
        }

        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result = result.append(s.pop());
        }

        return result.toString();
    }
}
