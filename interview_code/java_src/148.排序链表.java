/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 递归实现链表归并排序
    // 递归排序三部曲：1，快慢指针找中点；2，递归调用mergeSort，3，合并两个链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // 1.分割步骤：
        // 使用快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next_head = slow.next;
        // 找到中点后，将链表切断
        slow.next = null;
        
        // 2.Conquer步骤
        ListNode left = sortList(head);
        ListNode right = sortList(next_head);
        
        // 3.归并步骤
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = (left != null) ? left : right;
        return dummy.next;
    }
    
    //============================================================
    // 自底向上非递归 归并排序 空间复杂度O(1)
    // [4,3,1,7,8,9,2,11,5,6]
    // step=1: (3->4)->(1->7)->(8->9)->(2->11)->(5->6)
    // step=2: (1->3->4->7)->(2->8->9->11)->(5->6)
    // step=4: (1->2->3->4->7->8->9->11)->5->6
    // step=8: (1->2->3->4->5->6->7->8->9->11)
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 计算链表的长度
        ListNode temp = dummy.next;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        // 开始切割和合并
        for (int size = 1; size < length; size *= 2) {
            ListNode curr = dummy.next;
            ListNode tail = dummy;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = cut(curr, size); // 链表切掉size 剩下的返还给right
                curr = cut(right, size); // 链表切掉size 剩下的返还给cur
                // 归并
                tail.next = merge(left, right);
                while (tail.next != null) {
                    tail = tail.next; // 保持最尾端
                }
            }
        }
        return dummy.next;
    }
    public static ListNode cut(ListNode head, int n){
        if(n <= 0) return head;
        ListNode p = head;
        // 往前走n-1步
        while(--n > 0 && p != null){
            p = p.next;
        }
        if(p == null) return null;
        ListNode next = p.next;
        p.next = null;
        return next;    
    }
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            } else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 == null){
            p.next = list2;
        } else{
            p.next = list1;
        }
        return dummyHead.next;
    }
}