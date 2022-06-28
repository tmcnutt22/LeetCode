package Leetcode.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,7,4,1,8,1}; //1
    }
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1) {
            //removes the first 2 elements from the pqueue
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int remainingWeight = stone1 - stone2; //fine as stone1 >= stone2 always
            if (remainingWeight > 0) {
                maxHeap.offer(remainingWeight);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
