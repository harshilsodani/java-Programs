package BinaryTrees;

public class IsUnivalued extends BinaryTree {

    static boolean univalued = true;

    public static void isUnivalued(Node root) {
        // base case
        if (root == null) {
            return;
        }

        int data = root.data;

        if (root.left != null && root.left.data != data) {
            univalued = false;
            return;
        }

        if (root.right != null && root.right.data != data) {
            univalued = false;
            return;
        }

        isUnivalued(root.left);
        isUnivalued(root.right);

    }
}
