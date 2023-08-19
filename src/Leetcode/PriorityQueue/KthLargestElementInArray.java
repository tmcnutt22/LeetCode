package Leetcode.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) { // If the same length then compare by their string
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length()); // Compare by their length
        });
        for (String num: nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
