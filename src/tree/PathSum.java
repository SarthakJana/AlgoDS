package tree;

public class PathSum {
    public boolean hasPathSum(BalancedBinaryTree.TreeNode root, int targetSum) {
        return pathSum(root, targetSum);
    }

    private boolean pathSum(BalancedBinaryTree.TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        } else if (node.left == null && node.right == null && node.val == targetSum) {
            return true;
        } else {
            return pathSum(node.left, targetSum - node.val) || pathSum(node.right, targetSum - node.val);
        }
    }
}
