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
    // 每一个经过当前递归root结点的最大路径和是max(左子树的最大贡献值，右子树的最大贡献值)+当前root的值
    // 这个路径能路过的顶峰就是root
    // 最大贡献值是当前子树的root结点开始向下最大路径和
    // 每次递归返回的是最大贡献值，然后维持一个变量来记录经过当前递归root结点的最大路径和
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        
        // 左子树的最大贡献值
        int left = helper(root.left);
        
        // 右子树的最大贡献值
        int right = helper(root.right);
        
        if (left < 0 && right < 0) {
            // 如果的两个子树的最大贡献值都为负数，最大路径和就是root的val
            res = Math.max(res, root.val);
            return root.val;
        } else if (left >= 0 && right < 0) {
            // 只有一个子树的最大贡献值为负数
            res = Math.max(res, left + root.val);
        } else if (right >= 0 && left < 0) {
            // 只有一个子树的最大贡献值为负数
            res = Math.max(res, right + root.val);
        } else if (left >= 0 && right >= 0) {
            // 当两个子数都为非负
            res = Math.max(res, left + right + root.val);
        }
        return Math.max(left, right) + root.val;
    }
}