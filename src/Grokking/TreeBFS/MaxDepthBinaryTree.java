package Grokking.TreeBFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        int level = 0;
        if (root == null) return level;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
