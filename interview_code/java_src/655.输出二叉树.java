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
    // 递归
    public List<List<String>> printTree(TreeNode root) {
        int height = get_height(root);
        String[][] temp = new String[height][(int)Math.pow(2, height) - 1];
        // 初始化二维字符串数组
        for (String[] row: temp) {
            Arrays.fill(row, "");
        }
        int left = 0;
        int right = temp[0].length - 1;
        int level = 0;
        fill_matrix(root, temp, left, right, level);
        List<List<String>> res = new ArrayList<>();
        for (String[] row: temp) {
            res.add(Arrays.asList(row));
        }
        return res;
    }
    // 返回二叉树的高度
    private int get_height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(get_height(root.left), get_height(root.right)) + 1;
    }
    // 通过填充matrix打印二叉树
    private void fill_matrix(TreeNode root, String[][] temp, int left, int right, int level) {
        if (root == null) return;
        int mid = (left + right) / 2;
        temp[level][mid] = String.valueOf(root.val);
        fill_matrix(root.left, temp, left, mid - 1, level + 1);
        fill_matrix(root.right, temp, mid + 1, right, level + 1);
    }
}