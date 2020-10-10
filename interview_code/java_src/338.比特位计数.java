class Solution {
    // 本题思路：
    // 遍历一遍，计算每个数二进制1的个数
    // 计算二进制1的个数：
    // 因为n&(n-1)可以消除最后一个1，所以可以用一个循环不停地消除1同时计数，直到n变成0为止。
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = popcount(i);
        }
        return res;
    }
    // 计算一个数二进制1的个数：
    public int popcount(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}