/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int N = 0;
        ListNode curr = root;
        while (curr != null) {
            N++;
            curr = curr.next;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] result = new ListNode[k];
        curr = root;
        for (int i = 0; curr != null && i < k; i++) {
            result[i] = curr;
            int currSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < currSize - 1; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return result;
    }
}