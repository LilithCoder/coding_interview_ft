class Solution {
    // 本题思路：
    // 背包问题
    // 有一堆石头，分成两堆，如何分才能使两堆石头之间的重量差距最小
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone: stones) sum += stone;
        // 定义 dp[i] 重量上限为 i 时背包所能装载的最大石头重量
        int max = sum / 2;
        int[] dp = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int curr = stones[i];
            for (int j = max; j >= curr; j--) {
                dp[j] = Math.max(dp[j], dp[j - curr] + curr);
            }
        }
        return sum - 2 * dp[max];
    }
}