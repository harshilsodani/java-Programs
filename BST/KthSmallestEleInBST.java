package BST;

import java.util.ArrayList;

public class KthSmallestEleInBST extends BST {

    public static void getInorderNode(Node root, ArrayList<Node> inorder) {
        // base case
        if (root == null) {
            return;
        }

        getInorderNode(root.left, inorder);
        inorder.add(root);
        getInorderNode(root.right, inorder);
    }

    public static Node kthSmallest(Node root, int k) {
        ArrayList<Node> inorder = new ArrayList<>();
        getInorderNode(root, inorder);

        if (k <= 0 || k > inorder.size()) {
            throw new IllegalArgumentException("K is invalid");
        }

        return inorder.get(k - 1);
    }
}
