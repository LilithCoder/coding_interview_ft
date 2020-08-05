/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, result);
        return result;
    }
    private void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, track, result);
            track.removeLast();
        }
    }
}
// @lc code=end

