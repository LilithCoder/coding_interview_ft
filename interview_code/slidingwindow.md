## 滑动窗口
[大佬的技术总结](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/hua-dong-chuang-kou-ji-qiao-jin-jie)
滑动窗口的框架：
```
滑动窗口算法就是专门处理子串/子数组问题
当需要检测任意子字符串，用滑动窗口
滑动窗口算法无非就是双指针形成的窗口扫描整个数组/子串
int left = 0, right = 0;

while (right < s.size()) {`
    // 增大窗口
    window.add(s[right]);
    right++;

    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
```

[Leetcode Q76](java_src/76.最小覆盖子串.java) 最小覆盖子串
```
滑动窗口的框架
```

[Leetcode Q567](java_src/567.字符串的排列.java) 字符串的排列 Permutation in String
```
滑动窗口的框架
```

[Leetcode Q438](java_src/438.找到字符串中所有字母异位词.java) 找到字符串中所有字母异位词 Find All Anagrams in a String
```
滑动窗口的框架
```

[剑指Offer57-II](java_src/剑指Offer57-II.和为s的连续正数序列.java) 剑指Offer57-II.和为s的连续正数序列
```
    // 本题思路：
    // 滑动窗口
    // 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
    // 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
    // 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果，那么我们已经找到了一个 i 开头的序列，也是唯一一个 i 开头的序列，接下来需要找 i+1 开头的序列，所以窗口的左边界要向右移动
```

[剑指Offer48](java_src/剑指Offer48.最长不含重复字符的子字符串.java) 剑指Offer48.最长不含重复字符的子字符串
```
    // 本题思路：
    // 滑动窗口
```

[剑指Offer59-I](java_src/剑指Offer59-I.滑动窗口的最大值.java) 剑指Offer59-I.滑动窗口的最大值
```
    // 本题思路：
    // 单调队列模板题，求滑动窗口的最值。
```