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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        dfs_serialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
    
    private void dfs_serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        dfs_serialize(root.left, sb);
        dfs_serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s: data.substring(1, data.length() - 1).split(",")) {
            nodes.addLast(s);
        }
        return dfs_deserialize(nodes);
    }
    
    private TreeNode dfs_deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if (first.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = dfs_deserialize(nodes);
        root.right = dfs_deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));