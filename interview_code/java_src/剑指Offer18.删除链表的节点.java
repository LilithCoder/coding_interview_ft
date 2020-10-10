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
    // 删除链表中的元素，需要用dummy head来处理删除头结点的问题
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                ListNode nxt = curr.next;
                pre.next = nxt;
                curr = nxt;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}