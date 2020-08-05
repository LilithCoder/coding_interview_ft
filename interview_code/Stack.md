## Stack
[Leetcode Q20](java_src/20.有效的括号.java) Valid Parentheses (有效的括号)
> ByteDance
```
Using stack to solve this problem, the Symmetry of these signs
```
[Leetcode Q225](java_src/225.用队列实现栈.java) Implement Stack using Queues (用队列实现栈)
> ByteDance
```
用 先入先出 实现 先入后出。
栈是一种 后进先出的数据结构，栈内元素从顶端压入（push），从顶端弹出（pop）。一般我们用数组或者链表来实现栈，但是这篇文章会来介绍如何用队列来实现栈。队列是一种与栈相反的 先进先出的数据结构，队列中元素只能从 后端（rear）入队（push），然后从 前端（front）端出队（pop）。为了满足栈的特性，我们需要维护两个队列 q1 和 q2。同时，我们用一个额外的变量来保存栈顶元素。
弹出：我们需要把栈顶元素弹出，就是 q1 中最后入队的元素。
考虑到队列是一种 FIFO 的数据结构，最后入队的元素应该在最后被出队。因此我们需要维护另外一个队列 q2，这个队列用作临时存储 q1 中出队的元素。q2 中最后入队的元素将作为新的栈顶元素。接着将 q1 中最后剩下的元素出队。我们通过把 q1 和 q2 互相交换的方式来避免把 q2 中的元素往 q1 中拷贝。
```
![](pic/q225-1.png)
![](pic/q225-2.png)

[Leetcode Q445](java_src/445.两数相加 II.java) 两数相加 II
> ByteDance
```
表示指针的时候直接用ListNode result = null;有时候不一定用dummy head，这个指针和dummy head不同
这道题不允许反转链表，那么就用栈
最妙的地方是：倒着把链表连起来
curnode = ListNode(cur)
curnode.next = ans
ans = curnode
```