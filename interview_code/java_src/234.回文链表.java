/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 本题思路#1：递归倒序遍历链表
    // 链表兼具递归结构，链表其实也可以有前序遍历和后序遍历：
    // 如果想正序打印链表，可以在前序遍历位置写代码；反之，如果想倒序遍历链表，就可以在后序遍历位置操作
    // 模仿双指针实现回文判断的功能
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }
    private boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }
    
    // 本题思路#2：快慢指针遍历+同时翻转前半部分+与后半部分比较
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode temp = null;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 翻转
            temp.next = prev;
            prev = temp;
        }
        // fast指针在最末尾的时候，链表为奇数个结点，跳过中间结点
        if (fast != null) {
            slow = slow.next;
        }
        // temp为前半段翻转链表的起点，slow为前半段翻转的起点
        while (temp != null && slow != null) {
            if (temp.val != slow.val) {
                return false;
            } else {
                temp = temp.next;
                slow = slow.next;
            }
        }
        return true;
    }
}