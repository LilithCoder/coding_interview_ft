/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max_side = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return max_side;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                max_side = Math.max(max_side, dp[i][j]);
            }
        }
        return max_side * max_side;
    }
}
// @lc code=end

