package Leetcode;

public class IntToBinary {
    public static void main(String[] args) {
        int n = 4567;
        System.out.println(intToBinary(n));
    }
    public static String intToBinary(int input) {
        int n = input;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }
}
