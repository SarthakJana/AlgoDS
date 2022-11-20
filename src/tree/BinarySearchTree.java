package tree;


import java.util.*;

public class BinarySearchTree {
    TreeNode root;


    public BinarySearchTree() {
    }

    public void insert(int n) {
        TreeNode newNode = new TreeNode(n, null, null);

        TreeNode node = root;
        TreeNode temp = null;

        while (node != null) {
            temp = node;
            if (newNode.val > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (root == null) {
            root = newNode;
        } else {
            if (newNode.val > temp.val) {
                temp.right = newNode;
            } else {
                temp.left = newNode;
            }
        }
    }

    public TreeNode search(int val) {
        TreeNode temp = root;
        while (temp != null && temp.val != val) {
            if (val > temp.val) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        if (temp == null) {
            return new TreeNode(-1, null, null);
        } else {
            return temp;
        }
    }

    public List<Integer> preOrderTraversal() {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode temp = root;

        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                result.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop().right;
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

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);

        System.out.println(Arrays.toString(binarySearchTree.preOrderTraversal().toArray()));

        System.out.println(binarySearchTree.search(7).val);

        TreeMap<Integer, String> treeMap = new TreeMap<>((e1, e2) -> e2 - e1);
    }
}
