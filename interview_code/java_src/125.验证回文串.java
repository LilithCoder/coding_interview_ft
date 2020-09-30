class Solution {
    // 本题思路：
    // 遇到验证回文串，用双指针
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 使用双指针。在移动任意一个指针时，需要不断地向另一指针的方向移动，直到遇到一个字母或数字字符，或者两指针重合为止
        while (left < right) {
            // 每次将指针移到下一个字母字符或数字字符，再判断这两个指针指向的字符是否相同
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}