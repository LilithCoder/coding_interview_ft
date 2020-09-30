class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, res, track, target, 0, 0);
        return res;
    }
    
    private void backtrack(int[] candidates, List<List<Integer>> res, LinkedList<Integer> track, int target, int temp, int start) {
        if (temp > target) return;
        if (temp == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            // 由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            backtrack(candidates, res, track, target, temp + candidates[i], i);
            track.removeLast();
        }
    }
}