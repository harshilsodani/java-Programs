package BST;

public class ClosestElementInBST extends BST {
    static int minDiff = Integer.MAX_VALUE;
    static int minEle = 0;

    public static int closestElementInBST(Node root, int target) {

        // base case
        if (root == null) {
            return minEle;
        }

        int currDiff = Math.abs(root.data - target);
        if (currDiff < minDiff) {
            minDiff = currDiff;
            minEle = root.data;
        }

        if (root.data == target) {
            return root.data;
        } else if (root.data > target) {
            // left child
            return closestElementInBST(root.left, target);

        } else {
            // right child
            return closestElementInBST(root.right, target);
        }

    }
}
