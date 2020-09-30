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
    // 迭代 #1
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.addFirst(curr.val);
            if (curr.left != null) stack.add(curr.left);
            if (curr.right != null) stack.add(curr.right);
        }
        return res;
    }
    
    // 迭代 #2
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null; // 记录上一个经过的结点
        while (!stack.isEmpty() || curr != null) {
            // 左子结点一路压栈下去
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            // 当遍历完左子树发现右子结点为空或者从右子树上来回到根结点的时候，就直接返回根结点的上层
            if (curr.right == null || curr.right == prev) {
                res.add(curr.val);
                stack.pop();
                prev = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }
        return res;
    }
    
    // 递归方式
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left != null) helper(root.left, res);
        if (root.right != null) helper(root.right, res);
        res.add(root.val);
    }
}