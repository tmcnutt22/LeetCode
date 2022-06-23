package Grokking.TreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Double> retList = new LinkedList<>();
        if (root == null) return retList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            double sum = 0.0;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            retList.add(sum / (double)qLen);
        }
        return retList;
    }
}
