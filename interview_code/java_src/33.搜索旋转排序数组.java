/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        return search_helper(nums, target, left, right);
    }
    private int search_helper(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target <= nums[mid]) {
                return search_helper(nums, target, left, mid - 1);
            } else {
                return search_helper(nums, target, mid + 1, right);
            }
        } else {
            if (nums[mid] <= target && target <= nums[right]) {
                return search_helper(nums, target, mid + 1, right);
            } else {
                return search_helper(nums, target, left, mid - 1);
            }
        }
    }
}
// @lc code=end

