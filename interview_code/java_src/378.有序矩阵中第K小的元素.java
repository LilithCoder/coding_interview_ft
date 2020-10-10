class Solution {
    // 本题思路：
    // 归并排序
    // 这个矩阵的每一行均为一个有序数组。问题即转化为从这 n 个有序数组中找第 k 大的数，可以想到利用归并排序的做法
    // 一般归并排序是两个数组归并，而本题是 n 个数组归并，所以需要用小根堆维护
    // 每行第一个元素总是该行最小的，最小堆维护每行的第一个元素，所以最小堆的最小元素一定是现矩阵最小的元素
    // 具体如何归并，可以参考力扣 23. 合并K个排序链表。
    class Point {
        int val;
        int row;
        int col;
        public Point(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Point> pqueue = new PriorityQueue<>((a, b) -> {return a.val - b.val;});
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pqueue.add(new Point(matrix[i][0], i, 0));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = pqueue.poll();
            int new_row = curr.row;
            int new_col = curr.col + 1;
            // 确保新的一点没有超出范围
            if (new_col != n) {
                int new_val = matrix[new_row][new_col];
                pqueue.add(new Point(matrix[new_row][new_col], new_row, new_col));
            }
        }
        return pqueue.poll().val;
    }
}