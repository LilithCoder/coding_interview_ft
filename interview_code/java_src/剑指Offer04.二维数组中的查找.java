class Solution {
    // 本题思路：
    // 从矩阵的右上角开始匹配，如果匹配到了，返回true
    // 如果值比target小，则说明这一行都比target小，row往下移一行
    // 如果值比target大，说明这一列都比target大，column往左移一行
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }
}