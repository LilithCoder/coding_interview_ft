class Solution {
    // 本题思路：
    // 思路就是二分查找，一维数组和二维数组可以有index上转化
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int curr = matrix[mid / n][mid % n];
            if (curr == target) {
                return true;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}