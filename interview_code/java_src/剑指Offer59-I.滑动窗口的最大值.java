class Solution {
    // 本题思路：
    // 单调队列模板题，求滑动窗口的最值。
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序 队头 <- 队尾 单调增大
        LinkedList<Integer> queue = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小 弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断队首的值是否在窗口范围内
            if (!queue.isEmpty() && i - queue.peekFirst() >= k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }
        return res;
    }
}