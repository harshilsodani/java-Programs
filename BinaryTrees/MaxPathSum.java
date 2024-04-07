package BinaryTrees;

public class MaxPathSum extends BinaryTree {

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(Node root) {

        // base case
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxPathSum(root.left));
        int rightSum = Math.max(0, maxPathSum(root.right));
        int rootSum = root.data + leftSum + rightSum;

        max = Math.max(rootSum, max);

        return root.data + Math.max(leftSum, rightSum);
    }
}
