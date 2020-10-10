class Solution {
    // 本题思路：
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.equals("")) return 0;
        int left = 0;
        int right = 0;
        int res = 0;
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < chs.length) {
            char r = chs[right];
            right++;
            // 更新窗口数据
            window.put(r, window.getOrDefault(r, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(r) > 1) {
                char l = chs[left];
                left++;
                // 更新窗口数据
                window.put(l, window.get(l) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}