package tree;

public class ValidSequence {
    public boolean isValidSequence(BinarySearchTree.TreeNode root, int[] sequence) {
        if (root == null) return false;

        return dfs(root, 0, sequence);
    }

    boolean dfs(BinarySearchTree.TreeNode node, int pos, int[] seq) {

        boolean left = false, right = false;

        if (node == null) return false;

        if (seq[pos] == node.val && (node.left == null && node.right == null) && pos == seq.length - 1) return true;

        if (node.left.val == seq[pos + 1]){
             left = dfs(node.left, pos + 1, seq);
        }

        if (node.right.val == seq[pos + 1]) {
             right = dfs(node.right, pos + 1, seq);
        }

        return left || right;
    }
}
