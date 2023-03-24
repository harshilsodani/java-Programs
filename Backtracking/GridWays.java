package Backtracking;

public class GridWays {

    public static int noOfWays(int x, int y, int n, int m) {

        // base case
        if (x == n - 1 && y == m - 1) {// condition for last cell
            return 1;
        } else if (x == n || y == m) { // boundary cross condition
            return 0;
        }
        // recursion
        int down = noOfWays(x + 1, y, n, m);
        int right = noOfWays(x, y + 1, n, m);
        int totalWays = down + right;
        return totalWays;

    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int totalWays = noOfWays(0, 0, n, m);
        System.out.println(totalWays);
    }
}
