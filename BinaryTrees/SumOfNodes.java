package BinaryTrees;

public class SumOfNodes extends BinaryTree {
    public int sumNodes(Node root) {
        int treeSum = 0;

        // base case
        if (root == null) {
            return 0;
        }

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        treeSum = leftSum + rightSum + root.data;

        return treeSum;
    }
}
