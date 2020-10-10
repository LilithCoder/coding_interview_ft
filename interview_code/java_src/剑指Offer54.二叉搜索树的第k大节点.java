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
    // 反向中序遍历，得到第k个元素
    int count;
    int res;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        helper(root.left);
    }
}