class Solution {    
    // 本题思路：
    // 二分查找，寻找target的左右边界
    // 排序数组 nums 中的所有数字 target 形成一个窗口，记窗口的 左 / 右边界 索引分别为 left 和 right ，分别对应窗口左边 / 右边的首个元素。
    // 本题要求统计数字 target 的出现次数，可转化为：使用二分法分别找到 左边界 left 和 右边界 right ，易得数字 target 的数量为 right−left−1 
    public int search(int[] nums, int target) {
        // 寻找左侧边界
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 终止条件: left == right + 1
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) return 0;
        int res_left = left;
        
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        // 终止条件: right == left - 1
        // 检查出界情况
        if (right < 0 || nums[right] != target) return 0;
        int res_right = right;
        
        return res_right - res_left + 1;
    }
}