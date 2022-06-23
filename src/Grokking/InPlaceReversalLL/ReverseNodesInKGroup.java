package Grokking.InPlaceReversalLL;

import Leetcode.LinkedList.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode curr = head;
        ListNode prev = null;
        int extraNodes = size % k;

        int index = 1;
        while (index <= size - extraNodes && curr != null) {

            curr = curr.next;
            index++;
        }

        return head;
    }
}


/*
UMPIRE
Understand

Match:
-dummy head
-2 passes to get the length to ensure if len % k != 0, the remaining nodes are not reversed

Plan:
 */
