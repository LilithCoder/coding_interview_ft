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
    // 回溯算法，遍历每个可能的路径，符合条件加入res
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(root, track, res, sum);
        return res;
    }
    public void backtrack(TreeNode root, LinkedList<Integer> track, List<List<Integer>> res, int sum) {
        if (root == null) return;
        // 符合条件：当前结点为叶结点，且sum - root.val == 0
        if (root.left == null && root.right == null && sum - root.val == 0) {
            track.addLast(root.val);
            res.add(new LinkedList<>(track));
            track.removeLast();
        }
        
        track.addLast(root.val);
        backtrack(root.left, track, res, sum - root.val);
        track.removeLast();
        
        track.addLast(root.val);
        backtrack(root.right, track, res, sum - root.val);
        track.removeLast();
    }
}