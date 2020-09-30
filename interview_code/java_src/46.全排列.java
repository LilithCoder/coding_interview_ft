class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, res, track);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.addLast(nums[i]);
            backtrack(nums, res, track);
            track.removeLast();
        }
    }
}