class Solution {
    // 本题思路：
    // dp[i][j]，表示投掷完 i 枚骰子后，点数 j 的出现次数。
    public double[] twoSum(int n) {
        if (n == 1) return new double[] {1 / 6.0, 1 / 6.0, 1 / 6.0, 1 / 6.0, 1 / 6.0, 1 / 6.0};
        // 投完n次骰子后，出现的可能的最大点数为 6*n
        int[][] dp = new int[n + 1][6 * n + 1];
        
        // 投完n次骰子后，出现的可能的点数为[n, 6*n]
        double[] res = new double[5 * n + 1];
        
        // 全排列的次数
        double all = Math.pow(6, n);
        
        // 初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    // 当当前点数减去k还不满足1的时候，则直接跳出
                    if (j - k < 1) break;
                    dp[i][j] += dp[i - 1][j - k];
                    // j - i为index
                    if (i == n) res[j - i] = dp[i][j] / all;
                }
            }
        }
        return res;
    }
}