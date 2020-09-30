class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int n = nums.length;
        // 原数组排序, 枚举的三元组(a,b,c)满足a≤b≤c
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // 对于每一重循环而言，相邻两次枚举的元素不能相同，否则也会造成重复
            // 当第一个数字遇到相同元素，跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    // 去重
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int n = nums.length;
        // 原数组排序, 枚举的三元组(a,b,c)满足a≤b≤c
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // 对于每一重循环而言，相邻两次枚举的元素不能相同，否则也会造成重复
            // 当第一个数字遇到相同元素，跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 双指针，i为第二个数; k为第三个数字，从后向前移动
            int k = n - 1;
            for (int j = i + 1; j < n; j++) {
                // 当第二个数字遇到相同元素，跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 遇到三数之和不再大于0的时候，检查是否等于0
                while (nums[i] + nums[j] + nums[k] > 0 && k > j) k--;
                // 如果第三数字和第二数字重合，则退出循坏
                if (k == j) break;
                if (nums[i] + nums[j] + nums[k] == 0) result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
            }
        }
        return result;
    }
}