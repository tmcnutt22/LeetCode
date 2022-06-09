

public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10, 12};
        int[] results = squareSortedArray(nums);
        for (int num: results) {
            System.out.println(num);
        }
    }

    public static int [] squareSortedArray(int[] nums) {
        int[] ret_array = new int[nums.length];
        int posPtr = 0;

        //pointer to first positive number in the array
        while (posPtr < nums.length &&  nums[posPtr] < 0) {
            posPtr++;
        }
        int negPtr = posPtr - 1; //set negative pointer to last negative number in the array
        int index = 0; //current index in the return array

        //loop through the array, comparing the size of squared numbers
        while (posPtr < nums.length && negPtr >= 0) {
            if (nums[posPtr] * nums[posPtr] < nums[negPtr] * nums[negPtr]) {
                ret_array[index++] = nums[posPtr]*nums[posPtr];
                posPtr++;
            } else {
                ret_array[index++] = nums[negPtr] * nums[negPtr];
                negPtr--;
            }
        }
        
        // residual items in the orignal arrayarray
        if (posPtr < nums.length) {
            while (posPtr < nums.length) {
                ret_array[index++] = nums[posPtr] * nums[posPtr];
                posPtr++;
            }
        } else {
            while (negPtr >= 0) {
                ret_array[index++] = nums[negPtr] * nums[negPtr];
                negPtr--;
            }
        }
        return ret_array;
    }
}

/*
 * O(n) time | O(n) space
 *
 *
 *
 *
 *
 *
 *
 *
 */
