class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        int size = nums.length;
        boolean[][] dp = new boolean[size + 1][sum + 1];
        for (int i = 0; i <= size; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 背包容量足: 不装 || 装
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[size][sum];
    }
}