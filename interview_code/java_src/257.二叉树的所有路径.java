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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder track = new StringBuilder();
        backtrack(root, res, track);
        return res;
    }
    private void backtrack(TreeNode root, List<String> res, StringBuilder track) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(track.toString() + String.valueOf(root.val));
            return;
        }
        String temp = String.valueOf(root.val) + "->";
        // 做选择
        if (root.left != null) {
            track.append(temp);
            backtrack(root.left, res, track);
            // StringBuilder可以使用制定删除区间的delete(from, to)
            track.delete(track.length() - temp.length(), track.length());
        }
        if (root.right != null) {
            track.append(temp);
            backtrack(root.right, res, track);
            // StringBuilder可以使用制定删除区间的delete(from, to)
            track.delete(track.length() - temp.length(), track.length());
        }
    }
}