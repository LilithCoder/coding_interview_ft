class Solution {
    // 本题思路：
    // 一般涉及到了子序列，考虑的就是动态规划
    // 只涉及一个字符串/数组时，dp的定义是：在子串s[i..j]中，最长回文子序列的长度为dp[i][j]
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // 只涉及一个字符串/数组时，dp的定义是：在子串s[i..j]中，最长回文子序列的长度为dp[i][j]
        int[][] dp = new int[n][n];
        // 初始化长度为1的字符串的最长回文子序列为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 初始化为对角线，自底向上遍历，j递增，i递减
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 边界情况
                if (j - i + 1 == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        // 如果i，j相等，[i+1, j-1]的最长回文子序列就是s[i..j]的最长回文子序列+2
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        // 如果i，j不相等，说明i，j不可能同时出现在s[i..j]的最长回文子序列中
                        // 把它俩分别加入 s[i+1..j-1] 中，看看哪个子串产生的回文子序列更长
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1]; 
    }
}