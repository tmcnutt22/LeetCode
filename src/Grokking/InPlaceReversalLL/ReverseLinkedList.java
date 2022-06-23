package Grokking.InPlaceReversalLL;

import Leetcode.LinkedList.ListNode;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode tempNext = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = tempNext;
        }
        return prev;
    }
}
