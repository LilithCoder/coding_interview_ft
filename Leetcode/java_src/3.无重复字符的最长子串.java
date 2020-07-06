/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max_length = 0;
        while (left < s.length() && right < s.length()) {
            if (set.contains(s.charAt(right))) {
                max_length = Math.max(max_length, right - 1 - left + 1);
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
        }
        return max_length;
    }
}
// @lc code=end

