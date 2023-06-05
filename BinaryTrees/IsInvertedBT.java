package BinaryTrees;

public class IsInvertedBT extends BinaryTree {

    public static boolean isInverted(Node root1, Node root2) {

        // base case
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.data != root2.data) {
            return false;
        }

        return isInverted(root1.left, root2.right) && isInverted(root1.right, root2.left);

    }
}
