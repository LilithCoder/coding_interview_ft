class Solution {
    // 本题思路：
    // 跟两数相加一样
    // 只需要对两个整数模拟「竖式加法」的过程。
    // 将相同数位对齐，从低到高逐位相加，如果当前位和超过10，则向高位进一位
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (m >= 0 || n >= 0 || carry != 0) {
            int t1 = m >= 0 ? num1.charAt(m) - '0' : 0;
            int t2 = n >= 0 ? num2.charAt(n) - '0': 0;
            int sum = t1 + t2 + carry;
            carry = sum / 10;
            res.append(sum % 10);
            m--;
            n--;
        }
        return res.reverse().toString();
    }
}