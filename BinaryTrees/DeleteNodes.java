package BinaryTrees;

public class DeleteNodes extends BinaryTree {
    public static Node deleteNodes(Node root, int value) {
        if (root == null) {
            return null;
        }

        root.left = deleteNodes(root.left, value);
        root.right = deleteNodes(root.right, value);

        if (root.left == null && root.right == null && root.data == value) {
            return null;
        }

        return root;

    }
}
