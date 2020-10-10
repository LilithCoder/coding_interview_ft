/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 本题思路：
    // 访问每一个节点时，我们希望有一个变量 sum，存了「比当前节点值大的所有节点值的和」。
    // 反向的中序遍历，访问的节点值是递减的，之前访问的节点值都比当前的大，每次累加给sum，sum就会存下所有比自己大的节点值之和。
    // 遍历完会得到返回树，所以有返回值TreeNode
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}