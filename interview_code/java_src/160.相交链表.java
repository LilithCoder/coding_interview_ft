/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 本题思路：
    // A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。
    // 如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点 
    // 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            // 当l1到达链表的尾部时，将它重定位到链表B的头结点
            l1 = (l1 == null) ? headB : l1.next;
            // 当l2到达链表的尾部时，将它重定位到链表A的头结点
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}