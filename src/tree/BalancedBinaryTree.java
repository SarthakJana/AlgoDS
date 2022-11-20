package tree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        if (left == -1) return -1;
        int right = dfs(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
