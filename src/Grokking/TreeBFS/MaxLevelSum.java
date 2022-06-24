package Grokking.TreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> listOfSums = new ArrayList<>();
        int level = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int sum = 0;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            listOfSums.add(level, sum);
        }
        int max = Integer.MIN_VALUE;
        for (Integer sum: listOfSums) {
            max = Math.max(max, sum);
        }
        return listOfSums.indexOf(max);
    }
}
