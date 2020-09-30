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
    // 使用头插法即可，其中开始循环的节点为head.next，因为head不用判断
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            if (curr.val < x) {
                // 将curr结点移除
                ListNode nxt = curr.next;
                prev.next = nxt;
                // 将curr结点加入dummy和head之间
                dummy.next = curr;
                curr.next = head;
                head = curr;
                curr = nxt;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}