package Grokking.TreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            level++;
        }

        return level; //should hit here
    }
}
