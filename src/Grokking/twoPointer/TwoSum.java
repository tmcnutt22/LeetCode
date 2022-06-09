import java.lang.IllegalArgumentException;

public class TwoSum {
    public static void main(String[] args) {
        int[] numArray = new int[]{-4, -1, 1, 3, 5, 6, 8, 11}; //{3, 5, -4, 8, 11, 1, -1, 6}
        int target = 10;
        int[] answer = twoSum(numArray, target);
        for(int num: answer) {
            System.out.println(num);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        //pointers
        int left = 0, right = nums.length - 1;
        
        //iterate until find a match or get to the middle of the array
        while (left < right) {
            int currSum = nums[left] + nums[right];
            if (currSum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (currSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0};
    }
}


/*
 * Two sum on a sorted array
 *
 * UMPIRE
 * Understand
 * will the array always be sorted?
 * what should I return if the array is empty?
 * are there are any time | space restrictions? Yes, no additional space
 *
 * Match
 * Two pointers
 *
 * Plan
 *
 * Since the array is sorted, create 2 pointers
 * one at the beginning of the array and one at the end of the array
 *
 * add the numbers, 
 * if matches, return array[nums[left], nums[right]]
 * if < target:
 *  increment left
 * if > target:
 *  increment right
 */
