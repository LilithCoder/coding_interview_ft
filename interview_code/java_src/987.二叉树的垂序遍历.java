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
    class Coord {
        private int x;
        private int y;
        private int val;
        Coord(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Coord> coords = new ArrayList<>();
        
        // dfs遍历，将所有节点的坐标加入coords
        dfs(root, 0, 0, coords);
        // 排序所有结点
        Collections.sort(coords, (a, b) -> {
            if (a.x != b.x) {
                // 先根据x坐标排序
                return a.x - b.x;
            } else if (a.x == b.x && a.y != b.y){
                // 当x坐标相同时，从上到下排序
                return b.y - a.y;
            } else {
                // 当两个结点的坐标值相同，根据结点值从小到大排序
                return a.val - b.val;
            }
        });
        int prev_x = coords.get(0).x;
        res.add(new ArrayList<Integer>());
        // 根据x的变化分段存入res
        for (Coord c: coords) {
            if (c.x != prev_x) {
                res.add(new ArrayList<Integer>());
                res.get(res.size() - 1).add(c.val);
                prev_x = c.x;
            } else {
                res.get(res.size() - 1).add(c.val);
            }
        }
        return res;
    }
    
    private void dfs(TreeNode root, int x, int y, List<Coord> coords) {
        if (root == null) return;
        Coord curr = new Coord(x, y, root.val);
        coords.add(curr);
        dfs(root.left, x - 1, y - 1, coords);
        dfs(root.right, x + 1, y - 1, coords);
    }
}