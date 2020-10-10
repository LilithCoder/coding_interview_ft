class Solution {
    // 本题思路：
    // 双指针，盛水的容积等于双指针中较小值乘以指针间距离
    // 每迭代一次就改变双指针中较小的那个
    // 保持res记录最大盛水容积
    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}