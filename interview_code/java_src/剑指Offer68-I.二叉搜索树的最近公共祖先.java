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
    // p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    // p=root，且 q 在 root 的左或右子树中；
    // q=root，且 p 在 root 的左或右子树中；
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // p和q都在右子树
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // p和q都在左子树
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // p和q在各一边
        return root;
    }
}