package Grokking.fastandslow;

public class LinkedListCycle {
    public static void main(String[] args) {
    }

    public static boolean hasCycle(ListNode head) {
        /*
        //greater than the constraint
        if (head == null || head.next == null) return false;
        int counter = 0;
        while (head.next != null) {
            head = head.next;
            counter++;
            if (counter > 10000) return true;
        }
        return false;
         */
        //fast and slow pointers
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
