/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch: s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int right = 0;
        int left = 0;
        int count = 0;
        while (right < s2.length()) {
            char right_elem = s2.charAt(right);
            if (need.containsKey(right_elem)) {
                window.put(right_elem, window.getOrDefault(right_elem, 0) + 1);
                if (window.get(right_elem).compareTo(need.get(right_elem)) == 0) count++;
            }
            right++;
            // 如果窗口大小等于s1长度，则判断窗口的内容是否符合条件
            if (right - left == s1.length()) {
                if (count == need.size()) return true;
                // 收缩并更新左窗口
                char left_elem = s2.charAt(left);
                if (need.containsKey(left_elem)) {
                    if (window.get(left_elem) == need.get(left_elem)) count--;
                    window.put(left_elem, window.get(left_elem) - 1);
                }
                left++;
            }
        }
        return false;
    }
}
// @lc code=end

