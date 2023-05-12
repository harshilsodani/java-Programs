package BinaryTrees;

public class InorderTraversal extends BinaryTree {

    public void inorder(Node root) {

        // base case
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
