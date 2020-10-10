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
    // 先序遍历树 A 中的每个节点 n_A ；（对应函数 isSubStructure(A, B)）
    // 判断树 A 中 以 n_A 为根节点的子树 是否包含树 B 。（对应函数 recur(A, B)）
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public boolean recur(TreeNode A, TreeNode B) {
        // 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true
        if (B == null) return true;
        // 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false
        if (A == null) return false;
        return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
    }
}