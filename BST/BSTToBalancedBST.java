package BST;

import java.util.*;

public class BSTToBalancedBST extends BST {
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node inorderToBST(ArrayList<Integer> inorder, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = inorderToBST(inorder, si, mid - 1);
        root.right = inorderToBST(inorder, mid + 1, ei);

        return root;
    }

    public static Node bstToBalancedBst(Node root) {

        // get inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> Balanced BST
        root = inorderToBST(inorder, 0, inorder.size() - 1);
        return root;

    }
}
