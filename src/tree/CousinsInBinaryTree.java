package tree;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] parentX = new int[1];
        int[] parentY = new int[1];

        if (root == null) return false;

        int heightX = height(root, x, 0, parentX);
        int heightY = height(root, y, 0, parentY);

        if (heightX == heightY && parentX[0] != parentY[0]) {
            return true;
        }

        return false;
    }

    private int height(TreeNode node, int target, int height, int[] parent) {
        if (node == null) return 0;

        if (node.val == target) return height;

        parent[0] = node.val;

        int left = height(node.left, target, height + 1, parent);

        if (left != 0) return left;

        parent[0] = node.val;

        int right = height(node.right, target, height + 1, parent);

        return right;
    }

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.right = new TreeNode(4);

        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        System.out.println(cousinsInBinaryTree.isCousins(root, 2, 3));

    }
}
