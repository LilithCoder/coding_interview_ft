/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 本题思路：
    // 为奇偶链表分别建立双指针
    // 第一个结点作为奇数链的头结点，第二个结点作为偶数链的头结点
    // 遍历完之后，将奇数链的尾结点连接偶数链的头结点，偶数链的尾结点为空，返回奇数链的头
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd_head = head;
        ListNode odd_tail = head;
        ListNode even_head = head.next;
        ListNode even_tail = head.next;
        while (odd_tail.next != null && even_tail.next != null) {
            odd_tail.next = even_tail.next;
            odd_tail = odd_tail.next;
            even_tail.next = odd_tail.next;
            even_tail = even_tail.next;
        }
        odd_tail.next = even_head;
        return odd_head;
    }
}