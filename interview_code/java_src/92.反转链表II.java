/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 本题思路：
// 基本上就是链表的指针转换+链表反转
// 反转链表的迭代方法背下来就完事了
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        // 让curr先到达m位置，prev处于m-1的位置
        for (int i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        // 保存temp1为m-1
        // 保存temp2为m
        ListNode temp1 = prev;
        ListNode temp2 = curr;
        // 遍历+反转一直到prev为n，curr为n+1
        for (int i = 0; i <= n - m; i++) {
            // 由于curr的next指针会反转，curr导致到达不了下一个结点
            // 所以需要提前保存curr的下一个结点
            ListNode nxt = curr.next;
            // 实现反转
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        // 这时候m到n这段链表已经反转好了
        // 只需要将这段链表和前后两端链表正确链接即可
        // 这时候就需要用要temp1和temp2
        // curr现在是最后面那段链表的头结点
        // prev为反转好的这段链表的头结点
        if (temp1 != null) {
            temp1.next = prev;
        } else {
            // 当m的位置为1，prev为null，反转的链表的头结点prev就直接等于head了
            head = prev;
        }
        
        temp2.next = curr;
        return head;
    }
}