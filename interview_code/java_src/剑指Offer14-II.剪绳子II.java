import java.math.BigInteger;
class Solution {
    // 本题思路：
    // 动态规划, dp[i]是指长度为i的绳子剪过后相乘的结果的最大值
    // 跟剪绳子1一样，只是把求最大值和求模写成大数的运算
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // 每一次dp[i]取的值就是每个剪掉一段的长度乘以剩下绳子的最大乘积值
                // 剩下那部分的绳子的最大乘积值可能还需要继续剪，或者就是干脆不剪，长度就是其最大乘积值
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}