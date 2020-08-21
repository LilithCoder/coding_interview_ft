class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) return "";
        int n = palindrome.length();
        for (int i = 0; i < n / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, n - 1) + 'b';
    }
}