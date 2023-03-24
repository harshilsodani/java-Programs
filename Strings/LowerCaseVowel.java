package Strings;

public class LowerCaseVowel {
    public static void main(String[] args) {
        System.out.println(lowercaseVowel("Harshil Sodani"));
    }

    // LOWER CASE VOWEL
    public static int lowercaseVowel(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }
}
