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
    // 快慢指针，让快针先走k步，然后快慢指针一起遍历直到链表尾部
    // 快慢指针之间的部分链表为需要旋转的部分，改下各个指针的指向
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        // 计算链表的长度
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        k %= size;
        // 让快指针先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 改变各个指针的指向，完成链表的旋转
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}