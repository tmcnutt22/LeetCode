package Leetcode.Heaps;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.offer(num);
        }
        this.k = k;
        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

}
