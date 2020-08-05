## 二分查找
[大佬的技术总结](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/er-fen-cha-zhao-xiang-jie#yi-xun-zhao-yi-ge-shu-ji-ben-de-er-fen-sou-suo)
二分查找的框架：
```
int binarySearch(int[] nums, int target) {
    int left = 0, right = ...;

    while(...) {
        <!-- 代码中 left + (right - left) / 2 就和 (left + right) / 2 的结果相同，但是有效防止了 left 和 right 太大直接相加导致溢出。 -->
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            ...
        } else if (nums[mid] < target) {
            left = ...
        } else if (nums[mid] > target) {
            right = ...
        }
    }
    return ...;
}
```

[Leetcode Q704](java_src/704.二分查找.java) 二分查找
```
二分查找是一种基于比较目标值和数组中间元素的教科书式算法。

如果目标值等于中间元素，则找到目标值。
如果目标值较小，继续在左侧搜索。
如果目标值较大，则继续在右侧搜索。
```

[Leetcode Q34](java_src/34.在排序数组中查找元素的第一个和最后一个位置.java) 在排序数组中查找元素的第一个和最后一个位置
```
二分查找是一种基于比较目标值和数组中间元素的教科书式算法。

如果目标值等于中间元素，则找到目标值。
如果目标值较小，继续在左侧搜索。
如果目标值较大，则继续在右侧搜索。

查找最左和最右
```



