/*
 * Count total number of nodes in a tree
 */

package BinaryTrees;

public class CountOfNodes extends BinaryTree {
    public int count(Node root){
        int treeCount=0;

        // base case 
        if(root == null){
            return 0; // beacuse if root is null 
                      // there are no nodes in tree
        }

        int leftCount=count(root.left);
        int rightCount=count(root.right);
        treeCount=leftCount+rightCount+1;

        return treeCount;
    }
}
