package tree;

public class DepthOfTree {
    public int maxDepth(BalancedBinaryTree.TreeNode root) {
        return height(root);
    }

    public int height(BalancedBinaryTree.TreeNode node) {
        if (node == null) return 0;//1

        int leftHeight = height(node.left); //2
        int rightHeight = height(node.right);//4

        return 1 + Math.max(leftHeight, rightHeight);//4
    }
}
