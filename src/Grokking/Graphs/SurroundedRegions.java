package Grokking.Graphs;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}};
        char[][] grid1 = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(grid1);
        System.out.println(Arrays.deepToString(grid1));
    }

    public static void solve(char[][] board) {
        if (board == null || board.length <= 2) return;
        int numRows = board.length;
        int numCols = board[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (board[row][col] == 'O') {
                    dfs(board, row, col, numRows, numCols);
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col, int numRows, int numCols) {
        if (row <= 0 || col <= 0 || row >= numRows - 1 || col >= numCols - 1 || board[row][col] == 'X') {
            return;
        }
        board[row][col] = 'X';

        dfs(board, row - 1, col, numRows, numCols);
        dfs(board, row + 1, col, numRows, numCols);
        dfs(board, row, col + 1, numRows, numCols);
        dfs(board, row, col - 1, numRows, numCols);
    }
}
