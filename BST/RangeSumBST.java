package BST;

public class RangeSumBST extends BST {

    public static int rangeSumBST(Node root, int l, int r) {

        if (root == null) {
            return 0;
        }

        if (root.data < l) {
            return rangeSumBST(root.right, l, r);
        } else if (root.data > r) {
            return rangeSumBST(root.left, l, r);
        } else if (root.data > l && root.data < r) {
            return root.data + rangeSumBST(root.left, l, r) + rangeSumBST(root.right, l, r);
        }

        return 0;
    }
}
