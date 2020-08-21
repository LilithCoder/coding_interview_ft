class Solution {
    public int change(int amount, int[] coins) {
        int size = coins.length;
        int[][] dp = new int[size + 1][amount + 1];
        for (int i = 0; i <= size; i++) dp[i][0] = 1;
        for (int j = 1; j <= amount; j++) dp[0][j] = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= amount; j++) {
                // 如果背包放不下coins[i]
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果背包放得下，放与不放的可能相加
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[size][amount];
    }
}