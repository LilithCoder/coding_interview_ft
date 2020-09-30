class Solution {
    // 本题思路：
    // 判断回文串显然是用双指针的，i从前往后遍历，j从后往前遍历。难点就是怎么去判断删除一个元素后的字符串是不是回文串
    // 以"abdda"这个串为例，此时i指向'b'，j指向'd'，发现不对了。但是有一次删除的机会。
    // 此时子串范围为(i+1, j)或(i, j-1)的俩子串只要有任意一个是回文串，则结果就是回文串，否则就不是。
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 有一次删除的机会
                // 此时子串范围为(i+1, j)或(i, j-1)的俩子串只要有任意一个是回文串，则结果就是回文串，否则就不是。
                return is_palindrome(s, left, right - 1) || is_palindrome(s, left + 1, right);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean is_palindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}