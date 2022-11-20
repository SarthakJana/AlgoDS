package tree;

import java.util.*;
import java.util.function.DoubleConsumer;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(BalancedBinaryTree.TreeNode root) {
        Queue<BalancedBinaryTree.TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Double> avg = new ArrayList<>();

        queue.add(root);

        if (root == null) return result;

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BalancedBinaryTree.TreeNode currentNode = queue.remove();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            result.add(currentLevel);

//            double avgVal = currentLevel.stream().mapToInt(e -> e).average().getAsDouble();
//            avg.add(avgVal);
        }

        return result;
    }
}
