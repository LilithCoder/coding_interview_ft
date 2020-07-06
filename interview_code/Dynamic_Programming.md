## Dynamic_Programming
[Leetcode Q5](java_src/5.最长回文子串.java) Longest Palindromic Substring (最长回文子串) 
> ByteDance, Huawei
```
1. Dynamic programming: dp[i][j] = (s[i] == s[j]) and (dp[i + 1][j - 1]), when traverse the dp matrix, you should consider that the result dp[i][j] always relies on the leftdown dp element(dp[i + 1][j - 1]), so we need to traverse column first then row, since j always > i, consider the pic below.
You should always consider the edge case, that is the length of substring[i + 1, j - 1] is 0 or 1, when meet with this situtation, dp[i][j] will be true, no need to rely on the value of dp[i + 1][j - 1]

```
![Alt text](pic/q5.png)