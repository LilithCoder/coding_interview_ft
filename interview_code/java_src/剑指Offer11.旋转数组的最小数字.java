class Solution {
    // 本题思路：
    // 二分查找
    // 当 nums[m] > nums[j] 时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j] 闭区间内，因此执行 i = m + 1
    // 当 nums[m] < nums[j] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[i, m] 闭区间内，因此执行 j = m
    // 当 nums[m] = nums[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点x 在 [i, m] 还是 [m + 1, j] 区间中。解决方案： 执行 j = j - 1
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            //只要右边比中间大，那右边一定是有序数组
            if (numbers[r] > numbers[mid]) {
                r = mid;
            } else if (numbers[r] < numbers[mid]) {
                l = mid + 1;
             //去重
            } else r--;
        }
        return numbers[l];
    }
}