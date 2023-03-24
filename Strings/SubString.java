package Strings;

public class SubString {
    public static void main(String[] args) {
        System.out.println(substring("harshil", 1, 3));
    }

    // SUBSTRING
    public static String substring(String str, int si, int ei) { // ending index is excluded
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }
}
