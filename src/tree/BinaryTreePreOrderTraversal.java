package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();
       List<Integer> result = new ArrayList<>();

       while (root != null || !stack.isEmpty()) {
           if (root != null) {
               stack.push(root);
               result.add(root.val);
               root = root.left;
           } else {
               root = stack.pop().right;
           }
       }

       return result;
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
