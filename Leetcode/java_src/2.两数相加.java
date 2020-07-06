/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy_head = new ListNode(0);
        ListNode curr_node = dummy_head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i = (l1 != null) ? l1.val : 0;
            int j = (l2 != null) ? l2.val : 0;
            int sum = i + j + carry;
            carry = sum / 10;
            curr_node.next = new ListNode(sum % 10);
            curr_node = curr_node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            curr_node.next = new ListNode(1);
        }
        return dummy_head.next;
    }
}
// @lc code=end

