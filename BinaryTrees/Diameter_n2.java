/*
 * calculate diameter of a tree in O(n2) time complexity.
 */

package BinaryTrees;

public class Diameter_n2 extends BinaryTree {

    public int height(Node root) {
        int height = 0;

        // base case
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }
    
    public int diameter2(Node root) {

        // base case
        if (root == null) {
            return 0;
        }

        int lDiam = diameter2(root.left);
        int rDiam = diameter2(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        
        int selfDiam = lh + rh + 1;

        return Math.max(Math.max(lDiam, rDiam), selfDiam);
    }
}