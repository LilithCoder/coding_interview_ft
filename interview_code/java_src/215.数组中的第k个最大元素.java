/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
// class Solution {
//     // 优先队列
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pqueue = new PriorityQueue<>();
//         for (int num : nums) {
//             pqueue.add(num);
//             if (pqueue.size() > k) pqueue.remove();
//         }
//         return pqueue.peek();
//     }
// }

class Solution {
    // 基于快速排序的选择
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        return quick_select(nums, low, high, nums.length - k);
    }
    public int quick_select(int[] nums, int low, int high, int k) {
        int pivot_index = partition(nums, low, high);
        if (pivot_index == k) return nums[pivot_index];
        return pivot_index > k ? quick_select(nums, low, pivot_index - 1, k) : quick_select(nums, pivot_index + 1, high, k);
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;
        return i + 1;
    }
}
// @lc code=end

