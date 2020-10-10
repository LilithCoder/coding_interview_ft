class Solution {
    // 本题思路：
    // 丑数 = 某较小丑数 × 某因子
    // 用三指针，第一个丑数是1，以后的丑数都是基于前面的小丑数分别乘2，3，5构成的。
    // 我们每次添加进去一个当前计算出来个三个丑数的最小的一个，并且是谁计算的，谁指针就后移一位。
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int t2 = dp[a] * 2;
            int t3 = dp[b] * 3;
            int t5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(t2, t3), t5);
            if (dp[i] == t2) a++;
            if (dp[i] == t3) b++;
            if (dp[i] == t5) c++;
        }
        return dp[n - 1];
    }
}