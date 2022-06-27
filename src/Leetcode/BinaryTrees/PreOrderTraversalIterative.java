package Leetcode.BinaryTrees;

import Grokking.TreeBFS.TreeNode;

import java.util.*;

public class PreOrderTraversalIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>(); // for stack
        List<Integer> list = new ArrayList<>(); // to return the numbers
        if (root == null) return list;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.add(node);
                list.add(node.val);
                node = node.left;
            }
            node = stack.removeLast();
            node = node.right;
            if (node != null) {
                list.add(node.val);
            }
        }

        return list;
    }
}
