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


