/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) count[c]++;
        int ans = 0;
        for (int v: count) {
            ans += v / 2  * 2;
            if (v % 2 == 1 && ans % 2 == 0) ans++;
        }
        return ans;
    }
}
// @lc code=end

