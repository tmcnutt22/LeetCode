package Grokking.TreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) return retList;
        Queue<TreeNode> q = new LinkedList<>();
        //add root to queue and to return list
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            retList.add(new ArrayList<Integer>());
            int levelLength = q.size();
            for (int i = 0; i < levelLength; ++i) {
                TreeNode node = q.poll(); //remove or poll. remove throws exception but I am checking in the while loop
                retList.get(level).add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            level++;
        }
        return retList;
    }

}

