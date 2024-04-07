package BST;

import java.util.*;

public class TwoSumBST extends BST {

    public static void twoSumBST(Node root) {
        ArrayList<Node> inorder = new ArrayList<>();
        getInorderNode(root, inorder);

        int temp = 0;
        for (int i = 0; i < inorder.size(); i++) {
            for (int j = i + 1; j < inorder.size(); j++) {

                temp += inorder.get(j).data;
            }

            inorder.get(i).data = temp;
        }
    }
}
