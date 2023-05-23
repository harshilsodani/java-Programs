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
        root.data = root.left.data + leftChild + root.right.data + rightChild;

        return data;
    }
}
