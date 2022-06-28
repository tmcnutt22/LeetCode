package Leetcode.BinaryTrees;
import Grokking.TreeBFS.TreeNode;

public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesHelper(root);
        return sum;
    }

    public void sumOfLeftLeavesHelper(TreeNode node) {
        if (node == null) return;
        if (node.left != null && node.right != null) {
            sum += node.left.val;

        }
        if (node.left != null) {
            sumOfLeftLeavesHelper(node.left);
        }
        if (node.right != null) {
            sumOfLeftLeavesHelper(node.right);
        }

    }


}
