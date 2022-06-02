public class ShortestUnsortedSubArray {
    public static void main(String[] args) {
        int[] intArray = new int[]{2,3,3,2,4};

        int shortest = shortestArray(intArray);
        System.out.println("The shortest unsorted array is: " + shortest);
    }


    public static int shortestArray(int[] nums) {
        //array of length 1
        if (nums.length == 1) return 0;

        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int localMinimum;
        int localMaximum;

        //sets points to the beginning of unsorted and end of unsorted
        while (leftPointer < nums.length - 1) {
            if (nums[leftPointer] <= nums[leftPointer + 1]) {
                leftPointer++;
            } else {
                break;
            }
        }

        //edge case: array is already sorted
        if (leftPointer == nums.length - 1) {
            return 0;
        }
        while (rightPointer > 0) {
            if (nums[rightPointer] >= nums[rightPointer - 1]) {
                rightPointer--;
            } else {
                break;
            }
        }
        //edge case: array is in descending order
        if (rightPointer == 0) {
            return nums.length;
        }

        System.out.println("L ptr after while loop: " + leftPointer);
        System.out.println("R ptr after while loop: " + rightPointer);
        //find local min / max
        localMaximum = Integer.MIN_VALUE;
        localMinimum = Integer.MAX_VALUE;
        for (int i = leftPointer; i <= rightPointer; i++) {
            System.out.println("i: " + i);
            if (nums[i] >= localMaximum) {
                localMaximum = nums[i];
            }
            if (nums[i] <= localMinimum) {
                localMinimum = nums[i];
            }
        }

        System.out.println("min: " + localMinimum);
        System.out.println("max: " + localMaximum);
        //find unsorted amounts outside of current left and right pointers
        for (int i = 0; i < leftPointer; i++) {
            if (nums[i] > localMinimum) {
                leftPointer = i;
                break;
            }
        }

        for (int i = nums.length - 1; i > rightPointer; i--) {
            if (nums[i] < localMaximum) {
                rightPointer = i;
                break;
            }
        }

        System.out.println("L ptr final: " + leftPointer);
        System.out.println("R ptr: " + rightPointer);

        return rightPointer - leftPointer + 1;
    }
}

