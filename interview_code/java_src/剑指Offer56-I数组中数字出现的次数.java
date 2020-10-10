class Solution {
    // 本题思路：
    // 哈希表，记录元素和出现次数，遍历就完事了
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index= 0;
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1){
                ans[index++] = nums[i];
            }
        }
        return ans;
    }
}