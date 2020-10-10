class Solution {
    // 本题思路：
    // 排序，由于数字出现超过一半，所以中位数一定是这个
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}