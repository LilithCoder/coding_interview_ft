## 二分查找
[大佬的技术总结](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/er-fen-cha-zhao-xiang-jie#yi-xun-zhao-yi-ge-shu-ji-ben-de-er-fen-sou-suo)
二分查找的框架：
```java
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
寻找左侧边界的二分搜索:
```java
int left_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0;
    int right = nums.length; // 注意

    while (left < right) { // 注意
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            right = mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid; // 注意
        }
    }
    return left;
}
```
寻找右侧边界的二分查找:
```java
int right_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0, right = nums.length;

    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            left = mid + 1; // 注意
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return left - 1; // 注意
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

[Leetcode Q875](java_src/875.爱吃香蕉的珂珂.java) 875.爱吃香蕉的珂珂 [大佬的解答](https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/koko-tou-xiang-jiao)
```
搜索左侧边界的二分查找

```

[Leetcode Q1011](java_src/1011.在D天内送达包裹的能力.java) 在D天内送达包裹的能力 [大佬的解答](https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/koko-tou-xiang-jiao)
```
搜索左侧边界的二分查找

```

[Leetcode Q69](java_src/69.x的平方根.java) 69.x的平方根 [大佬的解答](https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md#1-%E6%B1%82%E5%BC%80%E6%96%B9)
```
一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。

对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
```

[Leetcode Q744](java_src/744.寻找比目标字母大的最小字母.java) 744.寻找比目标字母大的最小字母 [大佬的解答](https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md#1-%E6%B1%82%E5%BC%80%E6%96%B9)
```
见代码
```

[Leetcode Q278](java_src/278.第一个错误的版本.java) 278.第一个错误的版本 [大佬的解答](https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md#1-%E6%B1%82%E5%BC%80%E6%96%B9)
```
见代码
```

[Leetcode Q153](java_src/153.寻找旋转排序数组中的最小值.java) 153.寻找旋转排序数组中的最小值 [大佬的解答](https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md#1-%E6%B1%82%E5%BC%80%E6%96%B9)
```
见代码
```

33. 搜索旋转排序数组
81. 搜索旋转排序数组 II
702. 搜索长度未知的有序数组
278. 第一个错误的版本
153. 寻找旋转排序数组中的最小值
154. 寻找旋转排序数组中的最小值 II
162. 寻找峰值
34. 在排序数组中查找元素的第一个和最后一个位置
658. 找到 K 个最接近的元素
35. 搜索插入位置
475. 供暖器