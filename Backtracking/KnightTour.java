package Backtracking;

public class KnightTour {

    public static void printotalSubArraysol(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static boolean knightTour(int N) {
        int sol[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }

        int xMoves[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMoves[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // as knight start from (0,0)
        sol[0][0] = 0;
        if (!knightTourUtil(0, 0, 1, sol, xMoves, yMoves)) {
            System.out.println("solution doesn't exist");
            return false;
        } else {
            printotalSubArraysol(sol);
            return true;
        }

    }

    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < sol.length && y >= 0 && y < sol.length && sol[x][y] == -1);
    }

    public static boolean knightTourUtil(int x, int y, int movei, int sol[][], int xMoves[], int yMoves[]) {

        int k, next_x, next_y;

        // base case
        if (movei == sol.length * sol.length) {
            return true;
        }

        // recursion
        for (k = 0; k < sol.length; k++) {
            next_x = x + xMoves[k];
            next_y = y + yMoves[k];

            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (knightTourUtil(next_x, next_y, movei + 1, sol, xMoves, yMoves))
                    return true;
                else
                    sol[next_x][next_y] = -1; // backtracking
            }
        }
        return false;
    }

    public static void main(String[] args) {
        knightTour(8);
    }
}
