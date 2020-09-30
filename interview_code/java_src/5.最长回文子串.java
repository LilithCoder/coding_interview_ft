class Solution {
    // 这题的思路：
    // 1. 先是暴力，遍历所有子串，如果该子串为回文串，记录长度，找到最长的回文子串
    // 2. 然后再优化，由于回文这个性质很容易想到最优子结构，用动态规划解题
    // 3. 动态规划；定义dp状态，写出状态转移方程，初始化dp，自底向上，将子问题按规模排序
    public String longestPalindrome(String s) {
        // 当字符串长度为0或者1的时候，字符串本身就为最长回文子串
        if (s.length() == 0 || s.length() == 1) return s;
        int n = s.length();
        // 动态规划状态定义：dp[i][j] 表示子串 s[i..j] 是否为回文子串
        boolean[][] dp = new boolean[n][n];
        // 初始化：[i, j]子串长度为1的情况
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max_i = 0;
        int max_j = 0;
        int max = Integer.MIN_VALUE;
        // 初始化为对角线，自底向上遍历，j递增，i递减
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                // 考虑边界情况，由于保持i<j，所以边界情况是[i, j]子串长度为2时
                // [i, j]子串长度为1的情况已经考虑过了，在初始化中
                if (j - i + 1 == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // 状态转移方程
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return s.substring(max_i, max_j + 1);
    }
}