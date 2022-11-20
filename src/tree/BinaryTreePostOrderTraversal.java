package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(BalancedBinaryTree.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return dfs(root, result);
    }

    private List<Integer> dfs(BalancedBinaryTree.TreeNode root, List<Integer> result) {
        if (root == null) return result;

        result = dfs(root.left, result);
        result = dfs(root.right, result);
        result.add(root.val);

        return result;
    }
}
