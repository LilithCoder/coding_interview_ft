class Solution {
    // 本题思路：
    // 只有当一个数是连续序列的第一个数的情况下才会进入内层循环，然后在内层循环中匹配连续序列中的数，
    // 因此数组中的每个数只会进入内层循环一次。根据上述分析可知，总时间复杂度为 O(n)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int res = Integer.MIN_VALUE;
        for (int num: set) {
            int count = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(++num)) {
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}