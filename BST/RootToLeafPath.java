package BST;

import java.util.*;

public class RootToLeafPath extends BST {
    static ArrayList<Integer> path = new ArrayList<>();

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);

        path.remove(path.size() - 1);

    }
}
