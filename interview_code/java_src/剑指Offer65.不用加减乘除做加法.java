class Solution {
    // 本题思路：
    // 位运算
    // 异或保留，与进位, 与为空时就返回
    // （和 s）==（非进位和 n）++（进位 c）。即可将 s=a+b 转化为：s = n + c
    // 循环求 n 和 c ，直至进位 c=0 ；此时 s=n ，返回 n 即可。
    public int add(int a, int b) {
        if (b == 0) return a;
        int non_carry = a ^ b; // 非进位
        int carry = (a & b) << 1; // 进位
        return add(non_carry, carry);
    }
}