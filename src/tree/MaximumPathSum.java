package tree;


public class MaximumPathSum {
    public int maxPathSum(BalancedBinaryTree.TreeNode root) {
        int[] maxPathSum = new int[1];
        maxPathSum[0] = root.val;
        height(root, maxPathSum);
        return maxPathSum[0];
    }

    private int height(BalancedBinaryTree.TreeNode node, int[] maxPathSum) {
        if (node == null) return 0;

        int leftH = height(node.left, maxPathSum);
        int rightH = height(node.right, maxPathSum);

        leftH = Math.max(leftH, 0);
        rightH = Math.max(rightH, 0);

        maxPathSum[0] = Math.max(maxPathSum[0], node.val + leftH + rightH);

        return node.val + Math.max(leftH, rightH);
    }


}
