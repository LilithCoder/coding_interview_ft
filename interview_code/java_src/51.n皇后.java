/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) Arrays.fill(chars, '.');
        backtrack(result, board, 0);
        return result;
    }
    private static void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            result.add(convert_char_to_string(board));
            return;
        }
        int col_num = board[row].length;
        for (int col = 0; col < col_num; col++) {
            // 排除不合法选择
            if (!is_valid(board, row, col)) continue;
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            backtrack(result, board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }
    private static List<String> convert_char_to_string(char[][] board) {
        List<String> return_param = new ArrayList<>();
        for (char[] chs: board) {
            return_param.add(String.valueOf(chs));
        }
        return return_param;
    }
    private static boolean is_valid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
// @lc code=end

