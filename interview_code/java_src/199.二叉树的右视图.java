/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
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
    // dfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }
    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;
        if (depth++ == result.size()) result.add(root.val);
        dfs(root.right, result, depth);
        dfs(root.left, result, depth);
    }
}

class Solution {
    // bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr_node = queue.remove();
                if (curr_node.left != null) queue.add(curr_node.left);
                if (curr_node.right != null) queue.add(curr_node.right);
                if (i == size - 1) result.add(curr_node.val);
            }
        }
        return result;
    }
}
// @lc code=end

