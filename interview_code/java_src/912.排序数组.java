/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        quick_sort(nums, low, high);
        return nums;
    }
    private void quick_sort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot_idx = partition(nums, low, high);
            quick_sort(nums, low, pivot_idx - 1);
            quick_sort(nums, pivot_idx + 1, high);
        }
    }
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[++i];
        nums[i] = nums[high];
        nums[high] = temp;
        return i;
    }
}
// @lc code=end

