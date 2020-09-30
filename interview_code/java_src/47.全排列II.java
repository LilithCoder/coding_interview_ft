class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, track, visited);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> track, boolean[] visited) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 去重, 写 !visited[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择，之后还会被用到
            // 以[1,1,2]为例，当前层选择第二个1，那当第一个1没有使用过的时候才会跳过
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            track.addLast(nums[i]);
            visited[i] = true;
            backtrack(nums, res, track, visited);
            track.removeLast();
            visited[i] = false;
        }
    }
}