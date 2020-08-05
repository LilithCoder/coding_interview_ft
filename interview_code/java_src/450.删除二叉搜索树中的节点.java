/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 当A是末端节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 当A只有一个非空子节点
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 当A有两个非空子节点
            if (root.left != null && root.right != null) {
                // 找到右子树的最小节点
                TreeNode successor = get_successor(root.right);
                // 把 root 改成 successor
                root.val = successor.val;
                // 转而去删除 successor
                root.right = deleteNode(root.right, successor.val);
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    private TreeNode get_successor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
// @lc code=end

