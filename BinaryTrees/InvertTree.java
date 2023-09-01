package BinaryTrees;

public class InvertTree extends BinaryTree {

    public Node invertTree(Node root) {
        if (root == null) {
            return root;
        }

        Node leftInvertedTree = invertTree(root.left);
        Node rightIvertedTree = invertTree(root.right);

        root.left = rightIvertedTree;
        root.right = leftInvertedTree;

        return root;
    }
}
