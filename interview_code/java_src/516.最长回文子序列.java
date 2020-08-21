class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp 数组的定义是：在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i + 1][j], dp[i][j - 1]), dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}