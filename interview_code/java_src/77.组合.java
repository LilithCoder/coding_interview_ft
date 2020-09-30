class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) return res;
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, res, track, k, 0);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> track, int k, int start) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, res, track, k, i + 1);
            track.removeLast();
        }
    }
}