package Leetcode.BinaryTrees;

import Grokking.TreeBFS.TreeNode;

public class CountGoodNodesInBT {
    static int goodPaths = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(4 == goodNodes(root));
    }
    public static int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        goodNodesHelper(root, Integer.MIN_VALUE);
        return goodPaths;
    }
    private static void goodNodesHelper(TreeNode node, int max) {

        //base case
        if (node == null) return;
        //if curr val >= prior max increment num of good paths
        if (node.val >= max) {
            goodPaths++;
        }
        max = Math.max(max, node.val); //resets the max
        //recursive calls
        goodNodesHelper(node.left, max);
        goodNodesHelper(node.right, max);
    }

}