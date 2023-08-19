package Leetcode.Matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board =
        {{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
        {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
        {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        //check horizontal
        int numRows = 9;
        int numCols = 9;
        for (char[] row : board) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < numRows; i++) {
                char c = row[i];
                if (c != '.' && set.contains(c)) {
                    return false;
                } else {
                    if (c != '.') {
                        set.add(c);
                    }
                }
            }
        }

        //check vertically
        for (int i = 0; i < numCols; i++) {
            System.out.println(i +" current row");
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < numCols; j++) {
                char c = board[j][i];

                for (char ch: set) {
                    System.out.println(ch);
                }
                if (c != '.' && set.contains(c)) {
                    return false;
                } else {
                    if (c != '.') {
                        set.add(c);
                    }
                }
            }

        }

        //check 3x3 grid
        boolean[][] isVisited = new boolean[9][9];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    Set<Character> set = new HashSet<>();
                    boolean isValid = dfs(board, i, j, i, i + 3, j, j + 3, set, isVisited);
                    if (!isValid) {
                        System.out.println("Returned here " + i + j);
                    }
                    if (!isValid) return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(char[][] board, int row, int col, int rowLow, int rowHigh, int colLow, int colHigh, Set<Character> set, boolean[][] isVisited) {
        if (row < rowLow || row >= rowHigh || col < colLow || col >= colHigh || isVisited[row][col]) {
            return true;
        }
        isVisited[row][col] = true;
        char c = board[row][col];
        if (c != '.' && set.contains(c)) {
            for (char ch : set) {
                System.out.println(ch);
            }

            //System.out.println("Row " + row);
            //System.out.println("Col " + col);
            return false;
        } else {
            if (c != '.') {
                set.add(c);
            }

        }
        return dfs(board, row - 1, col, rowLow, rowHigh, colLow, colHigh, set, isVisited) &&
                dfs(board, row + 1, col, rowLow, rowHigh, colLow, colHigh, set, isVisited) &&
                dfs(board, row, col - 1, rowLow, rowHigh, colLow, colHigh, set, isVisited) &&
                dfs(board, row, col + 1, rowLow, rowHigh, colLow, colHigh, set, isVisited);
    }
}
