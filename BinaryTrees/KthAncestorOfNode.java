package BinaryTrees;

public class KthAncestorOfNode extends BinaryTree {

    public static int KAncestor(Node root, int n, int k) {

        // base case
        if (root == null) {
            return -1;
        }
        
        if (root.data == n) {
            return 0;
        }

        int leftDistance = KAncestor(root.left, n, k);
        int rightDistance = KAncestor(root.right, n, k);

        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        }

        int max = Math.max(leftDistance, rightDistance);

        if (max + 1 == k) {
            System.out.println(root.data);
        }

        return max + 1;
    }
}