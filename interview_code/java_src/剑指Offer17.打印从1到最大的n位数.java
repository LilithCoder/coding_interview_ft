class Solution {
    // 本题思路：
    // 注意变量类型的转换就行
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 1; i <= end; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}