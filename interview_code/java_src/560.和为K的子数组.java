class Solution {
    public int subarraySum(int[] nums, int k) {
        // (前缀和，出现的次数)
        Map<Integer, Integer> prefix_sum = new HashMap<>();
        int sum = 0;
        prefix_sum.put(0, 1);
        int res = 0;
        for (int num: nums) {
            // 以当前元素为末位的子数组的和
            sum += num;
            // 目前map里的前缀和只有i-1的范围
            if (prefix_sum.containsKey(sum - k)) {
               res += prefix_sum.get(sum - k); 
            }
            // 因为有负数的可能，put要放在后面，当map中找的前缀和的时候，必须找index小于当前元素的前缀和
            prefix_sum.put(sum, prefix_sum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // 计算以i为结尾的和为k的子数组的个数
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }
}