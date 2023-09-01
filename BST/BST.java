package BST;

import java.util.*;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    /********************************/

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    /********************************/

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /********************************/

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

    /********************************/

    public static boolean search(Node root, int key) { // O(H)

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    /********************************/

    public static Node delete(Node root, int val) {

        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // voila - node found

            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 - single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 - both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    /********************************/

    public static void printInRange(Node root, int k1, int k2) {

        // base case
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {

            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");

            printInRange(root.right, k1, k2);

        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    /********************************/

    static ArrayList<Integer> path = new ArrayList<>();

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);

        path.remove(path.size() - 1);

    }

    /********************************/

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) &&
                isValidBST(root.right, root, max);
    }

    /********************************/

    public static Node mirrorBST(Node root) {
        // base case
        if (root == null) {
            return null;
        }

        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    /********************************/

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

    /********************************/

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node inorderToBST(ArrayList<Integer> inorder, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = inorderToBST(inorder, si, mid - 1);
        root.right = inorderToBST(inorder, mid + 1, ei);

        return root;
    }

    public static Node bstToBalancedBst(Node root) {

        // get inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> Balanced BST
        root = inorderToBST(inorder, 0, inorder.size() - 1);
        return root;

    }

    /********************************/

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

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

    /********************************/

    public static void mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> finalInorder) {
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                finalInorder.add(list1.get(i));
                i++;
            } else {
                finalInorder.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            finalInorder.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            finalInorder.add(list2.get(j));
            j++;
        }

    }

    public static Node mergeBSTs(Node root1, Node root2) {

        // step 1
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(root1, inorder1);

        // step 2
        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(root2, inorder2);

        // merge BST
        ArrayList<Integer> finalInorder = new ArrayList<>();
        mergeList(inorder1, inorder2, finalInorder);

        // balanced BST
        Node root = inorderToBST(finalInorder, 0, finalInorder.size() - 1);

        return root;
    }

    /********************************/

    public static int rangeSumBST(Node root, int l, int r) {

        if (root == null) {
            return 0;
        }

        if (root.data < l) {
            return rangeSumBST(root.right, l, r);
        } else if (root.data > r) {
            return rangeSumBST(root.left, l, r);
        } else if (root.data > l && root.data < r) {
            return root.data + rangeSumBST(root.left, l, r) + rangeSumBST(root.right, l, r);
        }

        return 0;
    }

    /*********************************/

    static int minDiff = Integer.MAX_VALUE;
    static int minEle = 0;

    public static int closestElementInBST(Node root, int target) {

        // base case
        if (root == null) {
            return minEle;
        }

        int currDiff = Math.abs(root.data - target);
        if (currDiff < minDiff) {
            minDiff = currDiff;
            minEle = root.data;
        }

        if (root.data == target) {

            return root.data;
        } else if (root.data > target) {
            // left child
            return closestElementInBST(root.left, target);

        } else {
            // right child
            return closestElementInBST(root.right, target);
        }

    }

    /*********************************/

    public static void getInorderNode(Node root, ArrayList<Node> inorder) {
        // base case
        if (root == null) {
            return;
        }

        getInorderNode(root.left, inorder);
        inorder.add(root);
        getInorderNode(root.right, inorder);
    }

    public static Node kthSmallest(Node root, int k) {
        ArrayList<Node> inorder = new ArrayList<>();
        getInorderNode(root, inorder);

        if (k <= 0 || k > inorder.size()) {
            throw new IllegalArgumentException("K is invalid");
        }

        return inorder.get(k - 1);
    }

    public static void main(String[] args) {
        Node root1 = new Node(8);
        root1.left = new Node(5);
        root1.left.left = new Node(3);
        root1.left.right = new Node(6);
        root1.right = new Node(11);
        root1.right.right = new Node(20);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Node root = mergeBSTs(root1, root2);
        // preorder(root);

        System.out.println(kthSmallest(root1, 2).data);
    }
}
