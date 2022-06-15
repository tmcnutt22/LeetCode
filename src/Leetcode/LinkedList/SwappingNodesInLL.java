package Leetcode.LinkedList;

public class SwappingNodesInLL {
    public ListNode swapNodes(ListNode head, int k) {
        //get the length of the LL
        int lenList = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            tempHead = tempHead.next;
            lenList++;
        }
        //find the correct nodes to swap
        //first would k
        int nodeToSwap = lenList - k;
        //nodes to store for the k and len - k nodes
        ListNode firstPrev = new ListNode(-1);
        ListNode firstNext = new ListNode(-1);
        ListNode secondPrev = new ListNode(-1);
        ListNode secondNext = new ListNode(-1);

        //set to the first number to be swapped in the LL
        ListNode firstHead = head; //will be first number to swap
        int counter = 0;
        while((counter != k || counter != nodeToSwap) && counter < lenList && firstHead.next != null) {
            counter++;
            firstPrev = firstHead; //pointer to prev
            firstHead = head.next;
        }

        firstNext = firstHead.next; //pointer to next

        ListNode toSwapNode =  firstHead;
        while((counter != k || counter != nodeToSwap) && counter < lenList && toSwapNode.next != null) {
            counter++;
            secondPrev = toSwapNode;
            toSwapNode = toSwapNode.next;
        }
        secondNext = toSwapNode.next;

        //using all those pointers, now swap them
        firstPrev.next = toSwapNode;
        toSwapNode.next = firstNext;
        secondPrev.next = firstHead;
        firstHead.next = secondNext;

        return head;
    }
}
/*
Swap nodes in the K from beginning and k from end
1 indexed list
UMPIRE
Understand:
- Will k always be less than the length of the LL?
- Will k always be less than 1/2 len of LL? 1-2-3-4-5 and k = 4? swap 2 and 4?
- empty list?
- is there a space limitation?
match:
- if k < 1/2 of len then fast and slow?
- 2 passes find the count, then find the nodes to swap and swap them on the 2nd pass?
plan:

Implement:

Review:

Evaluate

 */