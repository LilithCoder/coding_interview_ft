class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以nums[i]这个结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i: dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}