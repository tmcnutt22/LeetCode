public class Balance {
    public static void main(String[] args) {
        int[] intArray = new int[]{2, 4, 6, 3, 4};
        balance(intArray);
        //System.out.println(balance(intArray));
        StringBuilder sb = new StringBuilder();
    }

    public static int balance(int[] nums) {
        int n = nums.length;
        int[] leftOdd = new int[n], leftEven = new int[n];
        int[] rightOdd = new int[n], rightEven = new int[n];
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            leftOdd[i] = odd;
            leftEven[i] = even;
            if (i % 2 == 0) even += nums[i];
            else odd += nums[i];
        }
        odd = 0;
        even = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightOdd[i] = odd;
            rightEven[i] = even;
            if (i % 2 == 0) even += nums[i];
            else odd += nums[i];
        }
        System.out.println("leftOdd");
        for (int i = 0; i < leftOdd.length; i++) {
            System.out.print(leftOdd[i] + ",");
        }

        System.out.println("\nrightEven");
        for (int i = 0; i < rightEven.length; i++) {
            System.out.print(rightEven[i] + ",");
        }
        System.out.println("\nleftEven");
        for (int i = 0; i < leftEven.length; i++) {
            System.out.print(leftEven[i] + ",");
        }

        System.out.println("\nrightOdd");
        for (int i = 0; i < rightOdd.length; i++) {
            System.out.print(rightOdd[i] + ",");
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (leftOdd[i] + rightEven[i] == leftEven[i] + rightOdd[i]) {
                //System.out.println("id:" + (i+1));
                count++;
            }
        }
        return count;
    }
}
