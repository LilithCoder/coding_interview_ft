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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    // 返回左右两个子树是否对称
    private boolean helper(TreeNode left, TreeNode right) {
        // 都为空指针则返回 true
        if (left == null && right == null) return true;
        // 只有一个为空则返回 false
        if (left == null || right == null) return false;
        // 判断两个指针当前节点值是否相等；判断 A 的右子树与 B 的左子树是否对称；判断 A 的左子树与 B 的右子树是否对称
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}