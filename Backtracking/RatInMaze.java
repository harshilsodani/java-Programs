package Backtracking;

public class RatInMaze {
    public static void printotalSubArraysolution(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMazeUtil(int maze[][], int sol[][], int x, int y) {
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            if (sol[x][y] == 1) {
                return false;
            }
            sol[x][y] = 1;

            if (solveMazeUtil(maze, sol, x + 1, y)) {
                return true;
            }
            if (solveMazeUtil(maze, sol, x, y + 1)) {
                return true;
            }
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static boolean solveMaze(int maze[][], int x, int y) {

        int N = maze.length;
        int sol[][] = new int[N][N];

        if (solveMazeUtil(maze, sol, x, y) == false) {
            System.out.println("solution dosen't exist");
            return false;
        }

        printotalSubArraysolution(sol);
        return true;

    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        solveMaze(maze, 0, 0);

    }
}
