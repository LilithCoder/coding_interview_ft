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
#### 如何同时寻找缺失和重复的元素
[Leetcode Q645](java_src/645.错误的集合.java) 错误的集合
```
见代码
```

[Leetcode Q392](java_src/392.判断子序列.java) 判断子序列
```
见代码
```

[Leetcode Q238](java_src/238.除自身以外数组的乘积.java) 238.除自身以外数组的乘积
```
    // 本题思路：
    // 利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。
```

[Leetcode Q48](java_src/48.旋转图像.java) 48.旋转图像
```
    // 本题思路：
    // 先转置矩阵，然后翻转每一行
```

[Leetcode Q217](java_src/217.存在重复元素.java) 217.存在重复元素
```
    // 本题思路：
    // 先排序，相同的数字一定是相邻的
```

[Leetcode Q189](java_src/189.旋转数组.java) 189.旋转数组
```
    // 本题思路：
    // 首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
```

[Leetcode Q54](java_src/54.螺旋矩阵.java) 54.螺旋矩阵
```
    // 本题思路：
    // 可以模拟螺旋矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，当路径超出界限或者进入之前访问过的位置时，则顺时针旋转，进入下一个方向。
    // 判断路径是否进入之前访问过的位置需要使用一个与输入矩阵大小相同的辅助矩阵visited
    // 当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回。
```

[Leetcode Q74](java_src/74.搜索二维矩阵.java) 74.搜索二维矩阵
```
    // 本题思路：
    // 思路就是二分查找，一维数组和二维数组可以有index上转化
```

[Leetcode Q240](java_src/240.搜索二维矩阵II.java) 240.搜索二维矩阵II
```
    // 本题思路：
    // 从矩阵的右上角开始匹配，如果匹配到了，返回true
    // 如果值比target小，则说明这一行都比target小，row往下移一行
    // 如果值比target大，说明这一列都比target大，column往左移一行
```

[剑指Offer04](java_src/剑指Offer04.二维数组中的查找.java) 剑指Offer04.二维数组中的查找
```
    // 本题思路：
    // 从矩阵的右上角开始匹配，如果匹配到了，返回true
    // 如果值比target小，则说明这一行都比target小，row往下移一行
    // 如果值比target大，说明这一列都比target大，column往左移一行
```

[剑指Offer61](java_src/剑指Offer61.扑克牌中的顺子.java) 剑指Offer61.扑克牌中的顺子
```
    // 本题思路：
    // 这个数组中0可以当任何数用，所以当牌不连续的时候，它就可以替补一下，进而达到顺的要求。
    // 举个例子 0 0 1 2 4 5 6,这个数组中，0有两个，所以我们有俩万能替补，接着我们可以发现2-4之间不连续，缺个3，这样我们就可以把一个0放到哪里当三
    // 0 1 2 0 4 5 6,   0代替了3的位置，达到了连续的要求
    // 此 5 张牌是顺子的 充分条件 如下：
    // 除大小王外，所有牌 无重复 ；
    // 设此 5 张牌中最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：max - min < 5
    // 遍历五张牌，遇到大小王（即 0 ）直接跳过。
    // 判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 O(1)
    // 获取最大 / 最小的牌： 借助辅助变量，遍历统计即可。
```

[剑指Offer39](java_src/剑指Offer39.数组中出现次数超过一半的数字.java) 剑指Offer39.数组中出现次数超过一半的数字
```
    // 本题思路：
    // 排序，由于数字出现超过一半，所以中位数一定是这个
```

[剑指Offer66](java_src/剑指Offer66.构建乘积数组.java) 剑指Offer66.构建乘积数组
```
    // 本题思路：
    // 利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。
```

[剑指Offer31](java_src/剑指Offer31.栈的压入弹出序列.java) 剑指Offer31.栈的压入弹出序列
```
    // 本题思路：
    // 借用一个辅助栈 stackstack ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。
    // 入栈操作： 按照压栈序列的顺序执行。
    // 出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
```

[剑指Offer29](java_src/剑指Offer29.顺时针打印矩阵.java) 剑指Offer29.顺时针打印矩阵
```
    // 本题思路：
    // 可以模拟螺旋矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，当路径超出界限或者进入之前访问过的位置时，则顺时针旋转，进入下一个方向。
    // 判断路径是否进入之前访问过的位置需要使用一个与输入矩阵大小相同的辅助矩阵visited
    // 当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回。
```