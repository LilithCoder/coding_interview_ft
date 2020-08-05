/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
// t  c
// 1->2->3->4->5
// t     c
// 1->3->2->4->5
// t        c
// 1->4->3->2->5
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp_head = dummy;
        ListNode curr = head;
        for (int i = 1; i < m; i++) {
            temp_head = temp_head.next;
            curr = curr.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode temp_next = curr.next.next;
            ListNode temp_curr = curr.next;
            curr.next.next = null;
            curr.next = temp_next;
            temp_curr.next = temp_head.next;
            temp_head.next = temp_curr;
        }
        return dummy.next;
    }
}
// @lc code=end

