package Leetcode.BinaryTrees;

import Grokking.TreeBFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (root == null) return retList;
        traverse(root, retList);
        return retList;
    }

    public void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }
}
