package Leetcode.LinkedList;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length = length - (n + 1);
        System.out.println(length);
        first = dummy;
        while (length >= 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
/*
Two passes, first to see the size, then to remove the node that is need to be removed
 */
