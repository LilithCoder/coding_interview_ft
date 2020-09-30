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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希表，目的在快速定位根结点，key为结点，value为index
        Map<Integer, Integer> index_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index_map.put(inorder[i], i);
        }
        return build_tree(preorder, inorder, index_map, 0, n - 1, 0, n - 1);
    }

    // 前序：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    // 中序：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
    private TreeNode build_tree(int[] preorder, int[] inorder, Map<Integer, Integer> index_map, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        // 前序遍历的第一个结点就是根结点
        int preorder_root = preorder_left;
        // 中序遍历中定位根结点的index
        int inorder_root = index_map.get(preorder[preorder_root]);
        // 先把根结点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 左子树的大小
        int size_lefttree = inorder_root - inorder_left;
        // 递归地构造左子树，连接到根结点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = build_tree(preorder, inorder, index_map, preorder_root + 1, preorder_root + size_lefttree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = build_tree(preorder, inorder, index_map, preorder_left + size_lefttree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}