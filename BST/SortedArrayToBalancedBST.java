package BST;

public class SortedArrayToBalancedBST extends BST {
    public static Node createBalancedBST(int[] arr, int si, int ei) {

        // base case
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, si, mid - 1);
        root.right = createBalancedBST(arr, mid + 1, ei);

        return root;
    }
}