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
    // 双重递归：首先先序递归遍历每个节点，再以每个节点作为起始点递归寻找满足条件的路径。
    // 解决了以根节点开始的所有路径后，就要找以根节点的左孩子和右孩子开始的所有路径
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }
    private void helper(TreeNode root, int sum) {
        if (root == null) return;
        if (sum - root.val == 0) {
            result++;
        }
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }
}