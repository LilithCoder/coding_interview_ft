class Solution {
    // 本题思路：
    // 和旋转数组思路是一样的
    // 旋转字符串，分为三步，先旋转全部，然后旋转分割的两部分
    public String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        int m = arr.length;
        n %= m;
        reverse(arr, 0, m - 1);
        reverse(arr, 0, m - 1 - n);
        reverse(arr, m - n, m - 1);
        return String.valueOf(arr);
    }
    public void reverse(char[] str_arr, int start, int end) {
        int n = end - start + 1;
        for (int i = start; i < start + n / 2; i++) {
            char temp = str_arr[i];
            str_arr[i] = str_arr[end - (i - start)];
            str_arr[end - (i - start)] = temp;
        }
    }
}