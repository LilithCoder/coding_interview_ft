/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 本题思路：
// 快慢指针，保持快慢指针之间有恒定的间隔
// 因为涉及到删除结点，很可能删除的是头结点，所以我们用到哨兵结点
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        // 第一个指针从列表的开头向前移动n+1步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        // 同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}