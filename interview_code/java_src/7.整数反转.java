/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 8) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -7) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}
// @lc code=end

