package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    public int kthSmallest(BinarySearchTree.TreeNode root, int k) {
       /* List<Integer> inOrderList = new ArrayList<>();
        inOrderList = inOrder(root, inOrderList);
        return inOrderList.get(k - 1);*/

        int[] kth = new int[1];
        kth[0] = k;
        return inOrderK(root, kth);
    }

    private List<Integer> inOrder(BinarySearchTree.TreeNode node, List<Integer> inOrderList) {
        if (node == null) return inOrderList;
        inOrderList = inOrder(node.left, inOrderList);
        inOrderList.add(node.val);
        inOrderList = inOrder(node.right, inOrderList);

        return inOrderList;
    }

    private int inOrderK(BinarySearchTree.TreeNode node, int[] kth) {
        if (node == null) return 0;

        int left = inOrderK(node.left, kth);

        if (left != 0) return left;
        kth[0] -= 1;
        if (kth[0] == 0) return node.val;

        int right = inOrderK(node.right, kth);

        return right;
    }


}
