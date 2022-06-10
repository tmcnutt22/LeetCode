package Leetcode;/*
Leetcode 349 12/31/2021
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
       int[] nums1 = new int[] {1,2,2,1, 3};
       int[] nums2 = new int[] {2,2, 3};

       System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setOne = new HashSet<>();
        for (int num : nums1) {
            setOne.add(num);
        }

        Set<Integer> retSet = new HashSet<>();
        for (int num : nums2) {
            if (setOne.contains(num)) {
                retSet.add(num);
            }
        }
        int[] returnArray = new int[retSet.size()];
        int index = 0;
        for (int s : retSet) {
            if (retSet.contains(s)) {
                returnArray[index++] = s;
            }
        }

        return returnArray;
    }
}
/*
understand:
must be unique (set)
any order so sorting not necessary
constraints? all arrays are at least of length 1 so no empty arrays
no memory constraints
return a unique array of elements of type int

match
hashing

plan(s):

add elements of one array to hashset and iterate the other adding ints as they match to a return array

1. create a set and add elements of array 1
2. create a set and add elements of array 2 as the result must be unique and can be unordered

3. loop through the set
    a. check to see if the set 2 contains the current int of set 1

    b. if yes, add to return array, else continue

3. return the array

IMPLEMENT:
See above

Review
edge cases

Evalutate:
O(n) run time
O(n+m) space where n and m are the length of the input arrays.
*/