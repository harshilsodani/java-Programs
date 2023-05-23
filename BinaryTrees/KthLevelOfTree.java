/*
 * Print the data of the nodes present at Kth level of the tree.
 */

package BinaryTrees;

public class KthLevelOfTree extends BinaryTree {

    public static void KLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, level + 1, k);
        KLevel(root.right, level + 1, k);
    }
}
