/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 本题思路：
    // 遍历链表，删除结点
    // 通过哨兵节点来解决删除链表头部的结点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                ListNode nxt = curr.next;
                prev.next = nxt;
                curr = nxt;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}