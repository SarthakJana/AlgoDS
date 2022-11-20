package tree;

public class invertedTree {
    public BinarySearchTree.TreeNode invertTree(BinarySearchTree.TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(BinarySearchTree.TreeNode node) {
        if (node == null) return;

        BinarySearchTree.TreeNode left = node.left;
        BinarySearchTree.TreeNode right = node.right;

        node.left = right;
        node.right = left;

        dfs(node.left);
        dfs(node.right);
    }
}
