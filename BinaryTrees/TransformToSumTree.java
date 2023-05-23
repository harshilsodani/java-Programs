package BinaryTrees;

public class TransformToSumTree extends BinaryTree {

    public static int toSumTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftChild = toSumTree(root.left);
        int rightChild = toSumTree(root.right);

        int data = root.data;
        
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }
}
