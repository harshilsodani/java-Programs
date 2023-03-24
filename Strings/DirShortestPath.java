package Strings;

public class DirShortestPath {
    public static void main(String[] args) {
        System.out.println(getShortestPath("NE"));
    }

    // SHORTEST PATH
    public static float getShortestPath(String path) {
        int x = 0, y = 0;
        int x0 = 0, y0 = 0;

        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            } else if (dir == 'E') {
                x++;
            } else {
                x--;
            }
        }

        float shortestPath = (float) Math.sqrt(Math.pow(x - x0, 2) + Math.pow(y - y0, 2));
        return shortestPath;
    }
}
