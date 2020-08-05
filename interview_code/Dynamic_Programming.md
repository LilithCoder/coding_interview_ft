# Dynamic_Programming
> [数组中的动态规划](#数组中的动态规划),
> [矩阵中的动态规划](#矩阵中的动态规划)

## 数组中的动态规划
---
[Leetcode Q70](java_src/70.爬楼梯.java) 爬楼梯
```
用dp[i]表示爬到第x级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：dp(x)=dp(x−1)+dp(x−2)

它意味着爬到第x级台阶的方案数是爬到第x−1级台阶的方案数和爬到第x−2级台阶的方案数的和。很好理解，因为每次只能爬1级或2级，所以f(x)只能从f(x−1) 和f(x−2)转移过来，而这里要统计方案总数，我们就需要对这两项的贡献求和。
```

## 矩阵中的动态规划
---
[Leetcode Q221](java_src/221.最大正方形.java) Maximal Square (最大正方形)
> Huawei
```
用dp(i,j)表示以(i,j) 为右下角，且只包含1的正方形的边长最大值。如果我们能计算出所有dp(i,j)的值，那么其中的最大值即为矩阵中只包含1的正方形的边长最大值，其平方即为最大正方形的面积。
dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
```
![](pic/221.png)




[Leetcode Q5](java_src/5.最长回文子串.java) Longest Palindromic Substring (最长回文子串) 
> ByteDance, Huawei
```
1. Dynamic programming: dp[i][j] = (s[i] == s[j]) and (dp[i + 1][j - 1]), when traverse the dp matrix, you should consider that the result dp[i][j] always relies on the leftdown dp element(dp[i + 1][j - 1]), so we need to traverse column first then row, since j always > i, consider the pic below.
You should always consider the edge case, that is the length of substring[i + 1, j - 1] is 0 or 1, when meet with this situtation, dp[i][j] will be true, no need to rely on the value of dp[i + 1][j - 1]

```
![Alt text](pic/q5.png)

[Leetcode Q121](java_src/121.买卖股票的最佳时机.java) Best Time to Buy and Sell Stock (买卖股票的最佳时机) 
> ByteDance
```
1. Dynamic programming: 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}

```

[Leetcode Q53](java_src/53.最大子序和.java) 最大子序和
```
dp[i] 代表以第i个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：dp中最大
dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
```
