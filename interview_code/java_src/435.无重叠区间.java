class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval_a, int[] interval_b) {
                return interval_a[1] - interval_b[1];
            }
        });
        // 无重叠区间计数
        int count = 1;
        int end = intervals[0][1];
        for (int[] interval: intervals) {
            int start = interval[0];
            if (start >= end) {
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}