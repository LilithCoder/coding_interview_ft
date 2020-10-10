class Solution {
    // 本题思路：
    // 滑动窗口
    // 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
    // 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
    // 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果，那么我们已经找到了一个 i 开头的序列，也是唯一一个 i 开头的序列，接下来需要找 i+1 开头的序列，所以窗口的左边界要向右移动
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sum = 0;
        while (right < target) {
            // 右移动窗口，这时候窗口之和一定是小于target
            sum += right;
            right++;
            
            // 缩小窗口，左移动窗口直到窗口之和小于等于target
            while (sum > target) {
                sum -= left;
                left++;
            }
            // 如果窗口的sum等于target
            if (sum == target) {
                // 注意：这里不需要+1，因为前面right++过了
                int[] temp = new int[right - left];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left + i;
                }
                list.add(temp);
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}