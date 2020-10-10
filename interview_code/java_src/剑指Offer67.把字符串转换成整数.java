class Solution {
    // 本题思路：
    // 去掉前导空格
    // 再是处理正负号
    // 识别数字，注意越界情况。
    public int strToInt(String str) {
        char[] chs = str.toCharArray();
        int n = chs.length;
        int index = 0;
        // 去除前导空格
        while (index < n && chs[index] == ' ') {
            index++;
        }
        // 去除完前导空格到末尾了
        if (index == n) {
            return 0;
        }
        // 判断空格后的第一个字符
        boolean negative = false;
        if (chs[index] == '-') {
            negative = true;
            index++;
        } else if (chs[index] == '+') {
            index++;   
        } else if (!Character.isDigit(chs[index])) {
            return 0;
        }
        int ans = 0;
        while (index < n && Character.isDigit(chs[index])) {
            int digit = chs[index] - '0';
            // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
            // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
            // Integer.MAX_VALUE: 2^31-1; Integer.MIN_VALUE: -2^31
            if (ans > (Integer.MAX_VALUE - digit) / 10) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ans = ans * 10 + digit;
            index++;
        }
        return negative ? -ans : ans;
    }
}