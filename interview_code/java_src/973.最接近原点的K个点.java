class Solution {
    // 本题思路：
    // 构建一个最小堆，根据point到原点的距离从小到大堆排序
    // 然后poll出去K个point，就是最接近原点的 K 个点
    class Point {
        private int x;
        private int y;
        private int dist;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = x * x + y * y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        // 根据point到原点的距离从小到大堆排序，最小堆
        PriorityQueue<Point> min_heap = new PriorityQueue<>((point1, point2) -> {
            return point1.dist - point2.dist;
        });
        for (int[] point: points) {
            min_heap.add(new Point(point[0], point[1]));
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point curr = min_heap.poll();
            res[i] = new int[] {curr.x, curr.y};
        }
        return res;
    }
}