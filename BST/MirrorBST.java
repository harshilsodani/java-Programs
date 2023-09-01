package BST;

public class MirrorBST extends BST {
    public static Node mirrorBST(Node root) {
        // base case
        if (root == null) {
            return null;
        }

        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }
}
