package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(spiralMatrix(matrix).toArray()));
    }

    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;

        while (res.size() < size) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.println(i);
                res.add(matrix[i][right]);
                printArrayList(res);
            }
            right--;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public static void printArrayList(List<Integer> list) {
        System.out.println("ArrayList");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
