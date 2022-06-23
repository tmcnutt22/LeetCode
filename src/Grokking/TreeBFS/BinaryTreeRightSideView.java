package Grokking.TreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> retList = new LinkedList<>();
        if (root == null) return retList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int qLen = q.size();
            for (int i = 1; i <= qLen; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (i == qLen) {
                    retList.add(node.val);
                }
            }
        }
        return retList;
    }
}
