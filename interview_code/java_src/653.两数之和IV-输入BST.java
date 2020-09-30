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
    public boolean findTarget(TreeNode root, int k) {
        // 遍历二叉树+HashSet
        HashSet<Integer> set = new HashSet<>();
        return pre_order_traverse(root, k, set);
    }
    
    public boolean pre_order_traverse(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return pre_order_traverse(root.left, k, set) || pre_order_traverse(root.right, k, set);
    }
}