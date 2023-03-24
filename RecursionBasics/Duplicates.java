package RecursionBasics;

public class Duplicates {
    public static void main(String[] args) {
        String str = "harshilsodani";
        // boolean map[] = new boolean[26];
        // StringBuilder newStr = new StringBuilder();
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // work
        char currentChar = str.charAt(idx);
        if (map[currentChar - 'a'] == true) {
            // duplicate
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            // not duplicate
            map[currentChar - 'a'] = true;

            removeDuplicates(str, idx + 1, newStr.append(currentChar), map);
        }

    }
}