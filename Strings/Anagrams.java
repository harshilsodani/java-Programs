package Strings;

import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "Spar";
        String str2 = "Rasp";
        areAnagrams(str1, str2);
    }

    // ANAGRAMS
    public static void areAnagrams(String str1, String str2) {
        // convert to lowercase so that we don't have to check differently for uppercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // check the length of the strings
        if (str1.length() == str2.length()) {
            // converting both strings to char arrays
            char[] str1CharArray = str1.toCharArray();
            char[] str2CharArray = str2.toCharArray();

            // sorting the char arrays
            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(str1CharArray, str2CharArray);
            if (result) {
                System.out.println("Strings are Anagrams.");
            } else {
                System.out.println("Strings are not anagrams.");
            }

        } else {
            System.out.println("Strings are not anagrams.");
        }
    }
}
