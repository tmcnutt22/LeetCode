package Leetcode.BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }
}
