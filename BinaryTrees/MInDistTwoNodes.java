/*
 * Minimum Distance between two nodes - It is the minimum no of edges on path between two given nodes.
 */
package BinaryTrees;

public class MInDistTwoNodes extends BinaryTree {
    public static int lcaDistance(Node root, int n) {
        // base case
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDistance(root.left, n);
        int rightDist = lcaDistance(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }

    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDistance(lca, n1);
        int dist2 = lcaDistance(lca, n2);

        int minDistance = dist1 + dist2;
        return minDistance;

    }
}
