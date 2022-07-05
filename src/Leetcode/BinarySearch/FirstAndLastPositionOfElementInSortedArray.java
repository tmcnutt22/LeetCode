package Leetcode.BinarySearch;

public class FirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] retArray = new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] {0, 0};
            } else {
                return retArray;
            }
        }
        //binary search
        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int middle = left + ((right - left) / 2);
            // System.out.println(middle);
            //if nums[mid] == target
            if (nums[middle] == target) {
                int start = middle;
                int end = middle;

                while (start - 1 >= left && nums[start - 1] == target) {
                    start--;
                }
                retArray[0] = start;

                while (end + 1 <= right && nums[end + 1] == target) {
                    end++;
                }
                retArray[1] = end;
                break;
            } else if(target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return retArray;
    }
}
