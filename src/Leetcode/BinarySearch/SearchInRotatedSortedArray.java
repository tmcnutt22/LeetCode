package Leetcode.BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums1 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = new int[]{3,1};
        int target = 0; //4 return index
        int target1 = 3; //-1
        int target2 = 1; //1

        System.out.println(search(nums1, 1));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        //binary search
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; //avoid overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) { //the = handles [3,1] target 1
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { //nums[mid] < nums[start]
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}


/*
Understand: are all values unique?
Is the array guaranteed to be sorted apart from the pivot
empty array?
array of 1?
nums = [4,5,6,7,0,1,2], target = 0
 */
