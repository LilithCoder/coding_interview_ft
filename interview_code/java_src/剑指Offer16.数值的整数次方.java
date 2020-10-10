class Solution {
    // 本题思路：
    // 快速幂
    // 参考lc Q50
    public double myPow(double x, int n) {
        // Java 代码中 int32 变量 n，因此当 n = -2147483648n=−2147483648 时执行 n=−n 会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        long m = n;
        if (m < 0) {
            return 1.0 / helper(x, -m);
        } else {
            return helper(x, m);
        }
    }
    public double helper(double x, long n) {
        if (n == 0) return 1.0;
        double temp = helper(x, n / 2);
        if (n % 2 == 1) {
            return x * temp * temp; 
        } else {
            return temp * temp;
        }
    }
}