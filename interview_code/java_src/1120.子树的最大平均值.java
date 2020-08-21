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
    double result = 0;
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return result;
    }
    // 后序遍历：
    private int[] helper(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) return arr;
        
        // 每次遍历返回当前子树的元素和和节点个数
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        // 使用数组arr储存，arr[0]为元素和，arr[1]为节点个数
        arr[0] = left[0] + right[0] + root.val;
        arr[1] = left[1] + right[1] + 1;
        
        // 更新包括当前根节点在内的平均值
        result = Math.max(result, (double) (arr[0]) / arr[1]);
        return arr;
    }
}