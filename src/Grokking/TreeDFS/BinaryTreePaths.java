package Grokking.TreeDFS;

import Grokking.TreeBFS.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(5);

        List<String> list = binaryTreePaths(root);
        System.out.println(list);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        if (root == null) {
            return allPaths;
        }
        binaryTreePathsHelper(root, path, allPaths);

        return allPaths;
    }

    public static void binaryTreePathsHelper(TreeNode node, List<Integer> path, List<String> allPaths) {
        if (node == null) return;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder tempBuilder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                tempBuilder.append(path.get(i));
                tempBuilder.append("->");
            }
            tempBuilder.append(path.get(path.size() - 1));
            allPaths.add(new String(tempBuilder));
        } else {
            //path.append(arrow);
            if (node.left != null) binaryTreePathsHelper(node.left, path, allPaths);
            if (node.right != null) binaryTreePathsHelper(node.right, path, allPaths);
        }
        path.remove(path.size()-1);
    }
}
