class Solution {
    // 本题思路：
    // 首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    // 翻转指定index范围的部分数组
    public void reverse(int[] nums, int low, int high) {
        int n = high - low + 1;
        for (int i = low; i < low + n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[high - (i - low)];
            nums[high - (i - low)] = temp;
        }
    }
}