package Leetcode.Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points1 = new int[][]{{0,1},{1,0}};
        int k1 = 2;
        System.out.println(Arrays.deepToString(kClosest(points1, k1)));
    }
    public static int[][] kClosest(int[][] points, int k) {
        int[][] retArray = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        int n = points.length;
        if(k == n) {
            return points;
        }

        for(int[] point: points) {
            System.out.println(Arrays.toString(point));
            int x1 = point[0];
            int y1 = point[1];
            int distance = (x1*x1) + (y1*y1);
            int[] tempArray = new int[]{x1, y1, distance};
            pq.offer(tempArray);
        }
        int index = 0;
        while (index < k && !pq.isEmpty()) {
            int[] temp = new int[2];
            int[] poppedArray = pq.poll();
            temp[0] = poppedArray[0];
            temp[1] = poppedArray[1];
            retArray[index] = temp;
            index++;
        }
        return retArray;
    }
}
