package Grokking.TreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> retList = new LinkedList<>();
        if (root == null) return retList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.left);
                }
            }
            retList.addFirst(tempList);
        }

        return retList;
    }
}
