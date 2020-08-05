/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 逆序处理应该首先想到栈或递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode result = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int i = s1.isEmpty() ? 0 : s1.pop();
            int j = s2.isEmpty() ? 0 : s2.pop();
            int curr = i + j + carry;
            carry = curr / 10;
            curr %= 10;
            ListNode curr_node = new ListNode(curr);
            curr_node.next = result;
            result = curr_node;
        }
        return result;
    }
}
// @lc code=end

