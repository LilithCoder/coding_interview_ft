class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] balloon_a, int[] balloon_b) {
                return balloon_a[1] - balloon_b[1];
            }
        });
        // 如果最多有 n 个不重叠的区间，那么就至少需要 n 个箭头穿透所有区间
        int count = 1;
        int end = points[0][1];
        for (int[] balloon: points) {
            int start = balloon[0];
            if (start > end) {
                count++;
                end = balloon[1];
            }
        }
        return count;
    }
}