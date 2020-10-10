/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // 本题思路：
    // 层序遍历
    // 序列化，反序列化
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val + ",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (!nodes[index].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(curr.left);
            }
            index++;
            if (!nodes[index].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(curr.right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));