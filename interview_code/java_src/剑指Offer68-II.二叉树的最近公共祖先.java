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
    // 两个节点 p,q 分为两种情况：
    // p 和 q 在相同子树中
    // p 和 q 在不同子树中
    // 从根节点遍历，递归向左右子树查询节点信息
    // 递归终止条件：如果当前节点为空或等于 p 或 q，则返回当前节点
    // 递归遍历左右子树，如果左右子树查到节点都不为空，则表明 p 和 q 分别在左右子树中，因此，当前节点即为最近公共祖先；
    // 如果左右子树其中一个不为空，则返回非空节点。
        
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归的含义是指在以root为根结点的子树是否存在p或者q，如果都存在，返回其公共祖先，如果只存在一个，返回那个找到的结点，否则返回null
        // 终止条件
        if (root == null) return null;
        if (root == p || root == q) return root;
        // 递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左子树和右子树都存在p或q，所有当前root为最近公共祖先
        if (left != null && right != null) return root;
        // 如果左子树和右子树都不存在p或q，返回null
        if (left == null && right == null) return null;
        // 若只存在其中一个
        return left != null ? left : right;
        
    }
}