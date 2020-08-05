/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch: t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int result_start = 0;
        int result_end = 0;
        int min_window = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 增大窗口
            char temp = s.charAt(right);
            if (need.containsKey(temp)) {
                window.put(temp, window.getOrDefault(temp, 0) + 1);
                if (window.get(temp).compareTo(need.get(temp)) == 0) count++;
            }
            right++;
            while (count == need.size()) {
                // 更新窗口大小
                if (right - left < min_window) {
                    result_start = left;
                    result_end = right;
                    min_window = right - left;
                }
                char ch_left = s.charAt(left);
                if (need.containsKey(ch_left)) {
                    window.put(ch_left, window.get(ch_left) - 1);
                    if (window.get(ch_left) < need.get(ch_left)) count--;
                }
                left++;
            }
        }
        return min_window == Integer.MAX_VALUE ? "" : s.substring(result_start, result_end);
    }
}
// @lc code=end

