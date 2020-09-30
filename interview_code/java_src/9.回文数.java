class Solution {
    public boolean isPalindrome(int x) {
        // 当x为负数的时候，x不是回文数；当x的末位为0且x不是0的时候，x不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        // 计算出数字的后半段的翻转
        int reverted_num = 0;
        while (reverted_num < x) {
            reverted_num = reverted_num * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123
        return x == reverted_num || x == reverted_num / 10;
    }
}