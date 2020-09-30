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
    // 先用正向遍历得到数组大小，再后序递归，反向遍历链表
    int index = 0;
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        int[] res = new int[size];
        // 用递归的方式逆向遍历链表
        traverse(head, res);
        return res;
    }
    public void traverse(ListNode head, int[] res) {
        if (head == null) return;
        traverse(head.next, res);
        res[index++] = head.val;
    }
}