/*
 * find the lowest common ancestor of two given nodes.
 */

package BinaryTrees;

import java.util.*;

public class LowestCommonAncestor1 extends BinaryTree {
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // base case
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }

    public static Node lowestCommonAncestor(Node root, int n1, int n2) { // O(n) 
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i< path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last common node - i-1 the index
        Node lca = path1.get(i - 1);

        return lca;

    }
}
