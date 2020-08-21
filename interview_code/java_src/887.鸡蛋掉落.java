class Solution {
    public int superEggDrop(int K, int N) {
        // 假设dp[k][j] = N 代表有k个鸡蛋，操作次数为j时，包含F楼层的最大层数为N
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
}