/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 本题思路：
    // 将二叉树展开为单链表之后，单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序。
    // 因此，可以对二叉树进行前序遍历，获得各节点被访问到的顺序。
    // 由于将二叉树展开为链表之后会破坏二叉树的结构，因此在前序遍历结束之后更新每个节点的左右子节点的信息，将二叉树展开为单链表。
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        pre_order(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode curr = list.get(i);
            TreeNode nxt = list.get(i + 1);
            curr.left = null;
            curr.right = nxt;
        }
    }
    
    public void pre_order(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        pre_order(root.left, list);
        pre_order(root.right, list);
    }
}