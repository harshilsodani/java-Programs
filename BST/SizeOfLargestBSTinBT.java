package BST;

public class SizeOfLargestBSTinBT extends BST {
    // class Info {
    // boolean isBST;
    // int size;
    // int min;
    // int max;

    // public Info(boolean isBST, int size, int min, int max) {
    // this.isBST = isBST;
    // this.size = size;
    // this.min = min;
    // this.max = max;
    // }
    // }

    public static int maxBST = 0;

    public Info largestBST(Node root) {

        // base case
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) { // invalidBST condition
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) { // validBsT condition
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

}
