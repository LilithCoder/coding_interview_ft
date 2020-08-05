/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public class interval_comparator implements Comparator<int[]> {
        @Override
        public int compare(int[] interval_a, int[] interval_b) {
            return interval_a[0] - interval_b[0];
        }
    }
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> merge = new ArrayList<>();
        Arrays.sort(intervals, new interval_comparator());
        for (int[] interval: intervals) {
            if (merge.isEmpty()) {
                merge.add(interval);
            } else {
                int curr_interval_left = interval[0];
                int curr_interval_right = interval[1];
                int last_interval_left = merge.get(merge.size() - 1)[0];
                int last_interval_right = merge.get(merge.size() - 1)[1];
                if (curr_interval_left > last_interval_right) {
                    merge.add(interval);
                } else {
                    int[] new_interval = {last_interval_left, Math.max(last_interval_right, curr_interval_right)};
                    merge.set(merge.size() - 1, new_interval);
                }
            }
        }
        int[][] result = new int[merge.size()][2];
        for (int i = 0; i < merge.size(); i++) {
            result[i] = merge.get(i);
        }
        return result;
    }
}
// @lc code=end

