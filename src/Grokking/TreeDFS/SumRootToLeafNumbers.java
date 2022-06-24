package Grokking.TreeDFS;

import Grokking.TreeBFS.TreeNode;

public class SumRootToLeafNumbers {
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        sumOfPath(root, 0);
        System.out.println("Sum : " + sum);

    }

    public static int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        sumOfPath(root, 0);
        return sum;
    }

    private static void sumOfPath(TreeNode node, int parentVal) {
        //replace each node val with it's value * 10 ^ level power i.e. root = level 0;
        node.val = node.val + (parentVal * 10);
        if (node.left == null && node.right == null) {
            sum += node.val;
        }
        if (node.left != null) sumOfPath(node.left, node.val);
        if (node.right != null) sumOfPath(node.right, node.val);
    }
}
