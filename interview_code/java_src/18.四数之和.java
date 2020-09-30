class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            // 去除相邻重复元素
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            for (int second = first + 1; second < n; second++) {
                // 去除相邻重复元素
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                // 变成two sum了
                int third = second + 1;
                int fourth = n - 1;
                while (third < fourth) {
                    if (nums[first] + nums[second] + nums[third] + nums[fourth] == target) {
                        res.add(new ArrayList<>(List.of(nums[first], nums[second], nums[third], nums[fourth])));
                        third++;
                        fourth--;
                        // 前后双指针都去重
                        while (third < fourth && nums[third] == nums[third - 1]) third++;
                        while (third < fourth && nums[fourth] == nums[fourth + 1]) fourth--;
                    } else if (nums[first] + nums[second] + nums[third] + nums[fourth] > target) {
                        fourth--;
                    } else {
                        third++;
                    }
                }
            }
        }
        return res;
    }
}