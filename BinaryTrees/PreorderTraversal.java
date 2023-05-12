package BinaryTrees;

public class PreorderTraversal extends BinaryTree {

    public static void preorder(Node root) {

        // base case
        if (root == null) {
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
