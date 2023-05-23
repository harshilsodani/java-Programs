/*
 * Given the root of two binary tree root and subRoot, return true if there is a subtree of root with 
 * the same STRUCTURE AND NODE VALUES of subRoot and false otherwise.
 */

package BinaryTrees;

public class SubtreeOfAnotherTree extends BinaryTree {

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot) {

        // base case
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return (isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot));
    }
}
