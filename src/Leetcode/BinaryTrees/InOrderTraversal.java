package Leetcode.BinaryTrees;

import Grokking.TreeBFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        //LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        traverseTree(root, list);
        return list;
    }

    public void traverseTree(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverseTree(node.left, list);

        list.add(node.val);
        traverseTree(node.right, list);

    }
}
