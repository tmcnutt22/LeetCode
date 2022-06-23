package Grokking.InPlaceReversalLL;
import Leetcode.LinkedList.ListNode;

import java.util.LinkedList;

public class ReverseLinkedListII {
    public static void main (String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        ListNode tempHead = head;
        ListNode temp = reverseBetween(tempHead,1,2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (head.next == null) return head;


        int index = 1;
        ListNode curr = head;
        ListNode prev = null;
        //iterates the LL until the left node
        while (index < left && curr != null) {
            prev = curr;
            curr = curr.next;
            index++;
        }

        ListNode tail = curr;
        /*tracks the first node to be reverse. to be linked to next node after right.
        last node after reversal in the LL*/

        ListNode connector = prev; //node before the reversing starts

        //reverses the linked list unil the right int
        while (index <= right && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index++;
        }

        //link left and right nodes
        if (connector != null) {
            connector.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;


        return head;
    }
}


/*
UMPIRE
Understand:
- the start and end points are 1 indexed?
- empty list?
- valid left and rights? negative indexes -1 is one from the end?
Match:
- Linkedlist problem
- 2 passes; 1 for size 2nd for reversing
- keep track of original prev and next (left  -1 and right + 1) nodes

 */
