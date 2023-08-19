package Grokking.TwoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] nums1 = {2147483647,1,2,3,4,5,6,7,2147483647};
        int k1 = 2;
        medianSlidingWindow(nums1, k1);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(); //min heap default

        int left = 0;
        int index = 0;
        double[] retArray = new double[nums.length - k + 1];
        for (int right = 0; right < nums.length; right++) {
            System.out.println("Ith iteration: " + right);
            insert(smallHeap, bigHeap, nums[right], nums[left], k);
            if (smallHeap.size() + bigHeap.size() > k) {
                delete(smallHeap, bigHeap, nums[left++]);
            }
            if (smallHeap.size() + bigHeap.size() == k) {
                retArray[index++] = getMedian(smallHeap, bigHeap);
            }
        }
        return retArray;
    }

    public static void insert(PriorityQueue<Integer> smallHeap, PriorityQueue<Integer> bigHeap, int num, int firstNumInWindow, int windowSize) {
        smallHeap.add(num);
        //check that the head of small < head of big
        if (!smallHeap.isEmpty() && !bigHeap.isEmpty() && smallHeap.peek() > bigHeap.peek()) {
            bigHeap.add(smallHeap.poll());
        }

        //check size
        if (smallHeap.size() > bigHeap.size() + 1) {
            bigHeap.add(smallHeap.poll());
        }
        if (bigHeap.size() > smallHeap.size() + 1) {
            smallHeap.add(bigHeap.poll());
        }
        if (!smallHeap.isEmpty()) {
            System.out.println("Small heap head: " + smallHeap.peek());
        }
        if (!bigHeap.isEmpty()) {
            System.out.println("Big heap head: " + bigHeap.peek());
        }

    }

    public static void delete(PriorityQueue<Integer> smallHeap, PriorityQueue<Integer> bigHeap, int numToBeDeleted) {
        boolean temp = smallHeap.remove(numToBeDeleted);
        System.out.println("Bool: " + temp);
        if (!temp) bigHeap.remove(numToBeDeleted);

        //rebalance the heaps
        if (smallHeap.size() > bigHeap.size() + 1) {
            bigHeap.add(smallHeap.poll());
        }
        if (bigHeap.size() > smallHeap.size() + 1) {
            smallHeap.add(bigHeap.poll());
        }
        System.out.println("small size: " + smallHeap.size());
        System.out.println("Big size: " + bigHeap.size());   }

    public static double getMedian(PriorityQueue<Integer> smallHeap, PriorityQueue<Integer> bigHeap) {
        double median = 0.0;
        if (smallHeap.size() == bigHeap.size()) {
            if (smallHeap.peek() == Integer.MAX_VALUE) {
                return (double) Integer.MAX_VALUE;
            }
            long sum = (long) smallHeap.peek() + (long) bigHeap.peek();
            median = (double) sum / 2.0;
        }
        if (smallHeap.size() < bigHeap.size()) {
            median = (double) bigHeap.peek();
        }
        if (bigHeap.size() < smallHeap.size()) {
            median = (double) smallHeap.peek();
        }
        return median;
    }
}
