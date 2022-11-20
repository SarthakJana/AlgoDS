package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSumII(BalancedBinaryTree.TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, new ArrayList<Integer>(), paths, targetSum);
        return paths;
    }

    private void findPaths(BalancedBinaryTree.TreeNode node, List<Integer> current, List<List<Integer>> paths, int targetSum) {
        if (node == null) {
            return;
        }

        current.add(node.val);

        if (node.left == null && node.right == null && targetSum == node.val) {
            paths.add(current);
            return;
        }

        findPaths(node.left, new ArrayList<Integer>(current), paths, targetSum - node.val);
        findPaths(node.right, new ArrayList<Integer>(current), paths, targetSum - node.val);
    }
}
