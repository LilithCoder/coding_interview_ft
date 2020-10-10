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

[Leetcode Q50](java_src/50.Powxn.java) 50.Pow(x,n)
```
    // 本题思路：
    // 快速幂算法
    // 当我们要计算 x^n 时，我们可以先递归地计算出 y=x^⌊n/2⌋，
    // 根据递归计算的结果，如果 n 为偶数，那么 x^n = y^2；
    // 如果 n 为奇数，那么 x^n = y^2 * x；
    // 递归的边界为n=0，任意数的 0 次方均为 1。
```

[剑指Offer53-I](java_src/剑指Offer53-I.在排序数组中查找数字I.java) 剑指Offer53-I.在排序数组中查找数字I
```
    // 本题思路：
    // 二分查找，寻找target的左右边界
    // 排序数组 nums 中的所有数字 target 形成一个窗口，记窗口的 左 / 右边界 索引分别为 left 和 right ，分别对应窗口左边 / 右边的首个元素。
    // 本题要求统计数字 target 的出现次数，可转化为：使用二分法分别找到 左边界 left 和 右边界 right ，易得数字 target 的数量为 right−left−1 
```

[剑指Offer16](java_src/剑指Offer16.数值的整数次方.java) 剑指Offer16.数值的整数次方
```
    // 本题思路：
    // 快速幂
    // 参考lc Q50 
```

[剑指Offer11](java_src/剑指Offer11.旋转数组的最小数字.java) 剑指Offer11.旋转数组的最小数字
```
    // 本题思路：
    // 二分查找
    // 当 nums[m] > nums[j] 时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j] 闭区间内，因此执行 i = m + 1
    // 当 nums[m] < nums[j] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[i, m] 闭区间内，因此执行 j = m
    // 当 nums[m] = nums[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点x 在 [i, m] 还是 [m + 1, j] 区间中。解决方案： 执行 j = j - 1 
```

[剑指Offer53-II](java_src/剑指Offer53-II.0～n-1中缺失的数字.java) 剑指 Offer 53 - II. 0～n-1中缺失的数字
```
    // 本题思路：
    // 有序数组搜索，二分搜索
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