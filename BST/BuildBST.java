package BST;

public class BuildBST extends BST {

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;

        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }
}
