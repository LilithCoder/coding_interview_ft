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
    // 快慢指针,用快指针跳过那些有重复数组,慢指针负责和快指针拼接!
    // 为了防止删除头结点的极端情况发生，先创建空结点dummy
    // -1 -> 1 -> 2 -> 3 -> 3 -> 4
    //  s    f
    //       s    f
    //            s    f
    //            s         f
    //            s -----------> f
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                while (fast != null && fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                slow.next = fast;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }
}