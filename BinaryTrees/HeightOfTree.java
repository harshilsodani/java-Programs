package BinaryTrees;

public class HeightOfTree extends BinaryTree {
    public int height(Node root) {
        int height = 0;

        // base case
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }
}
