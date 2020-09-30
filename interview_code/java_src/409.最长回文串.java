class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) count[c - 'A']++;
        int res = 0;
        // 在一个回文串中，只有最多一个字符出现了奇数次，其余的字符都出现偶数次。
        // 遍历：如果有字符出现奇数次且第一次这样的情况出现，那么可以将这个字符作为回文中心
        // 在发现了第一个出现次数为奇数的字符后，我们将 res 增加 1，这样 res 变为奇数，在后面发现其它出现奇数次的字符时，我们就不改变 res 的值了。
        for (int v: count) {
            res += v / 2 * 2;
            if (v % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}