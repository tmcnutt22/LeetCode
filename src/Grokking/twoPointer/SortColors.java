package Grokking.twoPointer;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int left = 0, curr = 0;
        int right = nums.length - 1;

        while (curr <= right) {
            //System.out.println("curr = " + curr);
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                curr++;
                left++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
    /*sort colors in place
    0 = red
    1 = while
    2 = blue
    must be in this order (red white blue)
    can't use built in sort
     */
