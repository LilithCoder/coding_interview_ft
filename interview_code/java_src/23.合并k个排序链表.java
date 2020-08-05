/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 分治策略
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int start = 0;
        int end = lists.length - 1;
        return merge_helper(lists, start, end);
    }
    private static ListNode merge_helper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        ListNode left = merge_helper(lists, start, mid);
        ListNode right = merge_helper(lists, mid + 1, end);
        return merge_two_list(left, right);
    }
    private static ListNode merge_two_list(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val > right.val) {
            right.next = merge_two_list(right.next, left);
            return right;           
        } else {
            left.next = merge_two_list(left.next, right);
            return left;
        }
    }
}

class Solution {
    // 顺序合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy_head = new ListNode(-1);
        if (lists == null || lists.length == 0) return null;
        for (int i = 0; i < lists.length; i++) {
            dummy_head.next = merge_two_list(dummy_head.next, lists[i]);
        }
        return dummy_head.next;
    }
    private static ListNode merge_two_list(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val > right.val) {
            right.next = merge_two_list(right.next, left);
            return right;           
        } else {
            left.next = merge_two_list(left.next, right);
            return left;
        }
    }
}

class Solution {
    // 优先队列
    public class node_comparator implements Comparator<ListNode> {
        @Override 
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pqueue = new PriorityQueue<>(new node_comparator());
        for (ListNode node : lists) {
            if (node != null) pqueue.add(node);
        }
        ListNode dummy_head = new ListNode(-1);
        ListNode curr_node = dummy_head;
        while (!pqueue.isEmpty()) {
            ListNode new_node = pqueue.remove();
            curr_node.next = new_node;
            curr_node = curr_node.next;
            if (new_node.next != null) {
                pqueue.add(new_node.next);
            }
        }
        return dummy_head.next;
    }
}

// @lc code=end

