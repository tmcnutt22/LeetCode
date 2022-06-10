package Grokking.twoPointer;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;// output 8
        int[] nums1 = new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k1 = 19;
        System.out.println("Final answer :" + subarrayProductLessThanK(nums1, k1));
    }

    public static int subarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;    }
}

/*
UMPIRE
Understand:
empty array
all products greater than target
all zeroes?
overlapping answers i.e. 2 indices have the same value?
Match: sliding window
Plan:
create a counter;
create a left pointer = 0;
create a product = 1 (for multiplication)
iterate the array until a product is > k;
incrementing the counter
divide the product by left ptr num and increment left ptr until the product is less than k
incrementing the counter



Implement:
Review:
Evaluate:
 */
