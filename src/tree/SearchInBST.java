package tree;

import java.util.stream.Stream;

public class SearchInBST {
    public BinarySearchTree.TreeNode searchBST(BinarySearchTree.TreeNode root, int val) {
        return search(root, val);
    }

    private BinarySearchTree.TreeNode search(BinarySearchTree.TreeNode node, int val) {
        if (node == null) return null;

        if (node.val == val) return node;

        if (val < node.val) {
            return search(node.left, val);
        } else {
            return search(node.right, val);
        }
    }
}
