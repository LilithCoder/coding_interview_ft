class Solution {
    // 本题思路：
    // 快速幂算法
    // 当我们要计算 x^n 时，我们可以先递归地计算出 y=x^⌊n/2⌋，
    // 根据递归计算的结果，如果 n 为偶数，那么 x^n = y^2；
    // 如果 n 为奇数，那么 x^n = y^2 * x；
    // 递归的边界为n=0，任意数的 0 次方均为 1。
    public double myPow(double x, int n) {
        long m = n;
        if (m < 0) {
            return 1.0 / helper(x, -m);
        } else {
            return helper(x, m);
        }
    }
    public double helper(double x, long m) {
        if (m == 0) return 1.0;
        double temp = helper(x, m / 2);
        if (m % 2 == 1) {
            return x * temp * temp;
        } else {
            return temp * temp;
        }
    }
}