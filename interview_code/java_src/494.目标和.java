class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        backtrack(nums, 0, 0, S);
        return result;
    }
    // 选择列表{-, +} 路径 i(track_num), 目前的值(track_value)
    private void backtrack(int[] nums, int track_num, int track_value, int target) {
        // base case
        if (track_num == nums.length) {
            if (track_value == target) {
                result++;
            }
            return;
        }
        track_value += nums[track_num];
        backtrack(nums, track_num + 1, track_value, target);
        track_value -= nums[track_num];
        
        track_value -= nums[track_num];
        backtrack(nums, track_num + 1, track_value, target);
        track_value += nums[track_num];    
    }
}