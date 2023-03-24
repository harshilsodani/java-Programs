package Strings;

public class String_Builder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");// use of StringBuilder
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch); // APPEND function
        }

        System.out.println(sb.length());
        sb.toString(); // TOSTRING function used to convert a StringBuilder to string
        System.out.println(sb);

    }
}
