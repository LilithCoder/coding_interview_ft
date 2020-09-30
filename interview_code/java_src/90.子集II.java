class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // 要用 start 参数排除已选择的数字
        int start = 0;
        // 为了去重，需要排序，相同的元素会相邻
        Arrays.sort(nums);
        backtrack(nums, res, track, start);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> track, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 去重
            if (i > start && nums[i] == nums[i - 1]) continue;
            track.addLast(nums[i]);
            backtrack(nums, res, track, i + 1);
            track.removeLast();
        }
    }
}