package BinaryTrees;

import java.util.*;

public class DuplicateSubtrees extends BinaryTree {
    static HashMap<String, Integer> m;

    public static String inorderDuplicate(Node root) {
        // base case
        if (root == null) {
            return "";
        }

        String str = "(";
        str += inorderDuplicate(root.left);
        str += Integer.toString(root.data);
        str += inorderDuplicate(root.right);
        str += ")";

        if (m.get(str) != null && m.get(str) == 1) {
            System.out.print(root.data + "");
        }

        if (m.containsKey(str)) {
            m.put(str, m.get(str) + 1);
        } else {
            m.put(str, 1);
        }

        return str;
    }

    public static void duplicateSubtree(Node root) {

        m = new HashMap<>();
        inorderDuplicate(root);
    }
}
