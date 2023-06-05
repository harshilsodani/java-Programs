package BinaryTrees;

import java.util.*;

public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /************************************************ */
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    /************************************************ */
    static class Info1 {
        Node node;
        int hd;

        public Info1(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    /************************************************ */
    static int idx = -1;

    public static Node buildTree(int nodes[]) { // O(n)
        idx++;

        if (nodes[idx] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[idx]);

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;

    }

    /************************************************ */
    public static void preorder(Node root) { // O(n)

        // base case
        if (root == null) {
            // System.out.print(-1+" ");
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /************************************************ */
    public void inorder(Node root) { // O(n)

        // base case
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /************************************************ */
    public void postorder(Node root) {
        // base case
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    /************************************************ */
    public void levelorder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

    }

    /************************************************ */
    public int height(Node root) {

        // base case
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /************************************************ */
    public int count(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    /************************************************ */
    public int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    /************************************************ */
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

    /************************************************ */
    public Info diameter1(Node root) {

        // base case
        if (root == null) {
            return new Info(0, 0);
        }
        Info lInfo = diameter1(root.left);
        Info rInfo = diameter1(root.right);

        int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht + rInfo.ht + 1);
        int ht = Math.max(lInfo.ht, rInfo.ht) + 1;

        return new Info(diam, ht);
    }

    /************************************************ */
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot) {

        // base case
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return (isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot));
    }

    /************************************************ */
    public static void topView(Node root) {
        // Level order traversal
        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info1(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info1 curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) { // first time my hd is occuring
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info1(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info1(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

        }

        for (int i = min; i <= max; i++) {
            int currData = map.get(i).data;
            System.out.print(currData + " ");
        }
        System.out.println();
    }

    /************************************************ */
    public static void KLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, level + 1, k);
        KLevel(root.right, level + 1, k);
    }

    /************************************************ */
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // base case
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }

    /************************************************ */
    public static Node lowestCommonAncestor1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last common node -> i-1 the index
        Node lca = path1.get(i - 1);

        return lca;

    }

    /************************************************ */
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
         * if both left and right Lca are not null then it means both have either n1 or
         * n2 therefore root must be first common ancestor of both nodes.
         */
        return root;
    }

    /************************************************ */
    public static int lcaDistance(Node root, int n) {
        // base case
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDistance(root.left, n);
        int rightDist = lcaDistance(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }

    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDistance(lca, n1);
        int dist2 = lcaDistance(lca, n2);

        int minDistance = dist1 + dist2;
        return minDistance;

    }

    /************************************************ */
    public static int KAncestor(Node root, int n, int k) {

        // base case
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDistance = KAncestor(root.left, n, k);
        int rightDistance = KAncestor(root.right, n, k);

        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        }

        int max = Math.max(leftDistance, rightDistance);

        if (max + 1 == k) {
            System.out.println(root.data);
        }

        return max + 1;
    }

    /************************************************ */
    public static int toSumTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftChild = toSumTree(root.left);
        int rightChild = toSumTree(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }

    /************************************************ */

    static boolean univalued = true;

    public static void isUnivalued(Node root) {
        // base case
        if (root == null) {
            return;
        }

        int data = root.data;

        if (root.left != null && root.left.data != data) {
            univalued = false;
            return;
        }

        if (root.right != null && root.right.data != data) {
            univalued = false;
            return;
        }

        isUnivalued(root.left);
        isUnivalued(root.right);

    }

    /************************************************ */

    public static boolean isInverted(Node root1, Node root2) {

        // base case
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.data != root2.data) {
            return false;
        }

        return isInverted(root1.left, root2.right) && isInverted(root1.right, root2.left);

    }

    /************************************************ */

    public Node invertTree(Node root) {
        if (root == null) {
            return root;
        }

        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    /************************************************ */

    public static Node deleteNodes(Node root, int value) {
        if (root == null) {
            return null;
        }

        root.left = deleteNodes(root.left, value);
        root.right = deleteNodes(root.right, value);

        if (root.left == null && root.right == null && root.data == value) {
            return null;
        }

        return root;

    }

    /************************************************ */

    public static void main(String[] args) {

        // Main tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(3);
        root2.left.left = new Node(3);
        root2.left.right = new Node(2);
        // root2.right.left = new Node(5);
        // root2.right.right = new Node(4);

        // Sub tree
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        deleteNodes(root2, 3);
        preorder(root2);

    }
}
