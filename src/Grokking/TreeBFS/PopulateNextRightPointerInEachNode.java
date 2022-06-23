package Grokking.TreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointerInEachNode {
    public static void main(String[] args) {
        Node root = new Node (1);
        root.left = new Node (2);
        root.right = new Node (3);
        connect(root);
    }

    public static Node connect(Node root) {
        Node node = root;
        Queue<Node> q = new LinkedList<>();
        if (root == null) return null;
        q.add(node);
        while (!q.isEmpty()) {
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                Node tempNode = q.poll();

                //add children nodes to the queue
                if (tempNode.left != null) {
                    q.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    q.add(tempNode.right);
                }

                //connect next
                if (i != qLen - 1) {
                    tempNode.next = q.peek();
                }
            }
        }


        return root;
    }
}
