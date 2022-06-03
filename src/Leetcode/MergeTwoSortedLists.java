package Leetcode;

class Main {
    public static void main(String[] args) {

    }


    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        /*
        //recursive implementation
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        head.next = mergeTwoLists(list1, list2);

        return head;
        */

        //iterative implementation
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = list1 == null ? list2 : list1;

        return head.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
