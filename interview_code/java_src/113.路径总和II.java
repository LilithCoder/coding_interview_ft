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
    // 回溯算法
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(root, track, sum, res);
        return res;
    }
    
    private void backtrack(TreeNode root, LinkedList<Integer> track, int sum, List<List<Integer>> res) {
        if (root == null) return;
        // 条件满足：当遍历到叶结点，如果sum - root.val == 0，将路径加入res
        if (root.left == null && root.right == null && sum - root.val == 0) {
            track.addLast(root.val);
            res.add(new LinkedList<>(track));
            track.removeLast();
            return;
        }
        // 做选择
        if (root.left != null) {
            track.addLast(root.val);
            backtrack(root.left, track, sum - root.val, res);
            track.removeLast();
        }
        if (root.right != null) {
            track.addLast(root.val);
            backtrack(root.right, track, sum - root.val, res);
            track.removeLast();
        }
    }
}