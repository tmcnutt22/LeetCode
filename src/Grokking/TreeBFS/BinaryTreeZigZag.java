package Grokking.TreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> retList = new LinkedList<>();
        if (root == null) return retList;
        Queue<TreeNode> queue = new LinkedList<>();

        int level = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            retList.add(list);
            level++;
        }
        return retList;
    }
}


/*
U

Match: BFS, queue

Plan: use level order traversal in a queue, tracking the level.
in while loop
for each node
if level % 2 == 0 add right, then left
else add left then right to the queue.
add the current node.val to the list.

add the whole list to the ret list.
increment level.

 */
