package Leetcode.BinarySearch;

import java.util.Arrays;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(searchMatrix(matrix, 3));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int row = 0; //row where the number will be if in the matrix


        //search height first
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            //System.out.println("Hit this");
            int pivot = (top + bottom) / 2;


            if (target >= matrix[pivot][0] && target <= matrix[pivot][width - 1]) {
                if (target == matrix[pivot][0] || target == matrix[pivot][width - 1]) {
                    return true;
                } else {
                    row = pivot; //will set the row variable to the row where the number will be if it exists
                    System.out.println("Pivot: " + row);
                    break;
                }

            } else if(target < matrix[pivot][0]) {
                System.out.println("Here");
                bottom = pivot - 1;
            } else {
                top = pivot + 1;
                //System.out.println("Hit this");
            }
        } // the row where the number would be is now set

        //binary search on the row
        int left = 0;
        int right = width - 1;
        int[] currRow = matrix[row];
        System.out.println("Current row: " + Arrays.toString(currRow));

        while (left <= right) {
            int middle = (left + right) / 2;
            System.out.println("middle number: " + currRow[middle]);
            if (target == currRow[middle]) {
                return true;
            } else if (target < currRow[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}


/*
UMPIRE
Understand


Match:
binary search


Plan:

search heightwise first


 */
