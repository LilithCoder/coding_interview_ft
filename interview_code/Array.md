# Array
> [数组的遍历](#数组的遍历)

## 数组的遍历
---
[Leetcode Q485](java_src/485.最大连续1的个数.java) Max Consecutive Ones (最大连续1的个数)
```
用一个计数器 count 记录 1 的数量，另一个计数器 maxCount 记录当前最大的 1 的数量。
当我们遇到 1 时，count 加一。
当我们遇到 0 时：
将 count 与 maxCount 比较，maxCoiunt 记录较大值。
将 count 设为 0。
```


[Leetcode Q1](java_src/1.两数之和.java) Two Sum (两数之和)
> ByteDance
```
1. Brute force: loop twice the given array, find two number sum equals to the target, then return index pairs 
O(n^2):63 ms
```
```
2. Hash table: key: array element, value: index, loop the array only once, for each element, check whether the complement exists in the hashtable. if yes, just return the index pairs, the cons of this solution the cost of finding the complemnt is nearly constant time
O(n):2 ms
```

[Leetcode Q912](java_src/912.排序数组.java) 排序数组
```
快速排序
```

[Leetcode Q56](java_src/56.合并区间.java) 合并区间
```
我们用数组 merged 存储最终的答案。

首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：

如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；

否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
```
