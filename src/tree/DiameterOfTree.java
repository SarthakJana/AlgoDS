package tree;


public class DiameterOfTree {
    public int diameterOfBinaryTree(BalancedBinaryTree.TreeNode root) {
        int[] diaMax = new int[1];
        height(root, diaMax);
        return diaMax[0];
    }

    private int height(BalancedBinaryTree.TreeNode node, int[] diaMax) {
        if (node == null) return 0;

        int leftH = height(node.left, diaMax);
        int rightH = height(node.right, diaMax);

        diaMax[0] = Math.max(diaMax[0], leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }


}
