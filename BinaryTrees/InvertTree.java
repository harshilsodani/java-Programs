package BinaryTrees;

public class InvertTree extends BinaryTree {

    public Node invertTree(Node root) {
        if (root == null) {
            return root;
        }

        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
