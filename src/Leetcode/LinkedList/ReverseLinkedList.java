package Leetcode.LinkedList;

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return curr;
    }
}
