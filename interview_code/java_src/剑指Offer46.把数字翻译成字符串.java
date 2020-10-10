class Solution {
    // 本题思路：
    // 动态规划，dp[i]代表以xi为结尾的数字的翻译方案数量
    // dp[i] = dp[i - 1] + dp[i - 2], 当Xi-1 Xi可被翻译
    // dp[i] = dp[i - 1], 当Xi-1 Xi不可被翻译
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1];
			}
        }
        return dp[n];
    }
}