package Leetcode.BinaryTrees;

import Grokking.TreeBFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RootToLeaf {
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<List<Integer>> retList = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        pathHelper(root, currList, retList);
        System.out.println(retList);
    }
    public static void pathHelper(TreeNode node, List<Integer> currPath, List<List<Integer>> allPaths) {
        currPath.add(node.val);
        if (node.left == null && node.right == null) {
            allPaths.add(List.copyOf(currPath));
        }

        if(node.left != null) pathHelper(node.left, currPath, allPaths);
        if(node.right != null) pathHelper(node.right, currPath, allPaths);
        currPath.remove(currPath.size() - 1);
    }
}
