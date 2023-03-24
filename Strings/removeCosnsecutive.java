package Strings;

public class removeCosnsecutive {
    public static void main(String args[]) {
        String s = "aabb";
        System.out.println(remove(s));
    }

    public static String remove(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);

            while (i < str.length() - 1 && str.charAt(i + 1) == ch) {
                i++;
            }
        }

        return sb.toString();
    }
}
