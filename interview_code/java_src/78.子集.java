class Solution {
    // 回溯算法模版
    // result = []
    // def backtrack(路径, 选择列表):
    //     if 满足结束条件:
    //         result.add(路径)
    //         return
    //     for 选择 in 选择列表:
    //         做选择
    //         backtrack(路径, 选择列表)
    //         撤销选择
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // 要用 start 参数排除已选择的数字
        int start = 0;
        backtrack(nums, track, start, res);
        return res;
    }
    private void backtrack(int[] nums, LinkedList<Integer> track, int start, List<List<Integer>> res) {
        // 结果集里面增加结果是不可以写成res.add(track);，因为是引用类型，最终值全部统一
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, track, i + 1, res);
            track.removeLast();
        }
    }
}