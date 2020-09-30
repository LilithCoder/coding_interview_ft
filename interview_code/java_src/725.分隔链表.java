/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 本题思路：
// 如果链表有N个结点，则分隔的链表中每个部分中都有n/k个结点，且前N%k部分有一个额外的结点。我们可以用一个简单的循环来计算N。
// 现在对于每个部分，我们已经计算出该部分有多少个节点：width + (i < remainder ? 1 : 0)。我们创建一个新列表并将该部分写入该列表。
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode curr = root;
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        curr = root;
        int width = n / k;
        int remainder = n % k;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if (curr != null) {
                result[i] = curr;
                int size =  width + (remainder-- > 0 ? 1 : 0);
                for (int j = 0; j < size - 1; j++) {
                    curr = curr.next;
                }
                ListNode nxt = curr.next;
                curr.next = null;
                curr = nxt;
            } else {
                result[i] = null;
            }
        }
        return result;
    }
}