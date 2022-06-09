package Grokking.twoPointer;

public class RemoveDuplicates {
    public static void main(String [] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4}; //ans: 5
        System.out.println(removeDuplicateNums(nums));
    }

    public static int removeDuplicateNums(int[] nums) {
        int index = 1; //index where we will put the next unique element

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
                //index++;
            }
        }
        return index;

    }
}

/*
 * 
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * remove duplicate numbers in the array in place
 * return the number of non duplicate numbers in the array.
 *
 */
