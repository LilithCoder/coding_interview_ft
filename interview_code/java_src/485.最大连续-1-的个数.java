/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max_count = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else if (i == 0) {
                max_count = Math.max(max_count, count);
                count = 0;
            }
        }
        return Math.max(max_count, count);
    }
}
// @lc code=end

