/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        // edge case
        if (len < 2) {
            return s;
        }
        // initialization
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int max_length = 0;
        int target_i = 0;
        int target_j = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                    continue;
                }
                // length of substring is 1 or 2
                if (j - 1 - (i + 1) + 1 < 2) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > max_length) {
                    max_length = j - i + 1;
                    target_i = i;
                    target_j = j;
                }
            }
        }
        return s.substring(target_i, target_j + 1);
    }
}
// @lc code=end

