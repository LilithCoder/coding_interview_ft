class Solution {
    // 本题思路：
    // 两个整数之间的汉明距离是对应位置上数字不同的位数。
    // 根据以上定义，提出一种 XOR 的位运算，当且仅当输入位不同时输出为 1。
    // 计算 x 和 y 之间的汉明距离，可以先计算 x OR y，然后统计结果中等于 1 的位数。
    public int hammingDistance(int x, int y) {
        return count_bit(x ^ y);
    }
    public int count_bit(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}