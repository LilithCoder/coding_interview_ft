/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int high = search_right_index(nums, target, left, right);
        int low = search_left_index(nums, target, left, right);
        return new int[]{low, high};
    }
    private static int search_right_index(int[] nums, int target, int left, int right) {
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }
    private static int search_left_index(int[] nums, int target, int left, int right) {
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
// @lc code=end

