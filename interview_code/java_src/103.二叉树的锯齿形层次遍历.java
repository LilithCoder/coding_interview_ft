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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean if_reversed = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                // 只需要在加入temp的时候顺序翻转一下就可以了，跟queue没关系
                if (if_reversed) {
                    temp.addFirst(curr.val);
                } else {
                    temp.addLast(curr.val);
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(temp);
            if_reversed = !if_reversed;
        }
        return res;
    }
}