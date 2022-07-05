package Leetcode.BSTs;

import Grokking.TreeBFS.TreeNode;

public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        bstSumHelper(root, low, high);

        return sum;
    }
    public void bstSumHelper(TreeNode node, int low, int high) {
        if (node == null) return;
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }

        bstSumHelper(node.left, low, high);
        bstSumHelper(node.right, low, high);
    }
}
