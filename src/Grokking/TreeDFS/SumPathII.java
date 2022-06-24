/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
package Grokking.TreeDFS;

import Grokking.TreeBFS.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SumPathII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> retList = new LinkedList<>();
        LinkedList<Integer> currList = new LinkedList<>();
        if (root == null) return retList;
        this.pathSumHelper(root, targetSum, currList, retList);
        return retList;
    }

    public void pathSumHelper(TreeNode node, int targetSum, LinkedList<Integer> list, List<List<Integer>> retList) {
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null && targetSum == node.val) {
            retList.add(new LinkedList<>(list)); //very important, takes a current list and creates a new one off of it
        } else {
            pathSumHelper(node.left, targetSum - node.val, list, retList);
            pathSumHelper(node.right, targetSum - node.val, list, retList);
        }
        list.removeLast();
    }
}
