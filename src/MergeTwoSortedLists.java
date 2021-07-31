class Main {
    public static void main(String[] args) {

    }


    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        
        //bruteforce approach would be to add all the nodes to an array, then sort, then add back 
        //to a linked list
        //empty lists
        if (l1 == null && l2 == null) {
            return null;
        }
        return temp;
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
