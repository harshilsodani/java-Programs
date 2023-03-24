package Backtracking;

public class FindSubsets {

    public static void findSubsets(String str, String ans, int idx) {
        // base case
        if (idx == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }

            return;
        }

        // recursion
        // yes choice
        findSubsets(str, ans + str.charAt(idx), idx + 1);

        // no choice
        findSubsets(str, ans, idx + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        findSubsets(str, ans, 0);
    }
}