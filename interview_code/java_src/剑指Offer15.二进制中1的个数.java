public class Solution {
    // you need to treat n as an unsigned value
    // 本题思路：
    // 位运算，每一步去除该数字二进制最后一个1
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}