class Solution {
    // 本题思路：
    // 按照开始时间对会议进行排序。接着依次遍历会议，检查它是否在下个会议开始前结束。
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {return a[0] - b[0];});
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}