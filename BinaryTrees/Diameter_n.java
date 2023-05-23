/*
 * calculate diameter of a tree in O(n) time complexity.
 * return Info object which contain both diameter and height of the tree.
 */

package BinaryTrees;

public class Diameter_n extends BinaryTree {

    public class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public Info diameter(Node root) {

        // base case
        if (root == null) {
            return new Info(0, 0);
        }

        Info lInfo = diameter(root.left);
        Info rInfo = diameter(root.right);

        int finalDiam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht + rInfo.ht + 1);
        int finalHt = Math.max(lInfo.ht, rInfo.ht) + 1;

        return new Info(finalDiam, finalHt);
    }
}
