package Leetcode;

public class CountHillsAndValleys {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,1,6,5}; //3
        int[] nums2 = new int[]{0, 1};
        int[] nums3 = new int[]{0, 1, 2, 3, 4, 5};//0

        System.out.println(countHillsAndValleys(nums3));
    }
    public static int countHillsAndValleys(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int left = 0, count = 0;

        for (int curr = 1; curr < nums.length - 1; curr++) {
            int right = curr + 1;
            /*
            if (nums[curr] == nums[right]) {
                continue;

             */

            if (nums[curr] > nums[left] && nums[curr] > nums[right]) { //hill
                count++;
                left = curr;
            } else if (nums[curr] < nums[left] && nums[curr] < nums[right]) { //valley
                left = curr;
                count++;
            }
                // num[left] < num[curr] < num[right] || num[left] > num[curr] > num[right]
                // curr++ at the end of the loop for something that is  a slope
                // can add in nums[curr] == nums[right] as well
        }





        return count;
    }
}
