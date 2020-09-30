/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
// class Solution {
//     // 迭代
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         ListNode curr = head;
//         while (curr != null) {
//             ListNode next_node = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next_node;
//         }
//         return prev;
//     }
// }

class Solution {
    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode reversed_head = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversed_head;
    }
}
// @lc code=end

