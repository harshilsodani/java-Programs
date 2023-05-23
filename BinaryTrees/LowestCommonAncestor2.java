package BinaryTrees;

public class LowestCommonAncestor2 extends BinaryTree {

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // leftLca -> val and rightLca = null
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        /*
         * if both left and right Lca are not null then it means both have either or
         * n2therefore root must be first common ancestor of both nodes.
         */
        return root;
    }

}
