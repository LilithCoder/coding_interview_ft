class Solution {
    // 本题思路：
    // 可以模拟螺旋矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，当路径超出界限或者进入之前访问过的位置时，则顺时针旋转，进入下一个方向。
    // 判断路径是否进入之前访问过的位置需要使用一个与输入矩阵大小相同的辅助矩阵visited
    // 当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回。
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int row = 0;
        int col = 0;
        // 顺时针螺旋顺序
        int[][] direction = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 决定用哪个遍历方向
        int direction_index = 0;
        for (int i = 0; i < m * n; i++) {
            visited[row][col] = true;
            res.add(matrix[row][col]);
            int next_row = row + direction[direction_index][0];
            int next_col = col + direction[direction_index][1];
            if (next_row < 0 || next_row >= m || next_col < 0 || next_col >= n || visited[next_row][next_col] == true) {
                direction_index = (direction_index + 1) % 4;
            }
            row += direction[direction_index][0];
            col += direction[direction_index][1];
        }
        return res;
    }
}