package Leetcode.TwoPointer;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int maxPotentialArea = 0;
        int n = height.length;

        int left = 0;
        int right = 1;
        int curr = 1;
        while (left < right && right < n) {
            int begMaxArea = height[left] * n - 1 - left; //max the beginning ptr area could be
            int currMaxArea = height [curr] * n - 1 - curr; //max are the curr ptr could be
            if (currMaxArea >= begMaxArea) {
                //move beg to curr and do a while loop
                left++;
                right++;
                while (right < n) {
                    if (height[left] >= height[right]) {
                        right++;
                    }
                }
            }
        }
        return 0;
    }
}
