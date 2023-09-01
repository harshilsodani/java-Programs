package BST;

import java.util.ArrayList;

public class MergeTwoBST extends BST {

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
}
