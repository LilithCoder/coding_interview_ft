class Solution {
    // 本题思路：
    // 求乘积的最大值，示例中负数的出现，告诉我们这题和 53 题不一样了，一个正数乘以负数就变成负数，即：最大值乘以负数就变成了最小值；
    // 因此：最大值和最小值是相互转换的，这一点提示我们可以把这种转换关系设计到「状态转移方程」里去；
    // 在原始的状态设计后面多加一个维度，减少分类讨论，降低解决问题的难度。
    // dp[i][j]：以 nums[i] 结尾的连续子数组的最值，计算最大值还是最小值由 j 来表示，j 就两个值；
    // 当 j = 0 的时候，表示计算的是最小值；
    // 当 j = 1 的时候，表示计算的是最大值。
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
            } else if (nums[i] < 0) {
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
            } else {
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}