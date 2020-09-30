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
    // 迭代1
    // 从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。
    // 先序：top->bottom, left->right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) {
                stack.add(curr.right);
            }
            if (curr.left != null) {
                stack.add(curr.left);
            }
        }
        return res;
    }
    
    // 迭代2
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 往左压入栈
            while (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }
    
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) helper(root.left, res);
        if (root.right != null) helper(root.right, res);
    }
}