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
        int numRows = board.length;
        int numCols = board[0].length;
        if (board == null || board.length <= 2) return;

        // turn borders into T and run DFS off of Ts to identify the Os not surrounded regions
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (board[row][col] == 'O' && (row == 0 || row == numRows - 1 || col == 0 || col == numCols - 1)) {
                    dfs(board, row, col, numRows, numCols);
                }
            }
        }

        // turn 0s into xs as the remaining Os are surrounded
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }

        // turn Ts into Xs to match the output
        /*
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
        */

    }

    public static void dfs(char[][] board, int row, int col, int numRows, int numCols) {
        if (row < 0 || col < 0 || row == numRows || col == numCols || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T'; //temp placeholder that will identify the not surrounded area

        //dfs on the adjacent cells
        dfs(board, row - 1, col, numRows, numCols);
        dfs(board, row + 1, col, numRows, numCols);
        dfs(board, row, col + 1, numRows, numCols);
        dfs(board, row, col - 1, numRows, numCols);
    }
}

/* Time: O(n*m) where n and m are the height and width of teh matrix
    SPACE: O(n*m) for the recursive call stack
 */