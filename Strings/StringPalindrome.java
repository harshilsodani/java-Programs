package Strings;

public class StringPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("noon"));
    }

    // PALINDROME
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
