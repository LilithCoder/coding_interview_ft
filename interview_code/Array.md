## Array
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