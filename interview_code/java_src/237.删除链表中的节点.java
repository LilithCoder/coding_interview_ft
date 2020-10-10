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
    // 我们无法访问我们想要删除的节点 之前 的节点，我们始终不能修改该节点的 next 指针。
    // 相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}