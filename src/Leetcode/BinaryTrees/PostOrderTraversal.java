package Leetcode.BinaryTrees;

import Grokking.TreeBFS.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        List<Integer> list = postorderTraversal(node);
        System.out.println(list);

    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // to return the numbers
        if (root == null) return list;
        traverse(root, list);
        return list;
    }

    public static void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        //System.out.println(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
        list.add(node.val);
    }
}
