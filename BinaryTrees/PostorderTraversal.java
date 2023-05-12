package BinaryTrees;

public class PostorderTraversal extends BinaryTree {
    public void postorder(Node root) {
        // base case
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}
