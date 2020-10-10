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
    // 本题思路：
    // 弄个辅助函数测二叉树的左右树高
    // 一旦左右树高大于1，则不平衡
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res = true;
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left, right) + 1;
    }
}