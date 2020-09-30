/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 本题思路：
// 链表中数位的顺序与我们做加法的顺序是相反的，为了逆序处理所有数位，可以使用栈
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode result = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int val1 = s1.isEmpty() ? 0 : s1.pop();
            int val2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            ListNode curr = new ListNode(digit);
            curr.next = result;
            result = curr;
        }
        if (carry == 1) {
            ListNode c = new ListNode(1);
            c.next = result;
            result = c;
        }
        return result;
    }
}