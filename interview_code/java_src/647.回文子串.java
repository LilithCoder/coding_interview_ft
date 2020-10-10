class Solution {
    // 本题是找到一个字符串中所有的回文子串，而第 5 题是求解一个字符串中最长的回文子串，很明显求解出所有的字符串自然能够找到最大的
    // 这一题可以使用动态规划来进行解决：
    // 状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
    // 如果dp[i][j]相同，如果子串i+1, j-1的长度<2，则dp[i][j] = true，否则是否为true还要看dp[i+1][j-1]
    public int countSubstrings(String s) {
        int res = 0;
        char[] temp = s.toCharArray();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (temp[i] == temp[j]) {
                    if (j - 1 - (i + 1) + 1 < 2) {
                        dp[i][j] = true;
                        res++;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j] == true) res++;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return res;
    }
}