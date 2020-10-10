/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    // 本题思路：
    // 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点；
    // 双向链表：构建相邻节点（设前驱节点pre，当前节点cur）关系
    // 循环链表：head.left = tail 和 tail.right = head
    Node head = null;
    Node tail = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    public void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        // 当遍历的是第一个链表元素
        if (prev == null) {
            head = root;
            prev = root;
            tail = root;
        } else {
            // 当遍历的不是第一个链表元素
            prev.right = root;
            root.left = prev;
            prev = root;
            tail = root;
        }
        dfs(root.right);
    }
}