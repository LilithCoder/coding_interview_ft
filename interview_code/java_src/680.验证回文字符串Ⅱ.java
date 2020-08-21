class Solution {
    public boolean validPalindrome(String s) {
        if (s == null) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return is_palindrome(s, left, right - 1) || is_palindrome(s, left + 1, right);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean is_palindrome(String s, int left, int right) {
        while (left <= right) {
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