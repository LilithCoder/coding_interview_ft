class Solution {
    // 本题思路：
    // 利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。
    public int[] constructArr(int[] a) {
        if (a.length == 0 || a == null) return new int[] {};
        int n = a.length;
        int[] res = new int[n];
        
        // 索引左侧所有数字的乘积
        int[] left = new int[n];
        left[0] = 1;
        // 索引右侧所有数字的乘积
        int[] right = new int[n];
        right[n - 1] = 1;
        
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}