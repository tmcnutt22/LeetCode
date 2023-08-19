package Grokking.TwoHeaps;

import java.util.PriorityQueue;
import java.util.Collections;

public class MedianFinder {
    PriorityQueue<Integer> smallHeap; //max heap 
    PriorityQueue<Integer> bigHeap; //min heap
    

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        bigHeap = new PriorityQueue<>(); //min heap
    }

    public void addNum(int num) {
        smallHeap.add(num); //always add to small heap 

        //check the values

        if ((!smallHeap.isEmpty() && !bigHeap.isEmpty()) && smallHeap.peek() > bigHeap.peek()) {
            bigHeap.add(smallHeap.poll()); //removes the element that is out of order in the heap
            //only applies to small ehap because I am only adding new elements to the small heap
        }

        //check the size small heap bigger
        if (smallHeap.size() > bigHeap.size() + 1) {
            bigHeap.add(smallHeap.poll());
        }

        //check the size big heap bigger
        if (bigHeap.size() > smallHeap.size() + 1) {
            smallHeap.add(bigHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() > bigHeap.size()) {
            return (double) smallHeap.peek();
        }
        if (bigHeap.size() > smallHeap.size()) {
            return (double) bigHeap.peek();
        }

        return (double) (smallHeap.peek() + bigHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
