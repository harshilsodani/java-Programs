package RecursionBasics;

// Given a "2 x n" floor and tiles of size "2 x 1" , count the number of ways to tile the given floor using "2 x 1" tiles.

// (A tile can be placed vertically or horizontally).

public class TilingProblem {
    public static void main(String[] args) {
        System.out.println(tilingProblem(1));
    }

    public static int tilingProblem(int n) { // floor size is 2 x n
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // vertical choice
        // int fnm1 = tilingProblem(n - 1);

        // // horizontal choice
        // int fnm2 = tilingProblem(n - 2);

        // int totalWays = fnm1 + fnm2;
        // return totalWays;

        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }
}
