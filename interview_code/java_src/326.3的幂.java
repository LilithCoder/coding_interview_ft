class Solution {
    // 本题思路：
    // 找出数字 n 是否是数字 b 的幂的一个简单方法是，n%3 只要余数为 0，就一直将 n 除以 b。
    // 因此，应该可以将 n 除以 b x 次，每次都有 0 的余数，最终结果是 1。
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }
}