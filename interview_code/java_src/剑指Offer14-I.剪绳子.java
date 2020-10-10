class Solution {
    // 本题思路：
    // 动态规划, dp[i]是指长度为i的绳子剪过后相乘的结果的最大值
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // 每一次dp[i]取的值就是每个剪掉一段的长度乘以剩下绳子的最大乘积值
                // 剩下那部分的绳子的最大乘积值可能还需要继续剪，或者就是干脆不剪，长度就是其最大乘积值
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}